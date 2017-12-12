package com.tribes.dataStructure;

import java.util.function.Consumer;

/**
 * 实现这个接口允许一个对象使用for-each循环语句
 *
 * @param <T> 迭代器返回元素的类型
 */
public interface Iterable<T> {

    /**
     * 返回迭代器
     *
     * @return 返回迭代器
     */
    Iterator<T> iterator();

    //region TODO(du_zhi_qiang@163.com): Java 1.8新增方法，暂时放下

    void forEach(Consumer<? super T> action);

    Spliterator<T> spliterator();

    //endregion
}
