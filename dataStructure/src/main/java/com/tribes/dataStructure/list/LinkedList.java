package com.tribes.dataStructure.list;

import java.util.Collection;

/**
 * Double-Linked List.
 * Append element to the tail.
 * Allow null element.
 *
 * @param <E> the type of element added into the list.
 * @author v-zhidu
 */
public class LinkedList<E> {

    private int size = 0;

    private int modCount = 0;

    private Node<E> first;

    private Node<E> last;

    /**
     * 双向结点
     *
     * @param <E> 放在结点数据域中的元素
     */
    public class Node<E> {
        public E item;
        public Node<E> prev;
        public Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Construct a empty list.
     */
    public LinkedList() {
    }

    /**
     * Construct a list with a collection of elements.
     *
     * @param c a collection of elements
     */
    public LinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    /**
     * <tt>true</tt> 如果列表不包含任何元素
     *
     * @return <tt>true</tt> 如果列表不包含任何元素
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * 返回列表中的元素数量
     *
     * @return 返回列表中的元素数量
     */
    public int size() {
        return size;
    }

    /**
     * 返回列表修改次数
     *
     * @return 返回列表修改次数
     */
    public int modCount() {
        return modCount;
    }

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> getLast() {
        return last;
    }

    /**
     * <tt>true</tt> 如果元素被正确插入，尾部插入
     *
     * @param e 插入列表的元素
     * @return <tt>true</tt> 如果元素被正确插入
     */
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * 批量添加元素
     *
     * @param c a collection of elements
     */
    public void addAll(Collection<? extends E> c) {

    }

    /**
     * 删除一个元素
     *
     * @param node 等待删除的元素
     * @return <tt>true</tt> 如果删除成功则返回被删除元素的值
     */
    public E remove(Node<E> node) {
        return unlink(node);
    }

    /**
     * 清空列表中的所有元素
     */
    public void clear() {

    }

    /**
     * 在某一结点前插入元素
     *
     * @param node    插入的结点前
     * @param element 等待插入的元素
     */
    public void insert(Node<E> node, E element) {

    }

    /**
     * 在末结点添加元素
     *
     * @param e 等待添加的元素
     */
    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    /**
     * 删除末结点
     *
     * @param l 末结点
     * @return 删除的结点值
     */
    private E unlinkLast(Node<E> l) {
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }

    private E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> prev = x.prev;
        final Node<E> next = x.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next =null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }
}
