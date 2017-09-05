package com.tribes.algorithms.sorting.common;


public abstract class Analyzable {
    /**
     * 排序算法中移位的次数
     */
    private int modifyCount;

    /**
     * 排序算法的运行时长
     */
    private double duration;

    /**
     * 输入的集合大小
     */
    private int size;

    /**
     * 计时器
     */
    private Stopwatch stopwatch;

    /**
     * 获取一次排序中移动元素的次数
     *
     * @return 一次排序中移动元素的次数
     */
    protected int getModifyCount() {
        return modifyCount;
    }

    /**
     * 调用一次排序方法所用时长
     *
     * @return 一次排序方法所用时长 (毫秒)
     */
    protected double getDuration() {
        return duration;
    }

    /**
     * 累加移位次数
     *
     */
    protected void setModifyCount() {
        this.modifyCount += 1;
    }

    /**
     * 赋值数组元素数量
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 开始计时
     */
    protected void startSorting(int size) {
        this.duration = 0.0f;
        this.modifyCount = 0;
        this.size = size;
        this.stopwatch = new Stopwatch();
    }

    /**
     * 结束计时
     */
    protected void endSorting() {
        this.duration = this.stopwatch.elapsedTime();
        this.stopwatch = null;
    }

    /**
     * 标准输出
     */
    @Override
    public String toString() {
        return "Sorting {" +
                "algorithms=" + this.getClass().getName() +
                ", arraySize=" + this.size +
                ", modifyCount=" + this.modifyCount +
                ", duration=" + this.duration +
                '}';
    }
}
