package com.tribes.dataStructure.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Double-Linked List.
 * Append element to the tail.
 * Allow null element.
 *
 * @param <E> the type of element added into the list.
 * @author Zhiqiang Du
 * @see List
 */
public class LinkedList<E> implements List<E> {

    private int size = 0;

    private int modCount = 0;

    private Node<E> first;

    private Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

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
     * Returns <tt>true</tt> if this list has no element.
     *
     * @return <tt>true</tt> if this list has no element
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the number of this list.
     *
     * @return the number of this list
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns <tt>true</tt> if this list has e element.
     *
     * @param e element whether in this list
     * @return <tt>true</tt> if this list has e element
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Returns first occurrence index of an element if exist in this list.
     *
     * @param o an element
     * @return first occurrence index of an element if exist in this list.
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }

        return -1;
    }

    /**
     * Returns <tt>true</tt> if element added into this list correct.
     *
     * @param e element added to this list
     * @return <tt>true</tt> if element added into this list correct
     */
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * Add a collection of elements.
     *
     * @param c a collection of elements
     */
    @Override
    public void addAll(Collection<? extends E> c) {
        addAll(size, c);
    }

    /**
     * Insert all of the elements in the specified collection into this list.
     *
     * @param index index at which to insert the first element
     *              from the specified collection
     * @param c     collection containing element to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws IndexOutOfBoundsException
     * @throws NullPointerException      if the specified collection is null
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkPositionIndex(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }

        for (Object o : a) {
            @SuppressWarnings("unchecked") E e = (E) o;
            Node<E> newNode = new Node<>(pred, e, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }

        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }

        size += numNew;
        modCount++;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<E>(first, last);
    }

    private class ListIterator<E> implements Iterator<E> {

        private Node<E> first;
        private Node<E> last;
        private Node<E> current;

        ListIterator(Node<E> first, Node<E> last) {
            this.current = first;
            this.first = first;
            this.last = last;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            E item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

    }

    //region Private Methods

    /**
     * Link an element to the head of list.
     */
    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = first;
        size++;
        modCount++;
    }

    /**
     * Link an element to the tail of list.
     */
    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = last;
        size++;
        modCount++;
    }

    /**
     * Inserts element e before non-null Node succ.
     */
    private void linkBefore(E e, Node<E> succ) {
        Node<E> pred = succ.prev;
        Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }

    /**
     * Un-links first node f.
     */
    private E unlinkFirst(Node<E> f) {
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;

        return element;
    }

    /**
     * Un-links first node l
     */
    private E unlinkLast(Node<E> l) {
        final E element = l.item;
        final Node<E> pred = l.prev;
        l.item = null;
        l.prev = null;
        last = pred;
        if (pred == null)
            first = null;
        else
            pred.next = null;
        size--;
        modCount++;

        return element;
    }

    /**
     * Un-links node x.
     */
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
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;

        return element;
    }

    /**
     * Constructs an IndexOfBoundsException detail message.
     */
    private String outOfBoundMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or ad add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * Check if the argument is the index of a valid position for a list.
     *
     * @throws IndexOutOfBoundsException if the index is not a valid index.
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
    }

    /**
     * Returns the Node at the specified element index.
     */
    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    //endregion
}
