import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Exports a .TeX file of a basic CV with very little information about the
 * person.
 * 
 * @author Michael Mardaus
 * @author Julian Felix Rost
 */
public class CurriculumVitae {
    /**
     * the firstname.
     */
    private static String firstname;
    /**
     * the lastname.
     */
    private static String lastname;
    /**
     * the path of a picture file.
     */
    private static String picturePath;
    /**
     * the telephone number.
     */
    private static String telephone;
    /**
     * the email address.
     */
    private static String email;

    /**
     * the CV Theme.
     */
    private static CVTheme theme;
    
    /**
     * skill in languages.
     */
    private static ArrayList<String[]> LanguageSkills;
    
    public CurriculumVitae() {
        firstname = "";
        lastname = "";
        picturePath = null;
        telephone = "";
        email = "";
        theme = new CVTheme();
        LanguageSkills = new ArrayList<String[]>(); 
    }
    

    /**
     * @return the firstname
     */
    public static String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname
     *            the firstname to set
     */
    public final void setFirstname(final String firstname) {
        CurriculumVitae.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public static String getLastname() {
        return lastname;
    }

    /**
     * @param lastname
     *            the lastname to set
     */
    public final void setLastname(final String lastname) {
        CurriculumVitae.lastname = lastname;
    }

    /**
     * @return the picturePath
     */
    public static String getPicturePath() {
        return picturePath;
    }

    /**
     * @param picturePath
     *            the picturePath to set
     */
    public final void setPicturePath(final String picturePath) {
        CurriculumVitae.picturePath = picturePath;
    }

    /**
     * @return the telephone
     */
    public static String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     *            the telephone to set
     */
    public final void setTelephone(final String telephone) {
        CurriculumVitae.telephone = telephone;
    }

    /**
     * @return the email
     */
    public static String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public final void setEmail(final String email) {
        CurriculumVitae.email = email;
    }

    /**
     * @return the theme
     */
    public static CVTheme getTheme() {
        return theme;
    }

    /**
     * @param theme
     *            the theme to set
     */
    public final void setTheme(final CVTheme theme) {
        CurriculumVitae.theme = theme;
    }

    /**
     * @return the languageSkills
     */
    public final ArrayList<String[]> getLanguageSkills() {
        return LanguageSkills;
    }

    /**
     * adds a language to the skills.
     * @param lang the language
     * @param lk the knowledge
     */
    public final void addLanguageSkills(String lang, LanguageKnowledge lk) {
        String[] LanguageSkill = new String[2];
        LanguageSkill[0] = lang;
        LanguageSkill[1] = lk.getKnowledge();
        System.out.println(LanguageSkill[1]);
        CurriculumVitae.LanguageSkills.add(LanguageSkill);
    }

    /**
     * Replaces all german umlauts with LaTeX compatible ones.
     * 
     * @param s
     *            the input string
     * @return new replaced string
     */
    public static String convertUmlaut(final String s) {
        String newS = s.replaceAll("ä", "\\\\\"a").replaceAll("ü", "\\\\\"u")
                .replaceAll("ö", "\\\\\"o").replaceAll("ß", "\\\\ss ")
                .replaceAll("Ä", "\\\\\"A").replaceAll("Ö", "\\\\\"O")
                .replaceAll("Ü", "\\\\\"U");
        return newS;
    }

    /**
     * Generates the first lines with personal information.
     * 
     * @return two lines if the path is not accessible, three lines if a file is
     *         found at the given path.
     * @throws MissingNameException
     *             if a name is not given
     * @throws FileNotFoundException
     *             if the file is not accessible
     */
    public static String createPersonalData() throws MissingNameException,
            FileNotFoundException {

        if (getFirstname() == null || getLastname() == null) {
            throw new MissingNameException("first or lastname was null");
        }

        String s = "\\firstname{" + firstname + "}\n" + "\\familyname{"
                + lastname + "}\n";
        // try to read File
        if (getPicturePath() != null) {
            File f = new File(getPicturePath());
            if (f.isFile() && f.canRead()) {
                s = s + "\\photo[96pt]{" + picturePath + "}\n";
            } else {
                throw new FileNotFoundException(
                        "cannot find or read the given picture file");
            }
        }
        return s;
    }

    /**
     * Generates one line with phone information.
     * 
     * @return a single line
     * @throws InvalidMobileNumberException
     *             if the format is not correct
     * @throws InvalidCVLineException
     *             should not happen
     */
    public static String createMobileLine()
            throws InvalidMobileNumberException, InvalidCVLineException {
        String number = getTelephone();
        if (number != null && number.matches("^\\+[1-9]+[0-9 ]+$")) {
            return createCVLine("\\mobilesymbol", number);
        } else {
            throw new InvalidMobileNumberException(
                    "the phonenumber you entered is not valid");
        }
    }

    /**
     * Generates one line with email information.
     * 
     * @return a single line
     * @throws InvalidEmailException
     *             if the format is not correct
     */
    public static String createEmailLine() throws InvalidEmailException {
        String email = getEmail();
        if (email != null
                && email.matches("^[_A-Za-z0-9-\\+]+"
                        + "(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*"
                        + "(\\.[A-Za-z]{2,})$")) {
            return "\\cvline{\\emailsymbol}{\\href{mailto:" + email + "}{"
                    + email + "}}\n";
        } else {
            throw new InvalidEmailException(
                    "the emailadress you entered is not valid");
        }
    }

    /**
     * Generates generic cv line.
     * 
     * @param string1
     *            the first parameter
     * @param string2
     *            the second parameter
     * @return a single line
     * @throws InvalidCVLineException
     *             if the second string is not given
     */
    public static String createCVLine(final String string1, 
                                        final String string2)
            throws InvalidCVLineException {
        if (string2 != null && !string2.isEmpty()) {
            return "\\cvline{" + string1 + "} {" + string2 + "}\n";
        } else {
            throw new InvalidCVLineException("the cvline has no 2nd argument");
        }
    }

    /**
     * Generates a cv entry line.
     * 
     * @param entry
     *            a string array with exactly 6 strings
     * @return a single line
     * @throws InvalidCVEntryException
     *             if one of the first two strings is empty
     */
    public static String createCVEntry(final String[] entry)
            throws InvalidCVEntryException {
        if (entry != null && entry.length == 6 && entry[0] != null
                && entry[1] != null && !entry[0].isEmpty()
                && !entry[1].isEmpty()) {
            return "\\cventry{" + entry[0] + "} {" + entry[1] + "} {"
                    + entry[2] + "} {" + entry[3] + "} {" + entry[4] + "} {"
                    + entry[5] + "}\n";
        } else {
            throw new InvalidCVEntryException("the cv entry is malformed");
        }
    }

    /**
     * Writes curriculum vitae to file. File must be writeable and have a .tex
     * file extension.
     * 
     * @param path
     *            full path to file including file name
     * @throws InvalidFileException
     *             if file at path is not writeable or not a .tex file
     */
    public void writeCV(final String path) throws InvalidFileException {
        File file = new File(path);
        if (!(file.getName().matches("(\\w)*\\.tex")))
            throw new InvalidFileException("File is not a .tex file.");
        if (file.getParent() == "null")
            if (!(new File(".")).canWrite())
                throw new InvalidFileException("Cannot write to destination "
                        + "directory (.).");
            else if (!((new File(file.getParent()).canWrite())))
                throw new InvalidFileException("Cannot write to destination "
                        + "directory (" + file.getParent() + ").");
        RandomAccessFile rafile = null;
        try {
            rafile = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) { /* file will be created */
        }
        ;
        try {
            rafile.writeBytes("%use class moderncv\n"
                    + "\\documentclass[11pt, a4paper] {moderncv}\n\n"
                    + "%language package\n"
                    + "\\usepackage [german]{babel}\n\n" + "%chosen theme\n"
                    + "\\moderncvtheme [" + getTheme().getColor() + "]{"
                    + getTheme().getStyle() + "}\n\n");
            
            rafile.writeBytes(convertUmlaut(createPersonalData()));
            rafile.writeBytes("\n\\begin{document}\n\n\\maketitle\n\n"
                    + "\\section{Kontaktdaten}\n");
            rafile.writeBytes(convertUmlaut(createMobileLine()));
            rafile.writeBytes(convertUmlaut(createEmailLine()));
            
            rafile.writeBytes("\n\\section{Ausbildung}\n");
            String[] testEntry = { "3/2012 - heute", "Studium der Froschologie",
                    "Joghurt Uni Mainz", "vier", "fünf", "Note 1" };
            rafile.writeBytes(convertUmlaut(createCVEntry(testEntry)));
            
            rafile.writeBytes("\n\\section{Sprachen}\n");
            ArrayList<String[]> ls = getLanguageSkills();
            for (String[] langSkill : ls){
                rafile.writeBytes(convertUmlaut(
                        createCVLine(langSkill[0], langSkill[1])));
            }
            
            
            rafile.writeBytes("\n\\end{document}\n");
        } catch (Exception e) {
            try {
                rafile.writeBytes(e.getMessage());
            } catch (Exception sub_e) {
                System.err.println("All hail lord java");
            }
            ;
        }
    }

    /**
     * enum with common language skills.
     * 
     * @author Michael Mardaus
     */
    enum LanguageKnowledge {
        MOTHER("Muttersprache"), 
        FLUENT("fließend in Wort und Schrift"), 
        BASIC("Grundkenntnisse");

        /**
         * @param text
         */
        private LanguageKnowledge(final String text) {
            this.text = text;
        }

        private final String text;

        @Override
        public String toString() {
            return text;
        }
        
        public String getKnowledge() {
            return text;
        }
    };
    
}

//FIXME --------------------------- new class ---------------------------------

/**
 * Exception if a name is not given.
 * 
 * @author Michael Mardaus
 */
class MissingNameException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor with Message.
     * 
     * @param message
     *            the error message
     */
    public MissingNameException(final String message) {
        super(message);
    }
}

