package com.tribes.dataStructure;

import java.util.function.Predicate;
import java.util.stream.Stream;

public interface Collection<E> extends Iterable<E> {

    //region Query operation

    /**
     * 返回迭代器
     *
     * @return 返回迭代器
     */
    @Override
    Iterator<E> iterator();

    /**
     * 返回当前存储在集合中的元素个数
     *
     * @return 返回存储在集合中的元素个数
     */
    int size();

    /**
     * 如果集合中没有元素，返回true
     *
     * @return <tt>true</tt> 如果集合中没有元素
     */
    boolean isEmpty();

    /**
     * 如果集合中包含一个与obj相等的对象，返回true
     *
     * @param o 待检测的元素
     * @return <tt>true</tt> 如果集合中包含一个与obj相等的对象
     * @throws ClassCastException 如果指定的元素和集合中的元素类型不兼容，
     *         则抛出类型转换异常
     * @throws NullPointerException 如果指定的元素为空并且当前集合不允许存储
     *         空类型元素，则抛出空指针异常
     */
    boolean contains(Object o);

    /**
     * 返回这个集合的对象数组
     *
     * 这个方法会重新构造一个新的数组，与集合中的元素没有引用关系，所以调用者可以修改数组中的值
     *
     * @return 以合适的顺序返回集合中的所有元素
     */
    Object[] toArray();

    /**
     * 返回这个集合的对象数组
     *
     * @param a 如果数组空间足够大，则将集合中的元素填入这个数组，剩余空间填补null;
     *          否则，分配一个新的数组，其成员类型和a相同，长度等于集合的大小，并填充集合元素。
     * @return 一个包含集合中元素的数组
     * @throws ArrayStoreException 如果数组类型和集合中的元素类型不匹配
     * @throws NullPointerException 如果数组为空
     */
    <T> T[] toArray(T[] a);

    //endregion

    //region Modified operation

    /**
     * 将一个元素添加到集合中国呢
     *
     * @param e 待添加的元素
     * @return 如果由于这个调用修改了集合，则返回<tt>true</tt>
     * @throws UnsupportedOperationException 集合不支持添加操作
     * @throws ClassCastException 集合不支持添加当前元素的类型
     * @throws NullPointerException 待添加元素为null并且当前集合不允许存储null元素
     * @throws IllegalArgumentException 待添加元素的某些属性不允许添加到集合中
     */
    boolean add(E e);

    /**
     * 从这个集合中删除等于o的对象
     *
     * @param o 待删除元素
     * @return 如果匹配的对象被删除，返回true
     * @throws UnsupportedOperationException 集合不支持删除操作
     * @throws ClassCastException 指定的元素和集合中的元素类型不匹配
     * @throws NullPointerException 指定的元素为空并且集合不允许存储null元素
     */
    boolean remove(Object o);

    //endregion

    //region Bulk operation

    /**
     * 如果集合中包含另外一个集合中的所有元素，则返回true
     *
     * @param c 待检查的集合
     * @throws ClassCastException 如果另外一个集合中的元素和当前集合中的元素类型不匹配
     * @throws NullPointerException 如果另外一个集合中包含一个或多个null元素而当前
     *         集合不允许存储null
     */
    boolean containsAll(Collection<?> c);

    /**
     * 将另外一个集合中的元素添加到当前集合
     *
     * @param c 待添加的集合
     * @throws UnsupportedOperationException 集合不支持添加操作
     * @throws ClassCastException 集合不支持添加当前元素的类型
     * @throws NullPointerException 待添加元素为null并且当前集合不允许存储null元素
     * @throws IllegalArgumentException 待添加元素的某些属性不允许添加到集合中
     * @throws IndexOutOfBoundsException 超出集合边界
     */
    boolean addAll(Collection<? extends E> c);

    /**
     * 从这个集合中删除c集合中存在的所有元素
     * @return 如果改变了集合，则返回<tt>true</tt>
     *
     * @throws UnsupportedOperationException 集合不支持删除操作
     * @throws ClassCastException 指定的元素和集合中的元素类型不匹配
     * @throws NullPointerException 指定的元素为空并且集合不允许存储null元素
     */
    boolean removeAll(Collection<?> c);

    /**
     * 从这个集合中删除所有与c集合中不同的元素
     *
     * @return 如果改变了集合，则返回<tt>true</tt>
     */
    boolean retainAll(Collection<?> c);

    /**
     * 从这个集合中删除所有的元素
     *
     * @throws UnsupportedOperationException 如果集合不支持清空操作
     */
    void clear();

    //endregion

    //region Comparison amd hashing

    boolean equals(Object o);

    int hashCode();

    //endregion

    //region  TODO(du_zhi_qiang@163.com): Collection Java 1.8 新增的方法, 暂时放下

    boolean removeIf(Predicate<? super E> filter);

    @Override
    Spliterator<E> spliterator();

    Stream<E> stream();

    Stream<E> parallelStream();

    //endregion
}
