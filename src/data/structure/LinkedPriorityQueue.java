package data.structure;

import java.util.Comparator;
import positionalList.LinkedPositionalList;
import positionalList.Position;
/**
 * 
 * @author CYPRIAN DAVIS
 *
 * @param <K>
 * @param <V>
 */
public class LinkedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>{
	private LinkedPositionalList<Entry<K,V>>entries = new LinkedPositionalList<>();
	public LinkedPriorityQueue() {
		super();
	}
	public LinkedPriorityQueue(Comparator<K> comp) {
		super(comp);
		
	}

	@Override
	/**Returns the number of entries in the queue*/
	public int size() {
		// TODO Auto-generated method stub
		return entries.size();
	}

	@Override
	/**Adds and returns new entry to the queue */
	public Entry<K, V> add(K key, V value) {
		// TODO Auto-generated method stub
		ckeckKey(key);
		Entry<K,V> newest = new PQEntry<>(key,value);
			Position<Entry<K,V>>runner = entries.last();
			//Walk backward, looking for smaller key
			while(runner!=null && compare(newest,runner.getElement())<0)
			  runner = entries.before(runner);
			if(runner == null)
				entries.addFirst(newest);
			else
				entries.addAfter(runner, newest);
		
		return newest;
	}

	@Override
	/**Returns the min entry in the queue */
	public Entry<K, V> getMin() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		
		return entries.first().getElement();
	}

	@Override
	/**Removes and returns the min element in the queue	*/
	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		
		return entries.remove(entries.first());
	}

}
