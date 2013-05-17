/**
 * This class represents a cvProperty of CurriculumVitae; used to create a
 * curriculum vitae via Latex.
 * 
 * @author Matthias Heinz
 * @since 08.05.2013
 */
public abstract class CVProperty {

	protected String[] values;

	/**
	 * Returns the Latex-String-representation of this cvProperty
	 * 
	 * @return latex-String-representation
	 */
	public abstract String writeProperty();

	/**
	 * @return values
	 */
	public String[] getValues() {
		return values;
	}

	/**
	 * @param values
	 *            - the values to set
	 */
	public abstract void setValues(String[] values);
}
