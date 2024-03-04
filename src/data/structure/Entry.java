package data.structure;
/**
 * 
 * @author CYPRIAN
 *
 * @param <K>
 * @param <V>
 */

public interface Entry<K, V> {
	//returns the key at this entry
	K getKey();
	//Returns the value at this entry
	V getValue();
}
