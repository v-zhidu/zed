package com.tribes.algorithms.sorting;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

/**
 * 排序算法通用抽象类
 *
 * @param <T> 待排序元素的数据类型
 */
abstract class Sorting<T extends Comparable<T>> {

    /**
     * 排序算法中移位的次数
     */
    private int modifyCount;

    /**
     * 排序算法的运行时长
     */
    private long duration;

    /**
     * 标记开始计时的时间点
     */
    private long startDate;

    /**
     * 获取一次排序中移动元素的次数
     *
     * @return 一次排序中移动元素的次数
     */
    public int getModifyCount() {
        return modifyCount;
    }

    /**
     * 调用一次排序方法所用时长
     *
     * @return 一次排序方法所用时长 (毫秒)
     */
    public long getDuration() {
        return duration;
    }

    /**
     * 累加移位次数
     *
     * @param times 移动元素的次数
     */
    void setModifyCount(int times) {
        this.modifyCount += times;
    }

    /**
     * 开始计时
     */
    void startSorting() {
        this.duration = 0;
        this.startDate = new Date().getTime();
    }

    /**
     * 结束计时
     */
    void endSorting() {
        this.duration = new Date().getTime() - this.startDate;
    }

    /**
     * 标准输出
     */
    @Override
    public String toString() {
        return "Sorting{" +
                "modifyCount=" + modifyCount +
                ", duration=" + duration +
                '}';
    }

    /**
     * 排序算法
     *
     * @param array 基于值的集合
     */
    public abstract void sort(T[] array);

    /**
     * 排序算法
     *
     * @param array 基于指针的集合
     */
    public abstract void sort(LinkedList<T> array);
}
