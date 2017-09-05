package com.tribes.algorithms.sorting;

import com.tribes.algorithms.sorting.common.Sorting;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * 插入排序算法
 *
 * @param <T> 待排序元素的数据类型, 需实现了<code>Comparable</code> 接口
 * @see Sorting 排序算法抽象类
 * @see Comparable 比较接口
 */
public class InsertionSorting<T extends Comparable> extends Sorting<Comparable> {

    /**
     * 基本的算法实现
     * <p>
     * 用来实现一般教材中的基本算法实现
     *
     * @param array 整型类型数组
     */
    @Override
    public void sort(Comparable[] array) {
        super.startSorting(array.length);

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--)
                swap(array, j, j - 1);
        }

        super.endSorting();
    }

    /**
     * 支持升序或降序排列的算法
     *
     * @param array 基于值的集合
     */
    @Override
    public void sort(Comparable[] array, Comparator comparator) {
        //TODO (du_zhi_qiang@163.com) 有代码侵入，考虑能否利用切面实现
        super.startSorting(array.length);

        for (int i = 1; i < array.length; i++) {
            int pos = i;
            for (int j = i; j > 0 && less(array[i], array[j - 1], comparator); j--)
                pos--;
            if (pos != i) {
                insert(array, pos, array[i]);
            }

        }

        super.endSorting();
    }

    /**
     * 支持升序或降序排列的算法
     *
     * @param list 基于指针的集合
     */
    @Override
    public void sort(LinkedList<Comparable> list, Comparator comparator) {
        super.startSorting(list.size());

        for (int i = 1; i < list.size(); i++) {
            int pos = i;
            for (int j = i; j > 0 && less(list.get(i), list.get(j - 1), comparator); j--)
                pos--;
            if (pos != i) {
                insert(list, i, pos);
            }

        }

        super.endSorting();
    }

    /**
     * 单元测试方法
     */
    public static void main(String[] args) {
        InsertionSorting<Integer> sorting = new InsertionSorting<>();

//        LinkedList<Comparable> list = ArrayUtil.random(5);
//        sorting.show(list.toArray());
//        sorting.sort(list, new AscIntegerComparator());
//        sorting.show(list.toArray());
//        StdOut.println(sorting.toString());
        sorting.evaluate(new Integer[]{10, 50, 100, 500, 1000, 10000});
    }
}