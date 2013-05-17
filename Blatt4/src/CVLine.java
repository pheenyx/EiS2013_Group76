/**
 * A cvLine for CurriculumVitae.
 * 
 * @author Matthias Heinz
 * @since 08.05.2013
 * @see CVProperty
 */
public class CVLine extends CVProperty {

	/**
	 * Constructor Sets the values representing this cvLine.
	 * 
	 * @param values
	 *            - the values to set
	 * @throws IllegalArgumentException
	 *             if values.length != 2 or values == null or values[1] is (null
	 *             or "")
	 */
	public CVLine(String[] values) throws IllegalArgumentException {
		setValues(values);
	}

	@Override
	public String writeProperty() {
		return "\\cvline{" + (values[0] == null ? "" : values[0]) + "}{"
				+ values[1] + "}";
	}

	/**
	 * @param values
	 *            - the values to set
	 * @throws IllegalArgumentException
	 *             if values.length != 2 or values == null or values[1] is (null
	 *             or "")
	 */
	@Override
	public void setValues(String[] values) throws IllegalArgumentException {
		if (values == null || values.length != 2 || values[1] == null
				|| values[1].equals(""))
			throw new IllegalArgumentException();

		this.values = values;
	}

}
