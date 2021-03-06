import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Testing for IndexedUnsortedList interface implementation: 
 * ListIterator Tests for Change Scenario 23: [A, B] -> addAfter(C, B) -> [A, B, C]
 * 
 * @author Matt T 
 */
public class ListItrTest_23_AB_addAfterCB_ABC
{
	// List running tests on
	private IndexedUnsortedList<Character> list;

	// ListIterator reference for tests 
	private ListIterator<Character> itr; 
	
	// First element in list
	private static final Character FIRST = TestCase.A;
	// Middle element in list
	private static final Character MIDDLE = TestCase.B;
	// Last element in list 
	private static final Character LAST = TestCase.C;	
	// Invalid index
	private static final int INVALID_INDEX = -1; 
	// Index of first element
	private static final int FIRST_INDEX = 0;
	// Index of middle element
	private static final int MIDDLE_INDEX = 1; 
	// Index of last element 
	private static final int LAST_INDEX = 2; 
	// Size of list
	private static final int SIZE = 3; 
	// Element used in add method 
	private final Character ADDED_ELEMENT = TestCase.E;
	// Element not in list - used for testing 
	private final Character ELEMENT = TestCase.F;
	// Element not in list - used for negative testing 
	private final Character INVALID_ELEMENT = TestCase.G;
		
	//********************Before Each Test Method********************
	/**
	 * Sets up list for testing: uses Parameter in XML file to select the 
	 * dynamic type of the list. 
	 * @param listType - String representing the dynamic type of the list. 
	 */
	@BeforeMethod
	@Parameters("listType")		
	public void initList(String listType)
	{
		// create empty list 
		list = TestCase.newList(listType);
		// state of list before change scenario
		list.add(TestCase.A);
		list.add(TestCase.B);
		// the change made to the list 
		list.addAfter(TestCase.C, TestCase.B);
	}
	
	/****** Tests for a new ListIterator (init) *****************/ 
	// XXX
	
