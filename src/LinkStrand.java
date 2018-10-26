
public class LinkStrand implements IDnaStrand {
	private class Node{
		String info;
		Node next;
		public Node(String s) {
			info = s;
			next = null;
		}
	}
	private Node myFirst, myLast;
	private long mySize;
	private int myAppends;
	private int myIndex;
	private Node myCurrent;
	private int myLocalIndex;
	
	public LinkStrand(){
		this("");
	}
	
	public LinkStrand(String s) {
		initialize(s);
	}
	
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
	
	@Override
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
	}
	
	@Override 
	public long size() {
		return mySize;
	}
	
	
	@Override 
	public int getAppendCount() {
		return myAppends;
	}
	
	@Override
	public IDnaStrand append(String dna) {
		Node d = new Node(dna);
		myLast.next = d; 
		mySize += dna.length();
		myAppends += 1;
		return this; 
	}
	
	@Override
	public IDnaStrand reverse() {
		Node current = myFirst;
		StringBuilder copy = new StringBuilder(current.info);
		while(current != null) {
			current.next = current;
			copy.append(current.info);
		}
		copy.reverse();
		LinkStrand reversed = new LinkStrand(copy.toString());
		
		return reversed;
		
	}
	
	@Override
	public void initialize(String source) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char charAt(int index) {
		if (index>= mySize || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (myAppends > index) {
			myCurrent = myFirst;
			myIndex = 0;
			myLocalIndex = 0;
		}
		
		while (myIndex != index) {
			myIndex += 1;
			myLocalIndex += 1;
			if (myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				myCurrent = myCurrent.next;
			}
		}
		myIndex = index;
		return myCurrent.info.charAt(myLocalIndex);
	}
	
	
	
	

}
