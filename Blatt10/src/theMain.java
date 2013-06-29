import java.io.File;
import java.util.ListIterator;

public class theMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		File f = new File("/home/adminuser/workspace/EiS/src");
		String[] array = f.list();
		for (int i = 0; i < array.length; i++)
			if (array[i].substring(array[i].length() - 5, array[i].length()).equals(".java")) {
				list.add(array[i]);
			}
		ListIterator<String> it = list.iterator();
		while (it.hasNext()) 
			System.out.println(it.next());
	}

}
