package com.tribes.dataStructure.list;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @see LinkedList Unit Test
 *
 * @author Zhiqiang Du
 */
public class LinkedListTest {

	private LinkedList<String> list;

	@Before
	public void setupTest() {
		list = new LinkedList<>();
	}

	@After
	public void tearDown() {

	}

	/**
	 * Test the default constructor of LinkedList<E>
	 */
	@Test
	public void testDefaultConstructor() {
		Assert.assertTrue(this.list.size() == 0);
		Assert.assertTrue(this.list.isEmpty());
	}

	/**
	 * Test the <tt>add<tt/> method.
	 */
	@Test
	public void testAdd() {
		this.list.add("Mou");
		this.list.add("Thu");

		Assert.assertTrue(this.list.size() == 2);
		Assert.assertFalse(this.list.isEmpty());
	}

	/**
	 * Test the <tt>addAll</tt> method.
	 */
	@Test
	public void testAddAll() {
		List<String> str = new ArrayList<String>();
		str.add("a");
		str.add("b");

		this.list.addAll(str);
		Assert.assertTrue(this.list.size() == 2);
		Assert.assertTrue(!this.list.isEmpty());
	}

	/**
	 * Test the <tt>contains</tt> methods.
	 */
	@Test
	public void testContains() {
		this.list.add("a");

		Assert.assertTrue(this.list.contains("a"));
		Assert.assertFalse(this.list.contains("b"));
	}

	/**
	 * Test the <tt>indexOf</tt> methods.
	 */
	@Test
	public void testIndexOf() {
		this.list.add("a");
		this.list.add("b");

		Assert.assertTrue(this.list.indexOf("a") == 0);
		Assert.assertTrue(this.list.indexOf("b") == 1);
	}

	/**
	 * Test the <tt>ListIterator</tt>
	 */
	@Test
	public void testListIterator() {
		com.tribes.dataStructure.list.List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);

		int count = 0;
		for (Integer value : list)
			count += value;

		Assert.assertEquals(3, count);

		//Test remove operation
		for (Iterator<Integer> iterable = list.iterator(); iterable.hasNext(); ) {
			Integer value = iterable.next();
			if (value == 1)
				iterable.remove();
		}

		count = 0;
		for (Integer value : list)
			count += value;

		Assert.assertEquals(2, count);
	}
}