	/**
	 * Test: new ListIterator, test hasNext() - whether there's a next element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItr_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, test next() - returns ref to next element in the ListIterator list
	 * Expected Result: Reference to first element in list
	 */
	@Test 
	public void testListItr_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.next(itr, FIRST); 
	}

	/**
	 * Test: new ListIterator, test remove() - tries to remove last element returned by next in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testListItr_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.remove(itr); 
	}
	
	/**
	 * Test: new ListIterator, test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: false
	 */
	@Test
	public void testListItr_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.hasPrevious(itr, false); 
	}

	/**
	 * Test: new ListIterator, test previous() - tries to return ref to previous element in the ListIterator list
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class)
	public void testListItr_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.previous(itr, INVALID_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItr_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: FIRST_INDEX
	 */
	@Test
	public void testListItr_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.nextIndex(itr, FIRST_INDEX); 
	}

	/**
	 * Test: new ListIterator, test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: INVALID_INDEX
	 */
	@Test
	public void testListItr_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.previousIndex(itr, INVALID_INDEX); 
	}

	/**
	 * Test: new ListIterator, test set(E) - tries to set element in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class)
	public void testListItr_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.set(itr, ELEMENT); 
	}

	/******Call add(E), then run tests (add) ******/
	// XXX
	
	/**
	 * Test: new ListIterator, call add(E); test hasNext() - whether there's a next element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrAdd_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call add(E); test next() - returns ref to next element in the ListIterator list
	 * Expected Result: Reference to first element in list
	 */
	@Test 
	public void testListItrAdd_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.next(itr, FIRST); 
	}

	/**
	 * Test: new ListIterator, call add(E); test remove() - tries to remove last element returned by next in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testListItrAdd_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.remove(itr); 
	}
	
	/**
	 * Test: new ListIterator, call add(E); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrAdd_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.hasPrevious(itr, true); 
	}

	/**
	 * Test: new ListIterator, call add(E); test previous() - returns ref to previous element in the ListIterator list
	 * Expected Result: Reference to added element
	 */
	@Test
	public void testListItrAdd_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.previous(itr, ADDED_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call add(E); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrAdd_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call add(E); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: MIDDLE_INDEX
	 */
	@Test
	public void testListItrAdd_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.nextIndex(itr, MIDDLE_INDEX); 
	}

	/**
	 * Test: new ListIterator, call add(E); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: FIRST_INDEX
	 */
	@Test
	public void testListItrAdd_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.previousIndex(itr, FIRST_INDEX); 
	}
	
	/**
	 * Test: new ListIterator, call add(E); test set(E) - tries to set element in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class)
	public void testListItrAdd_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.set(itr, ELEMENT); 
	}
	
	/******Call next() and add(E), then run tests (nextAdd) ******/
	// XXX

	/**
	 * Test: new ListIterator, call next() and add(E); test hasNext() - whether there's a next element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextAdd_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextAdd);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() and add(E); test next() - returns ref to next element in the ListIterator list
	 * Expected Result: Reference to middle element in list
	 */
	@Test 
	public void testListItrNextAdd_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextAdd);
		TestCase.next(itr, MIDDLE); 
	}

	/**
	 * Test: new ListIterator, call next() and add(E); test remove() - tries to remove last element returned by next in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testListItrNextAdd_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextAdd);
		TestCase.remove(itr); 
	}

	/**
	 * Test: new ListIterator, call next() and add(E); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextAdd_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextAdd);
		TestCase.hasPrevious(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() and add(E); test previous() - returns ref to previous element in the ListIterator list
	 * Expected Result: Reference to ADD_ELEMENT 
	 */
	@Test
	public void testListItrNextAdd_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextAdd);
		TestCase.previous(itr, ADDED_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() and add(E); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextAdd_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextAdd);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() and add(E); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: LAST_INDEX
	 */
	@Test
	public void testListItrNextAdd_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextAdd);
		TestCase.nextIndex(itr, LAST_INDEX); 
	}

	/**
	 * Test: new ListIterator, call next() and add(E); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: MIDDLE_INDEX
	 */
	@Test
	public void testListItrNextAdd_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextAdd);
		TestCase.previousIndex(itr, MIDDLE_INDEX); 
	}
	
	/**
	 * Test: new ListIterator, call next() and add(E); test set(E) - sets element in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class)
	public void testListItrNextAdd_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextAdd);
		TestCase.set(itr, ELEMENT); 
	}

	/******Call next() and previous(), then run tests (nextPrev) ******/
	// XXX

	/**
	 * Test: new ListIterator, call next() and previous(); test hasNext() - whether there's a next element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextPrev_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrev);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() and previous(); test next() - returns ref to next element in the ListIterator list
	 * Expected Result: Reference to first element in list
	 */
	@Test 
	public void testListItrNextPrev_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrev);
		TestCase.next(itr, FIRST); 
	}

	/**
	 * Test: new ListIterator, call next() and previous(); test remove() - tries to remove last element returned by next in the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextPrev_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrev);
		TestCase.remove(itr); 
	}

	/**
	 * Test: new ListIterator, call next() and previous(); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: false
	 */
	@Test
	public void testListItrNextPrev_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrev);
		TestCase.hasPrevious(itr, false); 
	}
	
	/**
	 * Test: new ListIterator, call next() and previous(); test previous() - tries to return ref to previous element in the ListIterator list
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class)
	public void testListItrNextPrev_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrev);
		TestCase.previous(itr, INVALID_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() and previous(); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextPrev_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrev);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() and previous(); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: FIRST_INDEX
	 */
	@Test
	public void testListItrNextPrev_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrev);
		TestCase.nextIndex(itr, FIRST_INDEX); 
	}
	
	/**
	 * Test: new ListIterator, call next() and previous(); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: INVALID_INDEX
	 */
	@Test
	public void testListItrNextPrev_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrev);
		TestCase.previousIndex(itr, INVALID_INDEX); 
	}

	/**
	 * Test: new ListIterator, call next() and previous(); test set() - sets element in the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextPrev_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrev);
		TestCase.set(itr, ELEMENT); 
	}

	/********* Call next(), previous(), and add(), then run tests (nextPrevAdd) *********/
	// XXX

	/**
	 * Test: new ListIterator, call next(), previous(), and add(); test hasNext() - whether there's a next element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextPrevAdd_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevAdd);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next(), previous(), and add(); test next() - returns ref to next element in the ListIterator list
	 * Expected Result: Reference to first element in list
	 */
	@Test 
	public void testListItrNextPrevAdd_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevAdd);
		TestCase.next(itr, FIRST); 
	}

	/**
	 * Test: new ListIterator, call next(), previous(), and add(); test remove() - tries to remove last element returned by next in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testListItrNextPrevAdd_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevAdd);
		TestCase.remove(itr); 
	}
	
	/**
	 * Test: new ListIterator, call next(), previous(), and add(); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextPrevAdd_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevAdd);
		TestCase.hasPrevious(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next(), previous(), and add(); test previous() - returns ref to previous element in the ListIterator list
	 * Expected Result: No exception
	 */
	@Test 
	public void testListItrNextPrevAdd_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevAdd);
		TestCase.previous(itr, ADDED_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next(), previous(), and add(); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextPrevAdd_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevAdd);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next(), previous(), and add(); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: MIDDLE_INDEX
	 */
	@Test
	public void testListItrNextPrevAdd_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevAdd);
		TestCase.nextIndex(itr, MIDDLE_INDEX); 
	}
	
	/**
	 * Test: new ListIterator, call next(), previous(), and add(); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: FIRST_INDEX
	 */
	@Test 
	public void testListItrNextPrevAdd_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevAdd);
		TestCase.previousIndex(itr, FIRST_INDEX); 
	}

	/**
	 * Test: new ListIterator, call next(), previous(), and add(); test set() - tries to set element in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class)
	public void testListItrNextPrevAdd_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevAdd);
		TestCase.set(itr, ELEMENT); 
	}

	/********* Call next(), previous(), and remove(), then run tests (nextPrevRemove) *********/
	// XXX

	/**
	 * Test: new ListIterator, call next(), previous(), and remove(); test hasNext() - whether there's a next element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextPrevRemove_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevRemove);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next(), previous(), and remove(); test next() - returns ref to next element in the ListIterator list
	 * Expected Result: Reference to middle element in list
	 */
	@Test 
	public void testListItrNextPrevRemove_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevRemove);
		TestCase.next(itr, MIDDLE); 
	}

	/**
	 * Test: new ListIterator, call next(), previous(), and remove(); test remove() - tries to remove last element returned by next in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testListItrNextPrevRemove_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevRemove);
		TestCase.remove(itr); 
	}

	/**
	 * Test: new ListIterator, call next(), previous(), and remove(); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: false
	 */
	@Test
	public void testListItrNextPrevRemove_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevRemove);
		TestCase.hasPrevious(itr, false); 
	}
	
	/**
	 * Test: new ListIterator, call next(), previous(), and remove(); test previous() - returns ref to previous element in the ListIterator list
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class)
	public void testListItrNextPrevRemove_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevRemove);
		TestCase.previous(itr, INVALID_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next(), previous(), and remove(); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextPrevRemove_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevRemove);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next(), previous(), and remove(); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: FIRST_INDEX
	 */
	@Test
	public void testListItrNextPrevRemove_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevRemove);
		TestCase.nextIndex(itr, FIRST_INDEX); 
	}
	
	/**
	 * Test: new ListIterator, call next(), previous(), and remove(); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: INVALID_INDEX
	 */
	@Test 
	public void testListItrNextPrevRemove_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevRemove);
		TestCase.previousIndex(itr, INVALID_INDEX); 
	}

	/**
	 * Test: new ListIterator, call next(), previous(), and remove(); test set() - tries to set element in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class)
	public void testListItrNextPrevRemove_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextPrevRemove);
		TestCase.set(itr, ELEMENT); 
	}
	
	/******** Call next() twice and previous(), then run tests (nextNextPrev) **************/
	// XXX

	/**
	 * Test: new ListIterator, call next() twice and previous(); test hasNext() - whether there's a next element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextPrev_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrev);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() twice and previous(); test next() - returns ref to next element in the ListIterator list
	 * Expected Result: Reference to middle element in list
	 */
	@Test 
	public void testListItrNextNextPrev_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrev);
		TestCase.next(itr, MIDDLE); 
	}

	/**
	 * Test: new ListIterator, call next() twice and previous(); test remove() - tries to remove last element returned by next in the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextNextPrev_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrev);
		TestCase.remove(itr); 
	}

	/**
	 * Test: new ListIterator, call next() twice and previous(); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextPrev_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrev);
		TestCase.hasPrevious(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() twice and previous(); test previous() - returns ref to previous element in the ListIterator list
	 * Expected Result: Reference to first element
	 */
	@Test
	public void testListItrNextNextPrev_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrev);
		TestCase.previous(itr, FIRST); 
	}

	/**
	 * Test: new ListIterator, call next() twice and previous(); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test 
	public void testListItrNextNextPrev_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrev);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() twice and previous(); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: MIDDLE_INDEX
	 */
	@Test
	public void testListItrNextNextPrev_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrev);
		TestCase.nextIndex(itr, MIDDLE_INDEX); 
	}
	
	/**
	 * Test: new ListIterator, call next() twice and previous(); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: FIRST_INDEX
	 */
	@Test
	public void testListItrNextNextPrev_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrev);
		TestCase.previousIndex(itr, FIRST_INDEX); 
	}

	/**
	 * Test: new ListIterator, call next() twice and previous(); test set() - sets element in the ListIterator list
	 * Expected Result: No exception
	 */
	@Test 
	public void testListItrNextNextPrev_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrev);
		TestCase.set(itr, ELEMENT); 
	}

	/*******Call next() twice, and add(), then run tests (nextNextAdd) ********/
	// XXX

	/**
	 * Test: new ListIterator, call next() twice, and add(); test hasNext() - whether there's a next element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextAdd_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextAdd);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() twice, and add(); test next() - returns ref to next element in the ListIterator list
	 * Expected Result: Reference to last element in list
	 */
	@Test
	public void testListItrNextNextAdd_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextAdd);
		TestCase.next(itr, LAST); 
	}

	/**
	 * Test: new ListIterator, call next() twice, and add(); test remove() - tries to remove last element returned by next in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testListItrNextNextAdd_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextAdd);
		TestCase.remove(itr); 
	}
	
	/**
	 * Test: new ListIterator, call next() twice, and add(); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextAdd_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextAdd);
		TestCase.hasPrevious(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() twice, and add(); test previous() - returns ref to previous element in the ListIterator list
	 * Expected Result: Reference to added element 
	 */
	@Test
	public void testListItrNextNextAdd_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextAdd);
		TestCase.previous(itr, ADDED_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() twice, and add(); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextNextAdd_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextAdd);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() twice, and add(); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: SIZE
	 */
	@Test
	public void testListItrNextNextAdd_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextAdd);
		TestCase.nextIndex(itr, SIZE); 
	}
	
	/**
	 * Test: new ListIterator, call next() twice, and add(); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: LAST_INDEX
	 */
	@Test
	public void testListItrNextNextAdd_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextAdd);
		TestCase.previousIndex(itr, LAST_INDEX); 
	}

	/**
	 * Test: new ListIterator, call next() twice, and add(); test set() - sets element in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class)
	public void testListItrNextNextAdd_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextAdd);
		TestCase.set(itr, ELEMENT); 
	}

	/*********Call next() twice, previous() and add(), then run tests (nextNextPrevAdd) **********/
	// XXX

	/**
	 * Test: new ListIterator, call next() twice, previous() and add(); test hasNext() - whether there's a next element in the Iterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextPrevAdd_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevAdd);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() twice, previous() and add(); test next() - returns ref to next element in the Iterator list
	 * Expected Result: Reference to middle element in list
	 */
	@Test 
	public void testListItrNextNextPrevAdd_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevAdd);
		TestCase.next(itr, MIDDLE); 
	}

	/**
	 * Test: new ListIterator, call next() twice, previous() and add(); test remove() - tries to remove last element returned by next in the Iterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testListItrNextNextPrevAdd_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevAdd);
		TestCase.remove(itr); 
	}

	/**
	 * Test: new ListIterator, call next() twice, previous() and add(); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextPrevAdd_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevAdd);
		TestCase.hasPrevious(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() twice, previous() and add(); test previous() - returns ref to previous element in the ListIterator list
	 * Expected Result: Reference to added element 
	 */
	@Test
	public void testListItrNextNextPrevAdd_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevAdd);
		TestCase.previous(itr, ADDED_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() twice, previous(), and add(); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextNextPrevAdd_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevAdd);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() twice, previous(), and add(); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: LAST_INDEX
	 */
	@Test
	public void testListItrNextNextPrevAdd_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevAdd);
		TestCase.nextIndex(itr, LAST_INDEX); 
	}
	
	/**
	 * Test: new ListIterator, call next() twice, previous(), and add(); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: MIDDLE_INDEX
	 */
	@Test
	public void testListItrNextNextPrevAdd_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevAdd);
		TestCase.previousIndex(itr, MIDDLE_INDEX); 
	}

	/**
	 * Test: new ListIterator, call next() twice, previous(), and add(); test set() - sets element in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class)
	public void testListItrNextNextPrevAdd_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevAdd);
		TestCase.set(itr, ELEMENT); 
	}
	
	/*********Call next() twice, previous() and remove(), then run tests (nextNextPrevRemove) **********/
	// XXX

	/**
	 * Test: new ListIterator, call next() twice, previous() and remove(); test hasNext() - whether there's a next element in the Iterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextPrevRemove_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevRemove);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() twice, previous() and remove(); test next() - tries to return ref to next element in the Iterator list
	 * Expected Result: Reference to last element 
	 */
	@Test  
	public void testListItrNextNextPrevRemove_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevRemove);
		TestCase.next(itr, LAST); 
	}

	/**
	 * Test: new ListIterator, call next() twice, previous() and remove(); test remove() - tries to remove last element returned by next in the Iterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testListItrNextNextPrevRemove_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevRemove);
		TestCase.remove(itr); 
	}

	/**
	 * Test: new ListIterator, call next() twice, previous() and remove(); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextPrevRemove_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevRemove);
		TestCase.hasPrevious(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() twice, previous() and remove(); test previous() - returns ref to previous element in the ListIterator list
	 * Expected Result: Reference to first element
	 */
	@Test
	public void testListItrNextNextPrevRemove_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevRemove);
		TestCase.previous(itr, FIRST); 
	}

	/**
	 * Test: new ListIterator, call next() twice, previous(), and remove(); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextNextPrevRemove_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevRemove);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() twice, previous(), and remove(); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: MIDDLE_INDEX
	 */
	@Test
	public void testListItrNextNextPrevRemove_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevRemove);
		TestCase.nextIndex(itr, MIDDLE_INDEX); 
	}
	
	/**
	 * Test: new ListIterator, call next() twice, previous(), and remove(); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: FIRST_INDEX
	 */
	@Test
	public void testListItrNextNextPrevRemove_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevRemove);
		TestCase.previousIndex(itr, FIRST_INDEX); 
	}

	/**
	 * Test: new ListIterator, call next() twice, previous(), and remove(); test set() - tries to set element in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class)
	public void testListItrNextNextPrevRemove_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextPrevRemove);
		TestCase.set(itr, ELEMENT); 
	}

	/******** Call next() three times and previous(), then run tests (nextNextNextPrev) **************/
	// XXX

	/**
	 * Test: new ListIterator, call next() three times and previous(); test hasNext() - whether there's a next element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextNextPrev_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrev);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() three times and previous(); test next() - returns ref to next element in the ListIterator list
	 * Expected Result: Reference to last element in list
	 */
	@Test 
	public void testListItrNextNextNextPrev_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrev);
		TestCase.next(itr, LAST); 
	}

	/**
	 * Test: new ListIterator, call next() three times and previous(); test remove() - tries to remove last element returned by next in the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextNextNextPrev_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrev);
		TestCase.remove(itr); 
	}

	/**
	 * Test: new ListIterator, call next() three times and previous(); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextNextPrev_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrev);
		TestCase.hasPrevious(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() three times and previous(); test previous() - returns ref to previous element in the ListIterator list
	 * Expected Result: Reference to middle element 
	 */
	@Test
	public void testListItrNextNextNextPrev_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrev);
		TestCase.previous(itr, MIDDLE); 
	}

	/**
	 * Test: new ListIterator, call next() three times and previous(); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test 
	public void testListItrNextNextNextPrev_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrev);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() three times and previous(); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: LAST_INDEX
	 */
	@Test
	public void testListItrNextNextNextPrev_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrev);
		TestCase.nextIndex(itr, LAST_INDEX); 
	}
	
	/**
	 * Test: new ListIterator, call next() three times and previous(); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: MIDDLE_INDEX
	 */
	@Test
	public void testListItrNextNextNextPrev_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrev);
		TestCase.previousIndex(itr, MIDDLE_INDEX); 
	}

	/**
	 * Test: new ListIterator, call next() three times and previous(); test set() - sets element in the ListIterator list
	 * Expected Result: No exception
	 */
	@Test 
	public void testListItrNextNextNextPrev_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrev);
		TestCase.set(itr, ELEMENT); 
	}

	/*******Call next() three times and add(), then run tests (nextNextNextAdd) ********/
	// XXX

	/**
	 * Test: new ListIterator, call next() three times and add(); test hasNext() - whether there's a next element in the ListIterator list
	 * Expected Result: false
	 */
	@Test
	public void testListItrNextNextNextAdd_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextAdd);
		TestCase.hasNext(itr, false); 
	}
	
	/**
	 * Test: new ListIterator, call next() three times, and add(); test next() - returns ref to next element in the ListIterator list
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class) 
	public void testListItrNextNextNextAdd_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextAdd);
		TestCase.next(itr, INVALID_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() three times, and add(); test remove() - tries to remove last element returned by next in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testListItrNextNextNextAdd_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextAdd);
		TestCase.remove(itr); 
	}
	
	/**
	 * Test: new ListIterator, call next() three times, and add(); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextNextAdd_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextAdd);
		TestCase.hasPrevious(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() three times, and add(); test previous() - returns ref to previous element in the ListIterator list
	 * Expected Result: Reference to added element 
	 */
	@Test
	public void testListItrNextNextNextAdd_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextAdd);
		TestCase.previous(itr, ADDED_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() three times, and add(); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextNextNextAdd_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextAdd);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() three times, and add(); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: SIZE + 1
	 */
	@Test
	public void testListItrNextNextNextAdd_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextAdd);
		TestCase.nextIndex(itr, SIZE + 1); 
	}
	
	/**
	 * Test: new ListIterator, call next() three times, and add(); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: SIZE
	 */
	@Test
	public void testListItrNextNextNextAdd_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextAdd);
		TestCase.previousIndex(itr, SIZE); 
	}

	/**
	 * Test: new ListIterator, call next() three times, and add(); test set() - sets element in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class)
	public void testListItrNextNextNextAdd_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextAdd);
		TestCase.set(itr, ELEMENT); 
	}

	/*********Call next() three times, previous() and add(), then run tests (nextNextNextPrevAdd) **********/
	// XXX

	/**
	 * Test: new ListIterator, call next() three times, previous() and add(); test hasNext() - whether there's a next element in the Iterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextNextPrevAdd_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevAdd);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() three times, previous() and add(); test next() - returns ref to next element in the Iterator list
	 * Expected Result: Reference to last element in list
	 */
	@Test 
	public void testListItrNextNextNextPrevAdd_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevAdd);
		TestCase.next(itr, LAST); 
	}

	/**
	 * Test: new ListIterator, call next() three times, previous() and add(); test remove() - tries to remove last element returned by next in the Iterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testListItrNextNextNextPrevAdd_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevAdd);
		TestCase.remove(itr); 
	}

	/**
	 * Test: new ListIterator, call next() three times, previous() and add(); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextNextPrevAdd_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevAdd);
		TestCase.hasPrevious(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() three times, previous() and add(); test previous() - returns ref to previous element in the ListIterator list
	 * Expected Result: Reference to added element 
	 */
	@Test
	public void testListItrNextNextNextPrevAdd_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevAdd);
		TestCase.previous(itr, ADDED_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() three times, previous(), and add(); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextNextNextPrevAdd_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevAdd);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() three times, previous(), and add(); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: SIZE
	 */
	@Test
	public void testListItrNextNextNextPrevAdd_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevAdd);
		TestCase.nextIndex(itr, SIZE); 
	}
	
	/**
	 * Test: new ListIterator, call next() three times, previous(), and add(); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: LAST_INDEX
	 */
	@Test
	public void testListItrNextNextNextPrevAdd_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevAdd);
		TestCase.previousIndex(itr, LAST_INDEX); 
	}

	/**
	 * Test: new ListIterator, call next() three times, previous(), and add(); test set() - sets element in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class)
	public void testListItrNextNextNextPrevAdd_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevAdd);
		TestCase.set(itr, ELEMENT); 
	}
	
	/*********Call next() three times, previous() and remove(), then run tests (nextNextNextPrevRemove) **********/
	// XXX

	/**
	 * Test: new ListIterator, call next() three times, previous() and remove(); test hasNext() - whether there's a next element in the Iterator list
	 * Expected Result: false
	 */
	@Test
	public void testListItrNextNextNextPrevRemove_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevRemove);
		TestCase.hasNext(itr, false); 
	}
	
	/**
	 * Test: new ListIterator, call next() three times, previous() and remove(); test next() - tries to return ref to next element in the Iterator list
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class)  
	public void testListItrNextNextNextPrevRemove_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevRemove);
		TestCase.next(itr, INVALID_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() three times, previous() and remove(); test remove() - tries to remove last element returned by next in the Iterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testListItrNextNextNextPrevRemove_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevRemove);
		TestCase.remove(itr); 
	}

	/**
	 * Test: new ListIterator, call next() three times, previous() and remove(); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrNextNextNextPrevRemove_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevRemove);
		TestCase.hasPrevious(itr, true); 
	}
	
	/**
	 * Test: new ListIterator, call next() three times, previous() and remove(); test previous() - returns ref to previous element in the ListIterator list
	 * Expected Result: Reference to middle element 
	 */
	@Test
	public void testListItrNextNextNextPrevRemove_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevRemove);
		TestCase.previous(itr, MIDDLE); 
	}

	/**
	 * Test: new ListIterator, call next() three times, previous(), and remove(); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrNextNextNextPrevRemove_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevRemove);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call next() three times, previous(), and remove(); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: LAST_INDEX
	 */
	@Test
	public void testListItrNextNextNextPrevRemove_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevRemove);
		TestCase.nextIndex(itr, LAST_INDEX); 
	}
	
	/**
	 * Test: new ListIterator, call next() three times, previous(), and remove(); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: MIDDLE_INDEX
	 */
	@Test
	public void testListItrNextNextNextPrevRemove_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevRemove);
		TestCase.previousIndex(itr, MIDDLE_INDEX); 
	}

	/**
	 * Test: new ListIterator, call next() three times, previous(), and remove(); test set() - tries to set element in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class)
	public void testListItrNextNextNextPrevRemove_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.nextNextNextPrevRemove);
		TestCase.set(itr, ELEMENT); 
	}
	
}
