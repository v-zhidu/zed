package com.tribes.algorithms.sorting.common;

import java.util.LinkedList;

public abstract class Sorting<T extends Comparable> extends Analyzable {

    /**
     * 在数组中的某一个位置插入元素
     *
     * @param array 待插入数组
     * @param index 插入元素的索引位置
     * @param value 插入元素的位置
     */
    protected static void insert(Comparable[] array, int index, Comparable value) {
        throw new UnsupportedOperationException("insert");
    }

    /**
     * 比较函数
     *
     * @return <tt>true</tt> if a < b
     */
    @SuppressWarnings("unchecked")
    protected static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 比较函数
     *
     * @return <tt>true</tt> a > b && orderType == OrderType.ASCENDING
     * <tt>true</tt> a < b && orderType == OrderType.DESCENDING
     */
    @SuppressWarnings("unchecked")
    protected static boolean less(Comparable a, Comparable b, OrderType orderType) {
        if (orderType == OrderType.ASCENDING && a.compareTo(b) < 0)
            return true;
        else if (orderType == OrderType.DESCENDING && a.compareTo(b) > 0)
            return true;
        else
            return false;
    }

    /**
     * 交换数组中两个位置的元素
     *
     * @param i 元素索引
     * @param j 元素索引
     */
    protected void swap(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
        super.setModifyCount();
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
    public abstract void sort(T[] array, OrderType orderType);

    /**
     * 支持升序或降序排列的算法
     *
     * @param array 基于指针的集合
     */
    public abstract void sort(LinkedList<T> array, OrderType orderType);
}
