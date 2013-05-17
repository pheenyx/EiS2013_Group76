import java.util.ArrayList;

/**
 * This class represents a section used in CurriculumVitae.
 * 
 * @author Matthias Heinz
 * @since 08.05.2013
 */
public class Section {

	private String name;
	private ArrayList<CVProperty> entries;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            - the name of this section
	 * @throws IllegalArgumentException
	 *             if and only if name==null or name is ""
	 */
	public Section(String name) throws IllegalArgumentException {
		if (name == null || name.equals(""))
			throw new IllegalArgumentException();
		this.name = name;
		entries = new ArrayList<CVProperty>();
	}

	@Override
	public String toString() {
		return name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds prop at the end of the entry-list.
	 * 
	 * @param prop
	 *            - the property to add
	 * @throws NullPointerException
	 *             if and only if prop==null
	 */
	public void addEntry(CVProperty prop) throws NullPointerException {
		if (prop == null)
			throw new NullPointerException();
		entries.add(prop);
	}

	/**
	 * Inserts prop at the specified position in this list. Shifts the element
	 * currently at that position (if any) and any subsequent elements to the
	 * right (adds one to their indices).
	 * 
	 * @param prop
	 *            - the property to add
	 * @param index
	 *            - the index, where to add prop
	 * @throws NullPointerException
	 *             if and only if prop==null
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index > length)
	 */
	public void addEntryAt(CVProperty prop, int index)
			throws NullPointerException, IndexOutOfBoundsException {
		if (prop == null)
			throw new NullPointerException();
		if (index < 0 || index > entries.size())
			throw new IndexOutOfBoundsException();
		entries.add(index, prop);
	}

	/**
	 * Returns the entries.
	 * 
	 * @return entries
	 */
	public CVProperty[] getEntries() {
		return entries.toArray(new CVProperty[entries.size()]);
	}

	/**
	 * Returns the String-representation of this section; written to compile
	 * with Latex.
	 * 
	 * @return String-representation
	 */
	public String createSection() {
		StringBuilder sb = new StringBuilder("\\section{" + name + "}\n");
		for (CVProperty prop : entries)
			if (prop != null)
				sb.append(prop.writeProperty());
		return sb.toString();
	}

}
