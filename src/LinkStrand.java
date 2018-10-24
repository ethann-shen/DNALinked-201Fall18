
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
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
	}
	
	@Override 
	public long size() {
		return mySize.size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		while (list != null) {
			StringBuilder.append(next.info);
		}
		
		return sb.toString();
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
	
	
	
	

}
