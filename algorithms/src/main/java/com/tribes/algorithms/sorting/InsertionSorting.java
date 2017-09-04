package com.tribes.algorithms.sorting;

import com.tribes.algorithms.sorting.common.OrderType;
import com.tribes.algorithms.sorting.common.Sorting;
import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;

/**
 * 插入排序算法
 *
 * @param <T> 待排序元素的数据类型, 需实现了<code>Comparable</code> 接口
 * @see Sorting 排序算法抽象类
 * @see Comparable 比较接口
 */
public class InsertionSorting<T extends Comparable> extends Sorting<T> {

    /**
     * 单元测试方法
     */
    public static void main(String[] args) {
        //通用输入
        InsertionSorting<Integer> sorting = new InsertionSorting<>();

        sorting.sort(new Integer[]{3, 1, 3, 2, 4, 5});
        StdOut.println(sorting.toString());
    }

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
    public void sort(T[] array, OrderType orderType) {
        //TODO (du_zhi_qiang@163.com) 有代码侵入，考虑能否利用切面实现
        super.startSorting(array.length);

        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            T value = array[i];
            while (j >= 0 && less(value, array[j], orderType)) {
                array[j + 1] = array[j];
                j--;
                super.setModifyCount();
            }
            array[j + 1] = value;
        }

        super.endSorting();
    }

    /**
     * 支持升序或降序排列的算法
     *
     * @param array 基于指针的集合
     */
    @Override
    public void sort(LinkedList<T> array, OrderType orderType) {
        throw new UnsupportedOperationException("sort");
    }
}
