
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
	
	public LinkStrand(){
		this("");
	}
	
	public LinkStrand(String s) {
		initialize(s);
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
	public String toString() {
		while (list != null) {
			
		}
	}

}
