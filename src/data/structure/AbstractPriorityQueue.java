package data.structure;

import java.util.Comparator;
/**
 * 
 * @author CYPRIAN DAVIS
 *
 * @param <K>
 * @param <V>
 */

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {
	/***
	 * PQEntry
	 * @author CYPRIAN DAVIS
	 *
	 * @param <K>
	 * @param <V>
	 */
	protected static class PQEntry<K,V> implements Entry<K,V>{
		private K k; //key stored at this entry
		private V v; //Value stored at this entry
		
		public PQEntry(K k, V v) {
			this.k = k;
			this.v =v;
		}
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return k;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return v;
		}
		
		//protected motheds (not exposed as part of the entity Interface)
		/**Sets the key stored at this entry*/
		protected void setKey(K k) {
			this.k = k;
		}
		//Sets the value stored at this Entry
		protected void setValue(V v) {
			this.v = v;
		}
		public String toString() {
			return "{"+v+","+k+"}";
			
		}
		
	}//end of the PQEntry inner class
	
	//Instance Variables
	/** The comparator defining the ordering of keys in the priority queue. */
	private Comparator<K> comp;
	//Creates an empty priority queue using the given comparator order keys
	protected AbstractPriorityQueue(Comparator<K>c) {
		comp =c;
	}
	/**creates an empty Priority queue based on the natural ordering of its key*/
	protected AbstractPriorityQueue() {
		this(new DefaultComparator<K>());
	}
	/**Determines whether a key is Vaild*/
	protected boolean ckeckKey(K key) throws IllegalArgumentException{
		try {
			return(comp.compare(key, key)==0); //check if key can be compared to itself
		}catch(ClassCastException e) {
			throw new IllegalArgumentException("Incompatable Key");
		}
	}
	/**Compares two entries according to key*/
	protected int compare(Entry<K,V>a, Entry<K,V>b) {
		return comp.compare(a.getKey(),b.getKey());
	}
	
	/*Tests whether the Queue is empty*/
	public boolean isEmpty() {
		return size() ==0;
	}
	
	
}
