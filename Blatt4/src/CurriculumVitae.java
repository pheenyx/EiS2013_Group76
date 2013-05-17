import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class represents a curriculum vitae, that can be created via Latex.
 * 
 * @author Matthias Heinz
 * @since 08.05.2013
 */
public class CurriculumVitae {

	private String firstName;
	private String lastName;
	private String street;
	private String streetNumber;
	private int postalCode;
	private String city;
	private String phone;
	private String eMail;
	/**
	 * If picture==null, no valid path is given.
	 */
	private String picture;
	private ArrayList<Section> sections;
	private CVTheme theme;

	/**
	 * Constructor
	 */
	public CurriculumVitae() {
		sections = new ArrayList<Section>();
	}

	/**
	 * Constructor Sets the following attributes for curriculumVitae.
	 * 
	 * @param firstName
	 *            - a String
	 * @param lastName
	 *            - a String
	 * @param street
	 *            - a String
	 * @param streetNumber
	 *            - a String
	 * @param postalCode
	 *            - an int
	 * @param city
	 *            - a String
	 * @param phone
	 *            - a String
	 * @param eMail
	 *            - a String
	 */
	public CurriculumVitae(String firstName, String lastName, String street,
			String streetNumber, int postalCode, String city, String phone,
			String eMail) {
		setFirstName(firstName);
		setLastName(lastName);
		setStreet(street);
		setStreetNumber(streetNumber);
		setPostalCode(postalCode);
		setCity(city);
		setPhone(phone);
		setMobile(eMail);
		setPicture(null);
		sections = new ArrayList<Section>();
	}

	/**
	 * Constructor Sets the following attributes for curriculumVitae.
	 * 
	 * @param firstName
	 *            - a String
	 * @param lastName
	 *            - a String
	 * @param street
	 *            - a String
	 * @param streetNumber
	 *            - a String
	 * @param postalCode
	 *            - an int
	 * @param city
	 *            - a String
	 * @param phone
	 *            - a String
	 * @param eMail
	 *            - a String
	 * @param picture
	 *            - a String representing the path of the picture
	 */
	public CurriculumVitae(String firstName, String lastName, String street,
			String streetNumber, int postalCode, String city, String phone,
			String eMail, String picture) {
		setFirstName(firstName);
		setLastName(lastName);
		setStreet(street);
		setStreetNumber(streetNumber);
		setPostalCode(postalCode);
		setCity(city);
		setPhone(phone);
		setMobile(eMail);
		setPicture(picture);
		sections = new ArrayList<Section>();
	}

	/**
	 * Converts all Umlauts {ä, Ä, ö, Ö, ü, Ü, ß} into a Latex-friendly manner.
	 * 
	 * @param arg
	 * @return the converted arg
	 */
	private String convertUmlaut(String arg) {
		String result = new String(arg);
		result = result.replace("ä", "\\\"a").replace("Ä", "\\\"A").replace(
				"ö", "\\\"o");
		result = result.replace("Ö", "\\\"O").replace("ü", "\\\"u").replace(
				"Ü", "\\\"U");
		return result.replace("ß", "\\ss ");
	}

	/**
	 * Returns the String-representation of the personalData in a
	 * Latex-friendly-form.
	 * 
	 * @return String-representation of personalData
	 */
	private String createPersonalData() {
		return "%given personal data\n" + "\\firstname{"
				+ convertUmlaut(firstName) + "}\n" + "\familyname{"
				+ convertUmlaut(lastName) + "}\n"
				+ (picture == null ? "" : "\\photo[96pt]{" + picture + "}\n");
	}

	/**
	 * Returns the String-representation of the mobile-number in a
	 * Latex-friendly-form.
	 * 
	 * @return String-representation of mobile/phone-number
	 */
	private String createMobileLine() {
		return "\\cvline{\\mobilesymbol}{" + phone + "}\n";
	}

	/**
	 * Returns the String-representation of the eMail in a Latex-friendly-form.
	 * 
	 * @return String-representation of eMail
	 */
	private String createEMailLine() {
		return "\\cvline{\\emailsymbol}{\\href{mailto:" + eMail + "}{" + eMail
				+ "}}\n";
	}

