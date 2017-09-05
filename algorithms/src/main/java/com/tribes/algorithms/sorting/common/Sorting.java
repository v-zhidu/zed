package com.tribes.algorithms.sorting.common;

import com.tribes.algorithms.utils.ArrayUtil;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import io.bretty.console.table.Alignment;
import io.bretty.console.table.ColumnFormatter;
import io.bretty.console.table.Precision;
import io.bretty.console.table.Table;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

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
     * 在数组中的某一个位置插入元素
     *
     * @param array 待插入数组
     * @param index 插入元素的索引位置
     * @param value 插入元素
     */
    protected void insert(Object[] array, int index, Comparable value) {
        System.arraycopy(array, index, array, index + 1, array.length - 1 - index);
        array[index] = value;
        super.setModifyCount();
    }

    /**
     * 移动链表中的一个元素
     *
     * @param list        链表
     * @param source      准备移动的索引
     * @param destination 目标位置
     */
    protected void insert(LinkedList<Comparable> list, int source, int destination) {
        list.add(destination, list.remove(source));
        super.setModifyCount();
    }

    /**
     * 交换数组中两个位置的元素
     *
     * @param i 元素索引
     * @param j 元素索引
     */
    protected void swap(Object[] array, int i, int j) {
        if (i == j)
            return;
        Object t = array[i];
        array[i] = array[j];
        array[j] = t;
        super.setModifyCount();
    }

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
     * 内置的算法评估方法
     * <p>
     * 测试的数组类型包括 (随机数组，接近有序数组，逆序数组，有序数组)
     * 数组大小 ()
     */
    protected void evaluate(Integer[] sizes) {
        BigDecimal[][] durations = new BigDecimal[12][sizes.length];
        Comparator comparator = new AscIntegerComparator();
        LinkedList<Comparable> list = new LinkedList<>();
        for (int i = 0; i < sizes.length; i++) {
            // 随机序列
            Integer[] randomArray = ArrayUtil.randomInt(sizes[i]);
            this.sort(randomArray);
            durations[0][i] = getDuration();

            StdRandom.shuffle(randomArray);
            this.sort(randomArray, comparator);
            durations[1][i] = getDuration();

            StdRandom.shuffle(randomArray);
            list.clear();
            list.addAll(Arrays.asList(randomArray));
            this.sort(list, comparator);
            durations[2][i] = getDuration();

            // 接近有序序列
            durations[3][i] = BigDecimal.ZERO;
            durations[4][i] = BigDecimal.ZERO;
            durations[5][i] = BigDecimal.ZERO;

            // 有序序列
            durations[6][i] = BigDecimal.ZERO;
            durations[7][i] = BigDecimal.ZERO;
            durations[8][i] = BigDecimal.ZERO;

            // 逆序序列
            durations[9][i] = BigDecimal.ZERO;
            durations[10][i] = BigDecimal.ZERO;
            durations[11][i] = BigDecimal.ZERO;
        }
        StdOut.println(this.getClass().getName());
        StdOut.println(buildTable(sizes, durations));
    }

    /**
     * 打印评估结果
     *
     * @param sizes     测试数组的大小集合
     * @param durations 二维数组
     * @return 返回字符串
     */
    private String buildTable(Integer[] sizes, BigDecimal[][] durations) {
        String headers = "|   n   |" +
                "              random               |" +
                "              nearly               |" +
                "              sorted               |" +
                "              reverse              |";
        StdOut.println(headers);
        ColumnFormatter<Number> numberColumnFormatter = ColumnFormatter.number(Alignment.CENTER, 7, Precision.ZERO);
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
