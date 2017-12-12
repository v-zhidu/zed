package com.tribes.dataStructure;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * 一个集合中的迭代器，取代了旧版本中Enumeration接口
 *
 * @param <E> 迭代器返回元素的具体类型
 * @author duzhiqiang
 * @since Java 1.2
 */
public interface Iterator<E> {

    /**
     * 返回 {@code true} 如果集合中还有元素可以迭代
     * @return {@code true} 如果集合中还有元素可以迭代
     */
    boolean hasNext();

    /**
     * 返回集合中的下一个元素
     *
     * @return 返回集合中的下一个元素
     * @throws java.util.NoSuchElementException 如果已经迭代到了集合的尾部
     */
    E next();

    /**
     * 删除上次访问的对象，提供在遍历集合的同时删除集合元素的能力
     *
     * @throws UnsupportedOperationException 当前迭代器不支持这个操作
     * @throws IllegalStateException 这个方法必须紧跟在访问一个元素之后执行，
     * 如果上次访问之后，集合已经发生了变化，这个方法将抛出一个IllegalStateException
     */
    default void remove() {
        throw new UnsupportedOperationException();
    }

    /**
     * //TODO (du_zhi_qiang@163.com): forEachRemaining，lambda表达式相关，暂时放下
     * @param action
     */
    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}