/**
 * Exception if a phonenumber is not valid.
 * 
 * @author Michael Mardaus
 */
class InvalidMobileNumberException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor with Message.
     * 
     * @param message
     *            the error message
     */
    public InvalidMobileNumberException(final String message) {
        super(message);
    }
}

/**
 * Exception if a email is not valid.
 * 
 * @author Michael Mardaus
 */
class InvalidEmailException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor with Message.
     * 
     * @param message
     *            the error message
     */
    public InvalidEmailException(final String message) {
        super(message);
    }
}

/**
 * Exception if a cv line is not valid.
 * 
 * @author Michael Mardaus
 */
class InvalidCVLineException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor with Message.
     * 
     * @param message
     *            the error message
     */
    public InvalidCVLineException(final String message) {
        super(message);
    }
}

/**
 * Exception if a cv entry is not valid.
 * 
 * @author Michael Mardaus
 */
class InvalidCVEntryException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor with Message.
     * 
     * @param message
     *            the error message
     */
    public InvalidCVEntryException(final String message) {
        super(message);
    }
}

/**
 * Exception for when file cannot be found or is not a .tex file.
 */

class InvalidFileException extends Exception {

    /**
     * Constructor with message. Calls super constructor, nothing else.
     * 
     * @param message
     *            the error message
     */
    public InvalidFileException(final String message) {
        super(message);
    }

}



