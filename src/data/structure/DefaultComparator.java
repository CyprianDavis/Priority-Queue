package data.structure;

import java.util.Comparator;

public class DefaultComparator<T> implements Comparator<T>{

	@SuppressWarnings("unchecked")
	@Override
	public int compare(T a, T b) throws ClassCastException{
		// TODO Auto-generated method stub
		return ((Comparable<T>)a).compareTo(b);
	}

}
