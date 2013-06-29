import java.util.ListIterator;


public class DoubleLinkedListIterator<T> implements ListIterator<T> {
	
	private Entry<T> current;
	private DoubleLinkedList<T> list;
	
	public DoubleLinkedListIterator(Entry<T> current, DoubleLinkedList<T> list) {
		this.current = current;
		this.list = list;
	}

	public void add(T arg0) {
		// no implement
		throw new UnsupportedOperationException();
	}

	public boolean hasNext() {
		return current.getNext() != null;
	}

	public boolean hasPrevious() {
		return current.getPrevious() != null;
	}

	public T next() {
		Entry<T> foo = current;
		current = current.getNext();
		return foo.getElement();
	}

	public int nextIndex() {
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			index++;
			if (list.get(i).equals(current))
				break;
		}
		return index + 1;
	}

	public T previous() {
		Entry<T> foo = current;
		current = current.getPrevious();
		return foo.getElement();
	}

	public int previousIndex() {
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			index++;
			if (list.get(i).equals(current))
				break;
		}
		return index - 1;
	}

	public void remove() {
		// no implement
		throw new UnsupportedOperationException();
	}

	public void set(T arg0) {
		// no implement
		throw new UnsupportedOperationException();
	}

}
