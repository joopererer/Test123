package datastruct;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.example.datastruct.EmptyListException;
import org.example.datastruct.MyUnsortedList;
import org.example.datastruct.UnsortedList;
import org.junit.Test;

public class MyUnsortedListTest {
	
	@Test
	public void testConstructeur() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertNotNull("create a list", list);
	}
	
	@Test
	public void testConstructeur2() {
		UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		assertNotNull("create a list", list);
	}

	@Test
	public void testIsEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertTrue("new list", list.isEmpty());
		
		list.append(5);
		assertFalse("list after one add", list.isEmpty());
		
		list.remove(0);
		assertTrue("list after one add+remove", list.isEmpty());
	}
	
	@Test
	public void testIsEmpty2() {
		UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		assertFalse("new list with initial data", list.isEmpty());
		list.remove(0);
		list.remove(0);
		list.remove(0);
		assertTrue("list after remove all data", list.isEmpty());
	}
	
	@Test
	public void testGetSize() {
		UnsortedList<String> list = MyUnsortedList.of();
		assertEquals("get new list size", 0, list.size());
		
		list.append("4");
		assertEquals("get list size after one add", 1, list.size());
		
		list.remove(0);
		assertEquals("get list size after one add+remove", 0, list.size());
	}
	
	@Test
	public void testGetSize2() {
		UnsortedList<String> list = MyUnsortedList.of("1", "2", "3");
		assertEquals("get list size", 3, list.size());
		
		list.remove(0);
		assertEquals("get list size after one remove", 2, list.size());
		
		list.remove(0);
		assertEquals("get list size after deux remove", 1, list.size());
		
		list.remove(0);
		assertEquals("get list size after all remove", 0, list.size());
	}
	
	@Test
	public void testEquals() {
		UnsortedList<String> list = MyUnsortedList.of("1", "2", "3");
		assertTrue("list equals", list.equals(MyUnsortedList.of("1", "2", "3")));
	}
	
	@Test
	public void testEquals2() {
		UnsortedList<String> list = MyUnsortedList.of();
		assertTrue("list equals", list.equals(MyUnsortedList.of()));
	}
	
	@Test
	public void testEquals3() {
		UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		assertFalse("list equals", list.equals(MyUnsortedList.of(3, 2, 1)));
	}
	
	@Test
	public void testEquals4() {
		UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		assertFalse("list equals", list.equals(MyUnsortedList.of(2, 1)));
	}
	
	@Test
	public void testEquals5() {
		UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
		assertFalse("list equals", list.equals(Arrays.asList(1, 2, 3)));
	}
	
	@Test
	public void testEquals6() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertFalse("list equals", list.equals(null));
	}
	
	@Test
	public void testToString() {
		UnsortedList<String> list = MyUnsortedList.of("1", "2", "3");
		assertEquals("list toString", MyUnsortedList.of("1", "2", "3").toString(), list.toString());
	}
	
	@Test
	public void testToString2() {
		UnsortedList<String> list = MyUnsortedList.of();
		assertEquals("list toString", MyUnsortedList.of().toString(), list.toString());
	}
	
	@Test
	public void testPrepend_with_empty_list() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		
		list.prepend(101);
		assertEquals("list after one prepend", MyUnsortedList.of(101), list);
		
		list.prepend(102);
		assertEquals("list after deux prepend", MyUnsortedList.of(102, 101), list);
	}
	
	@Test
	public void testPrepend_with_not_empty_list() {
		UnsortedList<Integer> list = MyUnsortedList.of(4, 5, 6);
		
		list.prepend(101);
		assertEquals("list after one prepend", MyUnsortedList.of(101, 4, 5, 6), list);
		
		list.prepend(102);
		assertEquals("list after deux prepend", MyUnsortedList.of(102, 101, 4, 5, 6), list);
	}
	
	@Test
	public void testAppend_with_empty_list() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		
		list.append(101);
		assertEquals("list after one append", MyUnsortedList.of(101), list);
		
		list.append(102);
		assertEquals("list after deux append", MyUnsortedList.of(101, 102), list);
	}
	
	@Test
	public void testAppend_with_not_empty_list() {
		UnsortedList<Integer> list = MyUnsortedList.of(4, 5, 6);
		
		list.append(101);
		assertEquals("list after one append", MyUnsortedList.of(4, 5, 6, 101), list);
		
		list.append(102);
		assertEquals("list after deux append", MyUnsortedList.of(4, 5, 6, 101, 102), list);
	}
	
	@Test
	public void testInsert_with_empty_list() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.insert(66, 0);
		assertEquals("insert element at first", MyUnsortedList.of(66), list);
		
		list.insert(33, 1);
		assertEquals("insert element at last", MyUnsortedList.of(66, 33), list);
	}
	
	@Test
	public void testInsert_with_not_empty_list() {
		UnsortedList<Integer> list = MyUnsortedList.of(3, 2, 1);
		list.insert(66, 0);
		assertEquals("insert element at first", MyUnsortedList.of(66, 3, 2, 1), list);
		
		list.insert(33, 4);
		assertEquals("insert element at last", MyUnsortedList.of(66, 3, 2, 1, 33), list);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsert_badIndex() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.insert(100, 1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsert_badIndex2() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.insert(100, -1);
	}
	
	@Test
	public void testPop() {
		UnsortedList<String> list = MyUnsortedList.of("1", "2", "3");
		
		assertEquals("get first element", "1", list.pop());
		assertEquals("list after pop", MyUnsortedList.of("2", "3"), list);
		
		assertEquals("get second element", "2", list.pop());
		assertEquals("list after pop", MyUnsortedList.of("3"), list);
		
		assertEquals("get third element", "3", list.pop());
		assertEquals("list after pop", MyUnsortedList.of(), list);
	}
	
	@Test(expected = EmptyListException.class)
	public void testPop_with_empty_list() throws EmptyListException {
		UnsortedList<String> list = MyUnsortedList.of();
		list.pop();
	}
	
	@Test
	public void testRemove() {
		UnsortedList<String> list = MyUnsortedList.of("1", "2", "3");
		assertEquals("remove element at index 1", "2", list.remove(1));
		assertEquals("list after remove", MyUnsortedList.of("1", "3"), list);
		
		assertEquals("remove element at index 1", "3", list.remove(1));
		assertEquals("list after remove", MyUnsortedList.of("1"), list);
		
		assertEquals("remove element at index 0", "1", list.remove(0));
		assertEquals("list after remove", MyUnsortedList.of(), list);
	}
	
	@Test
	public void testRemove_fisrt() {
		UnsortedList<String> list = MyUnsortedList.of("1", "2", "3");
		list.remove(0);
		assertEquals("list after remove first element", MyUnsortedList.of("2", "3"), list);
	}
	
	@Test
	public void testRemove_last() {
		UnsortedList<String> list = MyUnsortedList.of("1", "2", "3");
		list.remove(2);
		assertEquals("list after remove first element", MyUnsortedList.of("1", "2"), list);
	}
	
	@Test
	public void testRemove_middle() {
		UnsortedList<String> list = MyUnsortedList.of("1", "2", "3");
		list.remove(1);
		assertEquals("list after remove first element", MyUnsortedList.of("1", "3"), list);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove_OutOfIndex() throws IndexOutOfBoundsException {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.remove(0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove_OutOfIndex2() throws IndexOutOfBoundsException {
		UnsortedList<Integer> list = MyUnsortedList.of(3, 2, 1);
		list.remove(-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove_OutOfIndex3() throws IndexOutOfBoundsException {
		UnsortedList<Integer> list = MyUnsortedList.of(3, 2, 1);
		list.remove(3);
	}
	
	@Test
	public void testPopLast() {
		UnsortedList<String> list = MyUnsortedList.of("1", "2", "3");
		assertEquals("get list size", 3, list.size());
		
		assertEquals("popLast", "3", list.popLast());
		assertEquals("get list size after popLast", 2, list.size());
		assertEquals("list after pop", MyUnsortedList.of("1", "2"), list);
		
		assertEquals("gopLast", "2", list.popLast());
		assertEquals("get list size after popLast", 1, list.size());
		assertEquals("list after pop", MyUnsortedList.of("1"), list);
		
		assertEquals("opLast", "1", list.popLast());
		assertEquals("get list size after popLast", 0, list.size());
		assertEquals("list after pop", MyUnsortedList.of(), list);
	}
	
	@Test(expected = EmptyListException.class)
	public void testPopLast_with_empty_list() throws EmptyListException {
		UnsortedList<String> list = MyUnsortedList.of();
		list.popLast();
	}

}
