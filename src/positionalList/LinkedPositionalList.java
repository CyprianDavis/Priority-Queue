package positionalList;
/**
 * Implementation of a positional list stored as doubly linked list
 * @author CYPRIAN DAVIS
 *
 * @param <T>
 */

public class LinkedPositionalList<T> implements PositionalList<T>{
	//nesed Node Class
	private static class Node<T>implements Position<T>{
		private T element;		//reference to the element stored at this node
		private Node<T>prev;	//reference to the previous node in the list
		private Node<T>next;	//reference to the subsequent node in the list
		
		public Node(T e, Node<T> p, Node<T>n) {
			element = e;
			prev = p;
			next = n;
		}
		
		@Override
		public T getElement() throws IllegalStateException {
			// TODO Auto-generated method stub
			if(next == null)
				throw new IllegalStateException("Position no loger valid");
			return element;
		}
		public Node<T> getPrev(){
			return prev;
		}
		public Node<T> getNext(){
			return next;
		}
		public void setElemnet(T e) {
			element = e;
		}
		public void setNext(Node<T> n) {
			next = n;
		}
		public void setPrev(Node<T> p) {
			prev = p;
		}
		
	}//---end of nested Node Class

	//Instance variables of the linkedPositional List
	private Node<T> header;		//header sentinel
	private Node<T>trailer;		//trailer sentinel
	private int size =0;
	
	/**Construts a new empty list*/
	public LinkedPositionalList() {
		header = new Node<>(null,null,null); //create header
		trailer = new Node<>(null,header,null);//tailer is preceded by header
		header.setNext(trailer);
		
	}
	//private utilities
	/**Validate the position and returns it as a node*/
	private Node<T> validate(Position<T> p) throws IllegalArgumentException{
		if(!(p instanceof Node))throw new IllegalArgumentException("Invalid p");
		Node<T> node = (Node<T>)p; //safe cast
		if(node.getNext() == null) //convention for defunct node
			throw new IllegalArgumentException("P is no longer in the list");
		return node;	
	}
	
	private Position<T> position(Node<T> node){
		if(node == header||node==trailer)
			return null; //do not expose user to the sentinels
		return node;
		
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public Position<T> first() {
		// TODO Auto-generated method stub
		return position(header.getNext());
	}

	@Override
	public Position<T> last() {
		// TODO Auto-generated method stub
		return position(trailer.getPrev());
	}

	@Override
	public Position<T> before(Position<T> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<T> node = validate(p);
		return position(node.getPrev());
	}

	@Override
	public Position<T> after(Position<T> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<T> node =validate(p);
		
		return position(node.getNext());
	}
	
	private Position<T> addBetween(T e, Node<T> pred, Node<T>succ){
		Node<T> newest = new Node<>(e,pred,succ); //create and link a new node
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;
		
	}
	
	@Override
	public Position<T> addFirst(T e) {
		// TODO Auto-generated method stub
		return addBetween(e,header,header.getNext());//just after header
	}

	@Override
	public Position<T> addLast(T e) {
		// TODO Auto-generated method stub
		return addBetween(e,trailer.getPrev(),trailer);
	}

	@Override
	public Position<T> addBefore(Position<T> P, T e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<T> node = validate(P);
		return addBetween(e,node.getPrev(),node);
	}

	@Override
	public Position<T> addAfter(Position<T> p, T e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<T> node = validate(p);
		
		return addBetween(e,node,node.getNext()) ;
	}

	@Override
	public T set(Position<T> p, T e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<T>node = validate(p);
		T answer = node.getElement();
		node.setElemnet(e);
		return answer;
	}

	@Override
	public T remove(Position<T> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<T> node = validate(p);
		Node<T>predecessor = node.getPrev();
		Node<T>successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		T answer =node.getElement();
		node.setElemnet(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}
	public String ToString() {
		return null;
		
	}

}
