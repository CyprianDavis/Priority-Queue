package positionalList;
/***
 * An interface for positional list
 * @author CYPRIAN DAVIS
 *
 * @param <T>
 */
public interface PositionalList<T> {

	/**Returns the number of elements in the list*/
	int size();
	/**Tests whether the list is empty*/
	boolean isEmpty();
	/**Returns the first Position in the list(or null if empty)*/
	Position<T> first();
	/**Returns the last position in the list(or null if emepty)*/
	Position<T> last();
	/**Returns the position immediately before position P(or null if empty)*/
	Position<T> before(Position<T>p) throws IllegalArgumentException;
	/**Returns the position immediately after Position p(or null if empty)*/
	Position<T> after(Position<T> p)throws IllegalArgumentException;
	/**Inserts element e at the front position of the list and returns its new position*/
	Position<T> addFirst(T e);
	/**Inserts element e at the back of the list and returns its new position*/
	Position<T> addLast(T e);
	/**Inserts element e at immediately before Position p and returns its new position*/
	Position<T> addBefore(Position<T>P,T e) throws IllegalArgumentException;
	/**Inserts element e immediately afetr Position P and returns its new Position*/
	Position<T> addAfter(Position<T>p, T e) throws IllegalArgumentException;
	/**Replaces the element stored at Position P and returns the replaced element*/
	T set(Position<T>p, T e) throws IllegalArgumentException;
	/**Removes the element stored at positon p and returns it (invalidate p)*/
	T remove(Position<T>p) throws IllegalArgumentException;
	
	
	
}