//FIXME -------------------- new class ----------------------------------------


class CVTheme {
    /**
     * the cvmodern color.
     */
    private Color color;
    /**
     * the cvmodern style.
     */
    private Style style;

    /**
     * default constructor.
     */
    public CVTheme() {
        this.color = Color.BLUE;
        this.style = Style.CLASSIC;
    }

    /**
     * constructor.
     * 
     * @param color
     *            the color
     * @param style
     *            the style
     */
    public CVTheme(Color color, Style style) {
        this.color = color;
        this.style = style;
    }

    /**
     * enum with cvmodern colors.
     * 
     * @author Michael Mardaus
     */
    enum Color {
        BLACK, BLUE, GREEN, GREY, ORANGE, PURPLE, RED;

        @Override
        public String toString() {
            // all lowercase for LaTeX
            String s = super.toString();
            return s.toLowerCase();
        }
    };

    /**
     * enum with cvmodern styles.
     * 
     * @author Michael Mardaus
     */
    enum Style {
        CASUAL, CLASSIC, EMPTY, OLDSTYLE, BANKING;

        @Override
        public String toString() {
            // all lowercase for LaTeX
            String s = super.toString();
            return s.toLowerCase();
        }
    };

    /**
     * @return the color
     */
    public final Color getColor() {
        return color;
    }

    /**
     * @param color
     *            the color to set
     */
    public final void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the style
     */
    public final Style getStyle() {
        return style;
    }

    /**
     * @param style
     *            the style to set
     */
    public final void setStyle(Style style) {
        this.style = style;
    }
}
