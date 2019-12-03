
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 *This class implements the methods of an Indexed Unsorted List using a linked list holding "T" objects.
 * @author Jeff Kahn
 * @version 1.0
 * @since 11-10-2019
 */
public class IUDoubleLinkedList<T> implements IndexedUnsortedList<T> {
	private int count; // # of elements in list and next open spot
	private int modCount; // changes made to list
	private DLLNode<T> head, tail; // beginning/end of list

	/**
	 * Default constructor that initializes count, head, tail and modCount
	 */
	public IUDoubleLinkedList() {
		count = 0; // no elements in list
		head = null; 
		tail = null;
		modCount = 0; // no changes to list
	}

	@Override
	public void addToFront(T element) {
		DLLNode<T> newNode = new DLLNode<T>(element); // newNode to hold parameter
		newNode.setNext(head); // link newNode to beginning of list
		head = newNode; // head is now the new node added at beginning
		if (isEmpty()) { 
			tail = newNode; // tail set to newNode if only element in list
		}
		count++; // increment counter for # of elements in list
		modCount++; // change made to list
	}

	@Override
	public void addToRear(T element) {

		DLLNode<T> newNode = new DLLNode<T>(element); // newNode to hold parameter
		if (isEmpty()) {
			head = newNode; // head is now the new node added at beginning
		} else {
			tail.setNext(newNode); // link tail to newNode if not empty
			newNode.setPrevious(tail);
		}
		tail = newNode; // tail is now end of list
		count++;  // increment counter for # of elements in list
		modCount++; // change made to list
	}

	@Override
	public void add(T element) {
		DLLNode<T> newNode = new DLLNode<T>(element); // newNode to hold parameter
		if (isEmpty()) {
			head = newNode; // head is now the new node added at beginning 
		} else {
			tail.setNext(newNode); // link tail to newNode if not empty
			newNode.setPrevious(tail);
		}
		tail = newNode; // tail is now end of list
		count++; // increment counter for # of elements in list
		modCount++; // change made to list
	}

