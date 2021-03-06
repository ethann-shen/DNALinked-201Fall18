
public class LinkStrand implements IDnaStrand {
	private class Node{
		String info;
		Node next;
		public Node(String s) {
			info = s;
			next = null;
		}
	}
	private Node myFirst, myLast, myCurrent;
	private long mySize;
	private int myAppends, myIndex, myLocalIndex;
	

	public LinkStrand() {
		this("");
	} 
	
	public LinkStrand(String s) {
		initialize(s);
	}

	@Override 
	public void initialize(String source) {
		myFirst = new Node(source);
		myLast = myFirst;
		myCurrent = myFirst;
		myAppends = 0;
		myIndex = 0;
		myLocalIndex = 0;
		mySize = source.length();
	}

	@Override
	public long size() {
		return mySize;
	}


	@Override
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
		
	}
 
	/**
	 * @param A dna strand that is represented by a string 
	 * @return Adds one new node to the end of the internal linked list and updates the state 
	 * to maintain the invariant 
	 */
	@Override
	public IDnaStrand append(String dna) {
		Node d = new Node(dna);
		myLast.next = d;
		mySize += dna.length();
		myAppends += 1;
		myLast = myLast.next;
		return this; 		
	}
	
	/**
	 * @return Returns the String representation of the DNA strand 
	 */
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node list = myFirst;
		while (list != null) {
			sb.append(list.info);
			list = list.next;
		}
		return sb.toString();
	}
	
	
	/**
	 * @return Creates a new LinkStrand object that is the reverse of the object on which it's called
	 * This returns a new strand and is not a mutator
	 */
	@Override
	public IDnaStrand reverse() {
		StringBuilder sb = new StringBuilder(myFirst.info);
		Node last = new Node(sb.reverse().toString());
		Node current = myFirst.next;
		Node prev = last;
		
		while (current != null) {
			StringBuilder sbb = new StringBuilder(current.info);
			last = new Node(sbb.reverse().toString());
			last.next = prev;
			prev = last;
			current = current.next;
		}
		
		LinkStrand reversed = new LinkStrand();
		while (last != null) {
			reversed.append(last.info);
			last = last.next;
		}
		return reversed;
	}
	  

	@Override
	public int getAppendCount() {
		return myAppends;
	}

	/**
	 * @param the index of the character, represented by an integer
	 * @return Returns the character at the specified index if it is a valid index;
	 * otherwise it throws an IndexOutOfBoundsException
	 */
	@Override
	public char charAt(int index) {		
		if (index >= mySize || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (myIndex > index) {
			myCurrent = myFirst;
			myIndex = 0;
			myLocalIndex = 0;
		}
		
		while (myIndex != index) {
			myIndex ++;
			myLocalIndex ++;
			
			if (myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				myCurrent = myCurrent.next;
			}
		}
		return myCurrent.info.charAt(myLocalIndex); 
	}
}
