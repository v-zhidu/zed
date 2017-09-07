package com.tribes.algorithms.sorting.common;

import com.tribes.algorithms.utils.ArrayUtil;
import com.tribes.dataStructure.list.LinkedList;
import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import io.bretty.console.table.Alignment;
import io.bretty.console.table.ColumnFormatter;
import io.bretty.console.table.Precision;
import io.bretty.console.table.Table;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 排序算法模版类，包含算法常用的基本操作以及定义子类应实现的基本方法
 *
 * @param <T> 待排序元素的数据类型, 需实现了<code>Comparable</code> 接口
 * @link https://visualgo.net/en/sorting
 * @see Sorting 排序算法抽象类
 * @see Comparable 比较接口
 */
public abstract class Sorting<T extends Comparable> extends Analyzable {

    /**
     * 比较函数
     *
     * @return <tt>true</tt> if a < b
     */
    @SuppressWarnings("unchecked")
    protected boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 比较函数
     *
     * @return <tt>true</tt> a > b && orderType == OrderType.ASCENDING
     * <tt>true</tt> a < b && orderType == OrderType.DESCENDING
     */
    @SuppressWarnings("unchecked")
    protected boolean less(Object a, Object b, Comparator comparator) {
        return comparator.compare(a, b) < 0;
    }

    /**
     * 控制台输出
     *
     * @param array 待输出数组
     */
    protected void show(Object[] array) {
        StdOut.println(Arrays.toString(array));
    }

    protected boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    protected boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }

    protected boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i - 1], comparator))
                return false;
        return true;
    }

    protected boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length, comparator);
    }

    /**
     * 数组变化可视化
     * @param a 数组
     */
    protected void visual(Comparable[] a) {
        StdDraw.clear();
        for (int i = 0; i < a.length; i++) {
            double x = 1.0 * i / a.length;
            double y = (double) a[i] / 2.0;
            double rw = 0.5 / a.length;
            double rh = (double) a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
            StdDraw.pause(0);
        }
    }

    /**
     * 内置的算法评估方法
     * <p>
     * 测试的数组类型包括 (随机数组，接近有序数组，逆序数组，有序数组)
     * 数组大小 ()
     */
    protected void evaluate(Integer[] sizes, int iteration) {
        Double[][] durations = new Double[12][sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            // 随机序列
            durations[0][i] = executeSorts(1, 1, sizes[i], iteration);
            durations[1][i] = executeSorts(2, 1, sizes[i], iteration);
            durations[2][i] = executeSorts(3, 1, sizes[i], iteration);

            // 接近有序序列
            durations[3][i] = executeSorts(1, 2, sizes[i], iteration);
            durations[4][i] = executeSorts(2, 2, sizes[i], iteration);
            durations[5][i] = executeSorts(3, 2, sizes[i], iteration);

            // 有序序列
            durations[6][i] = executeSorts(1, 3, sizes[i], iteration);
            durations[7][i] = executeSorts(2, 3, sizes[i], iteration);
            durations[8][i] = executeSorts(3, 3, sizes[i], iteration);

            // 逆序序列
            durations[9][i] = executeSorts(1, 4, sizes[i], iteration);
            durations[10][i] = executeSorts(2, 4, sizes[i], iteration);
            durations[11][i] = executeSorts(3, 4, sizes[i], iteration);
        }
        StdOut.println("algorithms: " + this.getClass().getName() + ", iteration times: " + iteration);
        StdOut.println();
        StdOut.println(buildTable(sizes, durations));
    }

    private double executeSorts(int method, int type, int n, int iteration) {
        AscIntegerComparator comparator = new AscIntegerComparator();
        Accumulator accumulator = new Accumulator();
        if (method == 1) {
            Comparable[] array = generateArray(type, n);
            for (int i = 0; i < iteration; i++) {
                this.sort(array);
                accumulator.addDataValue(this.getDuration());
            }
        } else if (method == 2) {
            for (int i = 0; i < iteration; i++) {
                this.sort(generateArray(type, n), comparator);
                accumulator.addDataValue(this.getDuration());
            }
        } else {
            LinkedList<Comparable> list = new LinkedList<>();
            for (int i = 0; i < iteration; i++) {
                list.clear();
                Comparable[] array = generateArray(type, n);
                assert array != null;
                list.addAll(Arrays.asList(array));
                this.sort(list, comparator);
                accumulator.addDataValue(this.getDuration());
            }
        }

        return accumulator.mean();
    }

    private Comparable[] generateArray(int type, int n) {
        if (type == 1) {
            return ArrayUtil.randomInt(n);
        } else if (type == 2) {
            return ArrayUtil.nearlyInt(n);
        } else if (type == 3) {
            return ArrayUtil.sortedInt(n, new AscIntegerComparator());
        } else {
            return ArrayUtil.sortedInt(n, new DescIntegerComparator());
        }
    }

    /**
     * 打印评估结果
     *
     * @param sizes     测试数组的大小集合
     * @param durations 二维数组
     * @return 返回字符串
     */
    private String buildTable(Integer[] sizes, Double[][] durations) {
        String headers = "|   n   |" +
                "              random               |" +
                "              nearly               |" +
                "              sorted               |" +
                "              reverse              |";
        StdOut.println(headers);
        ColumnFormatter<Number> numberColumnFormatter = ColumnFormatter.number(Alignment.RIGHT, 7, Precision.ZERO);
        ColumnFormatter<Number> durationColumnFormatter = ColumnFormatter.number(Alignment.CENTER, 11, Precision.SEVEN);

        Table.Builder builder = new Table.Builder("", sizes, numberColumnFormatter);
        for (int i = 0; i < 4; i++) {
            builder.addColumn("basic", durations[3 * i], durationColumnFormatter);
            builder.addColumn("value", durations[3 * i + 1], durationColumnFormatter);
            builder.addColumn("point", durations[3 * i + 2], durationColumnFormatter);
        }

        return builder.build().toString();
    }


    /**
     * 基本的算法实现
     * <p>
     * 用来实现一般教材中的基本算法实现
     *
     * @param array 整型类型数组
     */
    public abstract void sort(Comparable[] array);

    /**
     * 支持升序或降序排列的算法
     *
     * @param array 基于值的集合
     */
    public abstract void sort(Comparable[] array, Comparator comparator);

    /**
     * 支持升序或降序排列的算法
     *
     * @param list 基于指针的集合
     */
    public abstract void sort(LinkedList<Comparable> list, Comparator comparator);
}
