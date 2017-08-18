package com.tribes.dataStructure.list;

import java.util.Collection;
import java.util.Iterator;

/**
 * Generic interface of list (sequence).
 *
 * @param <E> the type of element what put int this list.
 * @author Zhiqiang Du
 */
public interface List<E> extends Iterable<E> {

	/**
	 * Returns <tt>true</tt> if this list has no element.
	 *
	 * @return  <tt>true</tt> if this list has no element
	 */
	boolean isEmpty();

	/**
	 * Returns the number of this list.
	 *
	 * @return the number of this list
	 */
	int size();

	/**
	 * Returns <tt>true</tt> if this list has e element.
	 *
	 * @param e element whether in this list
	 * @return <tt>true</tt> if this list has e element
	 */
	boolean contains(Object e);

	/**
	 * Returns first occurrence index of an element if exist in this list.
	 *
	 * @param e an element
	 * @return first occurrence index of an element if exist in this list.
	 */
	int indexOf(Object e);

	/**
	 * Returns <tt>true</tt> if element added into this list correct.
	 *
	 * @param e element added to this list
	 * @return <tt>true</tt> if element added into this list correct
	 */
	boolean add(E e);

	/**
	 * Insert all of the elements in the specified collection into this list.
	 *
	 * @param index index at which to insert the first element
	 *              from the specified collection
	 * @param c collection containing element to be added to this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws IndexOutOfBoundsException
	 * @throws NullPointerException if the specified collection is null
	 */
	boolean addAll(int index, Collection<? extends E> c);

	/**
	 * Add a collection of elements.
	 *
	 * @param c a collection of elements
	 */
	void addAll(Collection<? extends E> c);

	Iterator<E> iterator();
}
