/**
 * A cvEntry for CurriculumVitae.
 * 
 * @author Matthias Heinz
 * @since 08.05.2013
 * @see CVProperty
 */
public class CVEntry extends CVProperty {

	/**
	 * Constructor Sets the values representing this cvEntry.
	 * 
	 * @param values
	 *            - the values to set
	 * @throws IllegalArgumentException
	 *             if values.length != 6 or values == null or [(values[0] or
	 *             values[1]) is (null or "")]
	 */
	public CVEntry(String[] values) throws IllegalArgumentException {
		setValues(values);
	}

	@Override
	public String writeProperty() {
		StringBuilder sb = new StringBuilder("\\cventry{");
		for (int i = 0; i < values.length; i++)
			sb.append((values[i] == null ? "" : values[i]) + "}{");

		return sb.append("}").toString();
	}

	/**
	 * @param values
	 *            - the values to set
	 * @throws IllegalArgumentException
	 *             if values.length != 6 or values == null or [(values[0] or
	 *             values[1]) is (null or "")]
	 */
	@Override
	public void setValues(String[] values) throws IllegalArgumentException {
		if (values == null || values.length != 6 || values[0] == null
				|| values[0].equals("") + values[1] == null
				|| values[1].equals(""))
			throw new IllegalArgumentException();

		this.values = values;
	}

}
