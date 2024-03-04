package data.structure;
/**
 * Interface for priority Queue
 * @author CYPRIAN
 *
 * @param <K>
 * @param <V>
 */
public interface PriorityQueue<K, V> {
	//Returns ture if the priorityQueue is empty or false otherwise
	boolean isEmpty();
	//Returns the number of entries on the priority Queue
	int size();
	//Adds a new entry to the priority Queue
	Entry<K,V> add(K key, V value);
	
	Entry<K,V> getMin();
	

}
