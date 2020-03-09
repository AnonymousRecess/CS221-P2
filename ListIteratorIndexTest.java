import java.nio.charset.Charset;
import java.util.ListIterator;
	
	public class ListIteratorIndexTest {
		
		 public static void main(String[] args)
		 {
			 IUDoubleLinkedList<Integer> some = new IUDoubleLinkedList<Integer>(); 
			 some.add(1);
			 some.add(1);
			 ListIterator test =  some.listIterator(2);
			System.out.println( test.next());
			
		 }
	}


