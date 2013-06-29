import java.util.List;
import java.util.ListIterator;


public class FilteredListIterator<T> implements ListIterator<T> {
	
	private ObjectFilter<T> filter;
	private Entry<T> current;
	private List<T> list;

	public FilteredListIterator(ObjectFilter<T> filter, Entry<T> current, List<T> list) {
		this.filter = filter; 
		this.current = current;
		this.list = list;
	}
	
	public void add(T e) {
		// no implement
		throw new UnsupportedOperationException();
	}

	public boolean hasNext() {
		for (int i = list.indexOf(current) + 1; i < list.size(); i++) {
			if (filter.isValid(list.get(i)))
				return true;
		}
		return false;
	}

	public boolean hasPrevious() {
		for (int i = list.indexOf(current) - 1; i > 0; i--) {
			if (filter.isValid(list.get(i)))
				return true;
		}
		return false;
	}

	public T next() {
		for (int i = list.indexOf(current) + 1; i < list.size(); i++) {
			if (filter.isValid(list.get(i)))
				return list.get(i);
		}
		return null;
	}

	public int nextIndex() {
		for (int i = list.indexOf(current) + 1; i < list.size(); i++) {
			if (filter.isValid(list.get(i)))
				return i;
		}
		return -1;
	}

	public T previous() {
		for (int i = list.indexOf(current) - 1; i > 0; i--) {
			if (filter.isValid(list.get(i)))
				return list.get(i);
		}
		return null;
	}

	public int previousIndex() {
		for (int i = list.indexOf(current) - 1; i > 0; i--) {
			if (filter.isValid(list.get(i)))
				return i;
		}
		return -1;
	}

	public void remove() {
		// no implement
		throw new UnsupportedOperationException();
	}

	public void set(T e) {
		// no implement
		throw new UnsupportedOperationException();
	}

}
