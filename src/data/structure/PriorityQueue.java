package data.structure;
/**
 * Interface for priority Queue (Min Heap)
 * 
 * @author CYPRIAN
 *
 * @param <K>
 * @param <V>
 */
public interface PriorityQueue<K,V> {
	//Returns ture if the priorityQueue is empty or false otherwise
	boolean isEmpty();
	//Returns the number of entries on the priority Queue
	int size();
	//Adds a new entry to the priority Queue
	Entry<K,V> add(K key, V value);
	//Returns (without removing) the entry with the minimum key
	Entry<K,V> getMin();
	//Removes and Returns the entry with the minimum key
	Entry<K,V> removeMin();
	

}