	/**
	 * Writes down the Latex-code for a Latex-based CV into a ".-tex"-File
	 * 
	 * @param file
	 *            - a ".tex"-File
	 * @throws IllegalArgumentException
	 *             if file is null or invalid.
	 */
	public void writeCV(String file) {
		if (file == null || !file.endsWith(".tex"))
			throw new IllegalArgumentException();
		File f = new File(file);
		if (!f.isFile())
			throw new IllegalArgumentException();

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(f));
			// header
			bw
					.write("%use class moderncv\n"
							+ "\\documentclass[11pt,a4paper]{moderncv}\n"
							+ "\\moderncvtheme["
							+ theme.getColor().toString().toLowerCase() + "]{"
							+ theme.getStyle().toString().toLowerCase()
							+ "}\n\n" + "%language package\n"
							+ "\\usepackage[german]{babel}\n\n");
			// personal data
			bw.write(createPersonalData() + createMobileLine()
					+ createEMailLine());
			// settings
			bw.write("%create a document\n" + "\\begin{document}\n\n"
					+ "%create title based on personal data\n"
					+ "\\maketitle)\n\n");
			// add sections
			for (Section s : sections)
				bw.write(convertUmlaut(s.createSection()));
			// end doc
			bw.write("\\end {document}");
			bw.flush();
		} catch (IOException ex) {
			// should not happen
		} finally {
			if (bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					// just don't do anything.
				}
		}
	}

	/**
	 * Adds a new section to this cv.
	 * 
	 * @param name
	 *            - the name of the section
	 * @throws IllegalArgumentException
	 *             if and only if the name==null or name is "".
	 */
	public void addSection(String name) throws IllegalArgumentException {
		if (name == null || name.equals(""))
			throw new IllegalArgumentException();
		sections.add(new Section(name));
	}

	/**
	 * @return the sections
	 */
	public Section[] getSections() {
		return sections.toArray(new Section[sections.size()]);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the theme
	 */
	public CVTheme getTheme() {
		return theme;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 * @throws IllegalArgumentException
	 *             if and only if firstName==null or firstName is "".
	 */
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.equals(""))
			throw new IllegalArgumentException();
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 * @throws IllegalArgumentException
	 *             if and only if lastName==null or lastName is "".
	 */
	public void setLastName(String lastName) throws IllegalArgumentException {
		if (lastName == null || lastName.equals(""))
			throw new IllegalArgumentException();
		this.lastName = lastName;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 * @throws IllegalArgumentException
	 *             if and only if street==null or street is "".
	 */
	public void setStreet(String street) throws IllegalArgumentException {
		if (street == null || street.equals(""))
			throw new IllegalArgumentException();
		this.street = street;
	}

	/**
	 * @return the streetNumber
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	/**
	 * @param streetNumber
	 *            the streetNumber to set
	 * @throws IllegalArgumentException
	 *             if and only if streetNumber==null or streetNumber is ""
	 */
	public void setStreetNumber(String streetNumber)
			throws IllegalArgumentException {
		if (streetNumber == null || streetNumber.equals(""))
			throw new IllegalArgumentException();
		this.streetNumber = streetNumber;
	}

	/**
	 * @return the postalCode
	 */
	public int getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 * @throws IllegalArgumentException
	 *             if and only if postalCode < 0
	 */
	public void setPostalCode(int postalCode) throws IllegalArgumentException {
		if (postalCode < 0)
			throw new IllegalArgumentException();
		this.postalCode = postalCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 * @throws IllegalArgumentException
	 *             if and only if city==null or city is ""
	 */
	public void setCity(String city) throws IllegalArgumentException {
		if (city == null || city.equals(""))
			throw new IllegalArgumentException();
		this.city = city;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * phone has to start with '+' followed by numbers only.
	 * 
	 * @param phone
	 *            the phone to set IllegalArgumentException if and only if
	 *            phone==null or phone is not valid in the above terms.
	 */
	public void setPhone(String phone) throws IllegalArgumentException {
		if (phone == null || phone.equals("") || !phone.startsWith("+"))
			throw new IllegalArgumentException();
		for (int i = 1; i < phone.length(); i++)
			if (!Character.isDigit(phone.charAt(i)))
				throw new IllegalArgumentException();

		this.phone = phone;
	}

	/**
	 * @return the eMail
	 */
	public String getEMail() {
		return eMail;
	}

	/**
	 * eMail has to contain a '@'-sign.
	 * 
	 * @param eMail
	 *            the eMail to set
	 * @throws IllegalARgumentException
	 *             if and only if eMail==null or eMail does not contain an
	 *             '@'-sign
	 */
	public void setMobile(String eMail) throws IllegalArgumentException {
		if (eMail == null || !eMail.contains("@"))
			throw new IllegalArgumentException();
		this.eMail = eMail;
	}

	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * If picture does not represent a file (not a folder!), null will be set to
	 * represent a missing picture.
	 * 
	 * @param picture
	 *            the picture to set
	 */
	public void setPicture(String picture) {
		if (picture == null || picture.equals("")
				|| !(new File(picture)).isFile())
			this.picture = null;
		else
			this.picture = picture;
	}

}