	@Override //BEGIN HERE
	public void addAfter(T element, T target) {
		DLLNode<T> current = head; // initialize current node to head for list traversal
		boolean found = false; // initialize found to false
		while (current != null && !found) { // iterate through list unless at end or target found
			if (current.getElement() == target) {
				found = true;
			} else {
				current = current.getNext();
			}
		}
		if (!found) {
			throw new NoSuchElementException(); // throw exception if target is not in list
		}
		DLLNode<T> newNode = new DLLNode<T>(element); // newNode to hold parameter
		DLLNode<T> nextNode; // declare nextNode
		if(current == tail)
		{
			current.setNext(newNode); // add newNode at end of list
			newNode.setPrevious(tail);
			tail = newNode; // reassign tail to new end of list
			count++; // increment counter for # of elements in list
			modCount++; // change made to list
		}
		else {
			
			nextNode = current.getNext(); // assign nextNode to the node after current
			current.setNext(newNode); // link newNode to list 
			newNode.setNext(nextNode); // link newNode to previous nextNode
			newNode.setPrevious(current);
			modCount++; // change made to list
			count++; // increment counter for # of elements in list
		}
		} 

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		if (index < 0 || index > count) { // check if index is in bounds
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			addToFront(element); // call addToFront if adding at index 0
		} else if (index == count) {
			addToRear(element); // addToRear is called if adding to end of list
		} else {
			DLLNode<T> current = head; // traversal node

			for (int i = 0; i < index-1; i++) 
			{
				current = current.getNext(); // traverse to index prior to insertion
			}
			DLLNode<T> nextNode = current.getNext(); // create nextNode to hold previous next
			DLLNode<T> newNode = new DLLNode<T>(element); // create newNode to hold element
			current.setNext(newNode); // connect newNode to list
			newNode.setNext(nextNode); // reconnect previous next to list
			newNode.setPrevious(current);
			count++; // increment counter for # of elements in list
			modCount++; // change made to list
		}
	}

	@Override
	public T removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException(); // nothing to remove
		}
		T value = head.getElement(); // value to be removed
		DLLNode<T> next = head.getNext(); // traverse to second node in list and store address 
		head.setNext(null); // disconnect removed element from list
		head = next; // set head to beginning of list
		
		if (count == 1) {
			tail = null; // set tail to null if list is now empty
		}
		count--; // decrement counter for # of elements in list
		modCount++; // change made to list
		return value; // return element removed
	}

	@Override
	public T removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException(); // can't remove if nothing to remove
		}
		T value = tail.getElement(); // value to be removed
		DLLNode<T> current = head; // traversal node
		if (count == 1) {
			head = null; // head and tail set to null if list now empty
			tail = null;
		} else {
			for (int i = 0; i < count - 2; i++) {
				current = current.getNext(); // traverse current to previous to tail
			}
			current.setNext(null); // remove end node from list
			tail = current; // change tail to new end of list
		}
		count--; // decrement counter for # of elements in list
		modCount++; // change made to list
		return value; // return element removed
	}

	@Override
	public T remove(T element) {
		
		DLLNode<T> currentNode = head; // traversal node
		DLLNode<T> previousNode = null; // node to keep track of previous position
		boolean found = false; // flag to determine if element found
		while (!found && currentNode != null) { //traverse list until element is found or list is empty
			if (currentNode.getElement().equals(element)) {
				found = true;
			} else {
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
		}
		if (!found) {
			throw new NoSuchElementException(); // not found in list
		}

		DLLNode<T> next = currentNode.getNext();
		if (currentNode == head) {
			head = next; // set head to newNode if first node was removed
		} else {
			previousNode.setNext(next); // can't occur if currentNode is head
		}
		if (currentNode == tail) {
			tail = previousNode; // set tail to node previous of end if end removed
		}
		currentNode.setNext(null); // disconnect removed node
		modCount++; // changes made to list
		count--; // decrement # of elements in list
		return currentNode.getElement(); // return removed element
	}

	@Override
	public T remove(int index) { 
		if (index < 0 || index >= count) { // check index bounds
			throw new IndexOutOfBoundsException();
		}
		T value;
		if (index == 0) {
			value = head.getElement();
			removeFirst(); // use remove first if index specifies first in list
			return value;
		}
		DLLNode<T> currentNode = head;
		for (int i = 0; i < index - 1; i++) {
			currentNode = currentNode.getNext(); //traverse list until previous index
		}
		DLLNode<T> nextNode = currentNode.getNext(); // set nextNode for clarity
		currentNode.setNext(nextNode.getNext()); // connect previous node to index to node after index
		value = nextNode.getElement(); //temporarily store value removed
		nextNode.setNext(null); //disconnect from list
		nextNode.setPrevious(currentNode);
		if (index == count - 1) {
			tail = currentNode; // set tail if removing end node
		}
		count--; // decrement # of elements in list
		modCount++; // list changed
		return value; // return removed element
	}

	@Override
	public void set(int index, T element) {
		if (index < 0 || index >= count) { //check bounds provided by interface
			throw new IndexOutOfBoundsException();
		}
		DLLNode<T> currentNode = head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.getNext(); // traverse to index
		}
		currentNode.setElement(element); // set element at index
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException();
		}
		DLLNode<T> current = head; // traversal node
		for (int i = 0; i < index; i++) {
			current = current.getNext(); //progress to index

		}
		return current.getElement(); // return element at index
	}

	@Override
	public int indexOf(T item) {
		boolean found = false; // flag for stopping while loop if found
		DLLNode<T> current = head;
		int index = 0;
		while (!found && current != null) { // traverse until found or end
			if (current.getElement().equals(item)) {
				found = true;
			} else {
				current = current.getNext();
				index++;
			}
		}
		if (!found) {
			index = -1; // return -1 if not in list
		}

		return index; // return index if in list
	}

	@Override
	public T first() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.getElement(); // return first element in list
	}

	@Override
	public T last() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return tail.getElement(); // return last element in list
	}

	@Override
	public boolean contains(T target) {
		if (isEmpty()) { // not in if empty
			return false;
		}
		DLLNode<T> current = head; // traversal node
		for (int i = 0; i < count; i++) {
			if (current.getElement() == target) {
				return true; // return true if found
			}
			current = current.getNext();
		}
		if (tail.getElement() == target) {
			return true; 
		}
		return false; // return false if not in list
	}

	@Override
	public boolean isEmpty() {
		return (count == 0); // true if empty list
	}

	@Override
	public int size() {
		return count; // return # of elements in list
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new List2Iterator(); // returns iterator
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return new ListImplementedIterator(); // not implemented
	}

	@Override
	public ListIterator<T> listIterator(int startingIndex) {
		// TODO Auto-generated method stub
		return new ListImplementedIterator(startingIndex); // not implemented
	}

	private class List2Iterator implements Iterator<T> {
		private DLLNode<T> next; // node indicating next
		private DLLNode<T> previous; // node indicating previous
		private DLLNode<T> current; // node indicating current position
		private DLLNode<T> end; // node indicating end of linked list
		private int iteratorModCount; // count to tell if list has changed
		private Boolean canRemove; // flag for if a node can be removed

		public List2Iterator() {
			next = head; // start next at first in list
			iteratorModCount = modCount; // no differences when created
			canRemove = false; // needs to call next first
			current = null; // before next
			previous = null; // before current
			if(!isEmpty())
			tail.setNext(end);
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if (next != end || next!=null) {
				return true; // return true if not past last node
			}
			return false;
		}

		@Override
		public T next() {
			checkModifications();
			if (!hasNext()) {
				throw new NoSuchElementException("End of list");
			}
			T value = next.getElement(); // temp variable for element at next
			previous = current; // set previous before moving current and next
			current = next; // set current before moving next
			next = next.getNext(); // finally set next to next node
			canRemove = true; // can be removed after successful next call

			return value; // return value at next before moved
		}

		@Override
		public void remove() {
			checkModifications();
			if (!canRemove) { // check flag
				throw new IllegalStateException("Can't remove element");
			}
			canRemove = false; // cannot call remove consecutively
			if (current == head) {
				head = next; // keep head at beginning of list

			} else {
				previous.setNext(next); // can't call method on null, which is what previous is at current = head
			}
			current.setNext(null); // remove link
			if (current == tail) {
				tail = previous; // maintain tail reference
			}
		}

		private void checkModifications() {
			if (iteratorModCount != modCount) { // error if list is changed outside iterator after instantiation of iterator
				throw new ConcurrentModificationException("Changes made to list");
			}
		}
	}

	private class ListImplementedIterator implements ListIterator<T> {
		private DLLNode<T> next; // node indicating next
		private DLLNode<T> end; // node indicating end of linked list
		private int iteratorModCount; // count to tell if list has changed
		private Boolean canRemove; // flag for if a node can be removed
		private Boolean calledLast; // True if next was called last, false if previous was called last
		private Boolean canSet;
		
		public ListImplementedIterator() {
			end = new DLLNode<T>(null);
			if(isEmpty())
			{
			head = end;
			tail = end;
			}
			next = head; // start next at first in list
			iteratorModCount = modCount; // no differences when created
			canRemove = false; // needs to call next first
			canSet = false;
			if(!isEmpty())
			tail.setNext(end);
		}

		public ListImplementedIterator(int index) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
			if(next != end )
				return true;
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			checkModifications();
			if (!hasNext()) {
				throw new NoSuchElementException("End of list");
			}
			T value = next.getElement(); // temp variable for element at next
			next.getNext().setPrevious(next);
			next = next.getNext(); // finally set next to next node
			canRemove = true; // can be removed after successful next call
			calledLast = true;
			canSet = true;
			return value; // return value at next before moved
		}

		@Override
		public boolean hasPrevious() {
			if(next == head || isEmpty())
			{
				return false;
			}
			return true;
		}

		@Override
		public T previous() {
			checkModifications();
			if(!hasPrevious())
			{
				throw new NoSuchElementException("Beginning of List");
			}
			T value;
			if(next == end)
			{
				next = tail;
				value = next.getElement();
			}
			else
			{
			    value = next.getPrevious().getElement();
				next = next.getPrevious();
				next.setNext(next.getNext());
				next.setPrevious(next.getPrevious());
				
			}
			canRemove = true;                
			calledLast = false;
			canSet = true;
			return value;
			
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			if(!hasNext())
				return count;
			boolean found = false;
			DLLNode<T> traversal = head;
			int index = 0;
			T temp = next.getElement();
			while (!found && traversal != end) { // traverse until found or end
				if (traversal.getElement().equals(temp)) {
					found = true;
				} else {
					traversal = traversal.getNext();
					index++;
				}
			}
			return index;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			boolean found = false;
			DLLNode<T> traversal = head;
			int index = 0;
			if (!hasPrevious())
				return -1;
			T temp =(next.getPrevious().getElement());
			while (!found && traversal != end) { // traverse until found or end
				if (traversal.getElement().equals(temp)) {
					found = true;
				} else {
					traversal = traversal.getNext();
					index++;
				}
			}
			return index;
		}

		@Override
		public void remove() {
			checkModifications();
			if(canRemove)
			{
				canRemove = false;
				canSet = false;
				count --;
				if(calledLast)
				{
					canSet = false;
					if (next.getPrevious() == head) 
					{
						next.setPrevious(null);
						head = next; // keep head at beginning of list
					} 
					else 
					{
						next.getPrevious().getPrevious().setNext(next); // can't call method on null, which is what previous is at current = head
						next.setPrevious(next.getPrevious().getPrevious());
					}
					
				}	
				else
				{
					if(next == head)
					{
						head = next.getNext();
						
					}
					else
					{
						next.getPrevious().setNext(next.getNext());
						next.getNext().setPrevious(next.getPrevious());
					}
					if(next == tail)
					{
						tail = next.getPrevious();
						
					}
					next = next.getNext(); //MAYBE NOT
				}
			}
			else
			throw new IllegalStateException();

		}

		@Override
		public void set(T e) {
			// TODO Auto-generated method stub
			if(!canSet)
			{
				throw new IllegalStateException();
			}
			if(calledLast)
			{
				next.getPrevious().setElement(e);
			}
			else
			{
				next.setElement(e);
			}
		}

		@Override
		public void add(T e) {
			DLLNode<T> newNode = new DLLNode<T>(e);
			if(isEmpty())
			{
				head = newNode;
				head.setNext(end);
				next.setPrevious(newNode);
				tail = head;
			}
			else if (next == head)
			{
				newNode.setNext(next);
				next.setPrevious(newNode);
				head = newNode;
			}
			
			else if(next == end)
			{
				tail = newNode;
				tail.setNext(end);
				next.setPrevious(tail);
			}
			else if (next.getPrevious()==head)
			{
				head.setNext(newNode);
				newNode.setNext(next);
				next.setPrevious(newNode);
			}
			else if(next != end)
			{
				next.getPrevious().setNext(newNode);
				newNode.setNext(next);
				next.setPrevious(newNode);
			}
			count ++;
			canSet = false;
			canRemove = false;
		}
		private void checkModifications() {
			if (iteratorModCount != modCount) { // error if list is changed outside iterator after instantiation of iterator
				throw new ConcurrentModificationException("Changes made to list");
			}
	}
}
}