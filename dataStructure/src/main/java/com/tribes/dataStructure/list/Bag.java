package com.tribes.dataStructure.list;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 背包数据类型
 * <p>
 * 背包本质是头部插入的单链表，是一种不支持从中删除元素的集合数据类型
 * 它的目的就是帮助用例收集元素并迭代遍历所有元素
 *
 * @author v-zhidu
 */
public class Bag<E> implements Iterable<E> {

    /**
     * 背包元素计数器
     */
    private int size;

    /**
     * 头指针
     */
    private Node<E> first;

    /**
     * 创建一个空的背包
     */
    public Bag() {
        this.size = 0;
        this.first = null;
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            bag.add(item);
        }

        StdOut.println("size of bag = " + bag.size());
        for (String s : bag) {
            StdOut.println(s);
        }
    }

    /**
     * 添加一个元素
     *
     * @param e 待添加的元素
     */
    public void add(E e) {
        Node<E> oldFirst = first;
        this.first = new Node<>(e, oldFirst);
        this.size++;
    }

    /**
     * 背包是否为空
     *
     * @return <tt>true</tt> 如果背包为空
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 背包中的元素数量
     *
     * @return 背包中的元素数量
     */
    public int size() {
        return this.size;
    }

    /**
     * 背包类枚举器
     *
     * @return 背包类枚举器
     * @see Iterator
     */
    public Iterator<E> iterator() {
        return new ListIterator<>(first);
    }

    /**
     * 节点数据类型
     *
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    private class ListIterator<> implements Iterator<E> {

        private Node<E> current;

        ListIterator(Node<E> first) {
            this.current = first;
        }

        public boolean hasNext() {
            return this.current != null;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            E element = this.current.element;
            this.current = this.current.next;

            return element;
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}
