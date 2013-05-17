import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CVGui extends JFrame {

	/**
	 * default serial number
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * fixed title
	 */
	private final static String TITLE = "Curriculum Vitae";

	/**
	 * fixed height
	 */
	private final static int HEIGHT = 480;

	/**
	 * fixed width
	 */
	private final static int WIDTH = 640;

	/**
	 * text on save button
	 */
	private final static String SAVE_BUTTON_TEXT = "Save";

	/**
	 * text on load button
	 */
	private final static String LOAD_BUTTON_TEXT = "Load";

	/**
	 * text on create button
	 */
	private final static String CREATE_BUTTON_TEXT = "Create";

	/**
	 * title of contact details tab
	 */
	private final static String CONTACT_TITLE = "Contact Details";

	/**
	 * width of contact pane text fields
	 */
	private final static int CONTACT_TEXT_WIDTH = 23;

	/**
	 * number of rows of addresses
	 */
	private final static int CONTACT_ADDRESS_ROWS = 3;

	/**
	 * content of first name text field
	 */
	private final static String CONTACT_FIRST_NAME_TEXTFIELD = "Enter your first name here";

	/**
	 * content of last name text field
	 */
	private final static String CONTACT_LAST_NAME_TEXTFIELD = "Enter your last name here";

	/**
	 * title of contact details tab
	 */
	private final static String CONTACT_ADDRESS_TEXTFIELD = "Enter your address here";

	/**
	 * title of contact details tab
	 */
	private final static String CONTACT_EMAIL_TEXTFIELD = "Enter your e-mail here";

	/**
	 * title of contact details tab
	 */
	private final static String CONTACT_PHONE_TEXTFIELD = "Enter your phone number here";

	/**
	 * title of the preferences tab
	 */
	private final static String PREFS_TITLE = "Preferences";

	/**
	 * title of the colors' panel
	 */
	private final static String PREFS_COLOR_TITLE = "Colors";

	/**
	 * title of the styles' panel
	 */
	private final static String PREFS_STYLE_TITLE = "Styles";

	/**
	 * title of the content tab
	 */
	private final static String CONTENT_TITLE = "Content";

	/**
	 * default value of section name text field
	 */
	private final static String CONTENT_SECTION_NAME_TEXTFIELD = "Enter section name here";

	/**
	 * default value of section name text field
	 */
	private final static String CONTENT_ADD_SECTION_BUTTON = "Add Section";

	/**
	 * internally, cv saves the data from input
	 */
	private CurriculumVitae cv;

	/**
	 * main panel, as requested
	 */
	private JPanel mainPanel;

	/**
	 * Constructor that makes a CVGui object. Adds all the bells and whistles.
	 */
	CVGui() {
		// setting variables
		this.setTitle(CVGui.TITLE);
		this.setSize(CVGui.WIDTH, CVGui.HEIGHT);
		this.setMinimumSize(new Dimension(CVGui.WIDTH, CVGui.HEIGHT));
		// close on ESC press
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.center();

		// initialize "back-end"
		this.cv = new CurriculumVitae();

		this.mainPanel = makeMainPanel();
		this.setContentPane(this.mainPanel);
	}

	/**
	 * Centers this instance of CVGui.
	 */
	public void center() {
		center(this);
	}

	/**
	 * Centers a JFrame into the middle of the screen.
	 * 
	 * @param frame
	 *            the frame to be centered.
	 */
	private static void center(JFrame frame) {
		// get the size of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// determine the new location of the window
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;

		// move the frame
		frame.setLocation(x, y);
	}

	/**
	 * Makes the main panel for the CVGui. Calls helper functions to do so.
	 * 
	 * @return the actual main panel.
	 */
	private JPanel makeMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.red));

		// making a panel for save, load and create buttons
		JPanel lsc = new JPanel();
		lsc.setBorder(BorderFactory.createLineBorder(Color.green));

		// making buttons for saving, loading and creating cvs
		JButton save = new JButton(CVGui.SAVE_BUTTON_TEXT);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO do save
			}
		});
		JButton load = new JButton(CVGui.LOAD_BUTTON_TEXT);
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO do load
			}
		});
		JButton create = new JButton(CVGui.CREATE_BUTTON_TEXT);
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO do create
			}
		});
		// adding buttons to button panel
		lsc.add(load);
		lsc.add(save);
		lsc.add(create);

		// setting correct position of button panel
		GridBagConstraints lscConstraints = new GridBagConstraints(0, // gridx
				// ("at"
				// which
				// row)
				0, // gridy
				1, // gridwidth (dimensions of grid to be applied)
				1, // gridheight
				1.0, // weightx (how much extra space)
				1.0, // weighty
				GridBagConstraints.LAST_LINE_END, // anchor (if too small, where
				// to)
				GridBagConstraints.NONE, // fill (in which direction to fill if
				// too small)
				new Insets(5, 5, 5, 5), // insets (padding on the outside)
				0, // ipadx (padding on the inside)
				0); // ipady
		// adding the finished button panel to the main panel
		mainPanel.add(lsc, lscConstraints);
		// adding the tab pane
		addJTPane(mainPanel);
		return mainPanel;
	}

	/**
	 * Helper function that adds a correctly initialized tab pane to a frame. To
	 * be used in conjunction with the main frame of this class.
	 * 
	 * @param mainPanel
	 *            the main panel that needs to have a tabs pane added.
	 */
	private void addJTPane(JPanel mainPanel) {
		JTabbedPane jtp = new JTabbedPane();
		jtp.setBorder(BorderFactory.createLineBorder(Color.blue));
		// setting correct position of tab pane
		GridBagConstraints jtbConstraints = new GridBagConstraints(0, // gridx
				// ("at"
				// which
				// row)
				0, // gridy
				1, // gridwidth (dimensions of grid to be applied)
				1, // gridheight
				1.0, // weightx (how much extra space)
				1.0, // weighty
				GridBagConstraints.CENTER, // anchor (if too small, where
				// to)
				GridBagConstraints.BOTH, // fill (in which direction to fill if
				// too small)
				new Insets(5, 5, 45, 5), // insets (padding on the outside) top,
				// left, bottom, right
				0, // ipadx (padding on the inside)
				0); // ipady
		// adding content tabs to tabs pane
		// contact details tab
		addContactDetailsTab(jtp);
		// preferences tab
		addPrefsTab(jtp);
		// content tab
		addContentTab(jtp);

		// adding the finished tab pane to the main panel
		mainPanel.add(jtp, jtbConstraints);
	}

	/**
	 * Helper function used to add the contact details tab to the tab pane. To
	 * be used in conjunction with the tab pane of this class.
	 * 
	 * @param jtp
	 *            the tab pane which will have contact details tab added.
	 */
	private void addContactDetailsTab(JTabbedPane jtp) {
		// making the panel that's used to display the contact details tab
		JPanel contactDetails = new JPanel();
		contactDetails.setBorder(BorderFactory.createLineBorder(Color.yellow));
		contactDetails.setLayout(new GridBagLayout());

		// making several text fields that need to be on the details tab
		// first up: first name
		JTextField jtfFirstName = new JTextField(
				CVGui.CONTACT_FIRST_NAME_TEXTFIELD, CVGui.CONTACT_TEXT_WIDTH);
		jtfFirstName.addFocusListener(new FieldCleanerFocusListener(
				CVGui.CONTACT_FIRST_NAME_TEXTFIELD));
		// next: last name text field
		JTextField jtfLastName = new JTextField(
				CVGui.CONTACT_LAST_NAME_TEXTFIELD, CVGui.CONTACT_TEXT_WIDTH);
		jtfLastName.addFocusListener(new FieldCleanerFocusListener(
				CVGui.CONTACT_LAST_NAME_TEXTFIELD));
		// address text field
		JTextArea jtaAddress = new JTextArea(CVGui.CONTACT_ADDRESS_TEXTFIELD,
				CVGui.CONTACT_ADDRESS_ROWS, CVGui.CONTACT_TEXT_WIDTH);
		jtaAddress.setBorder(BorderFactory.createLineBorder(Color.gray));
		jtaAddress.addFocusListener(new AreaCleanerFocusListener(
				CVGui.CONTACT_ADDRESS_TEXTFIELD));
		// email text field
		JTextField jtfEmail = new JTextField(CVGui.CONTACT_EMAIL_TEXTFIELD,
				CVGui.CONTACT_TEXT_WIDTH);
		jtfEmail.addFocusListener(new FieldCleanerFocusListener(
				CVGui.CONTACT_EMAIL_TEXTFIELD));
		// phone number text field
		JTextField jtfPhone = new JTextField(CVGui.CONTACT_PHONE_TEXTFIELD,
				CVGui.CONTACT_TEXT_WIDTH);
		jtfPhone.addFocusListener(new FieldCleanerFocusListener(
				CVGui.CONTACT_PHONE_TEXTFIELD));

		// making a little box where all the text fields shall gather
		JPanel boxOfTexts = new JPanel();
		boxOfTexts.setLayout(new BoxLayout(boxOfTexts, BoxLayout.Y_AXIS));
		boxOfTexts.add(jtfFirstName);
		boxOfTexts.add(jtfLastName);
		boxOfTexts.add(jtaAddress);
		boxOfTexts.add(jtfEmail);
		boxOfTexts.add(jtfPhone);

		// setting correct position of box
		GridBagConstraints boxConstraints = new GridBagConstraints(0, // gridx
				// ("at"
				// which
				// row)
				0, // gridy
				2, // gridwidth (dimensions of grid to be applied)
				2, // gridheight
				1.0, // weightx (how much extra space)
				1.0, // weighty
				GridBagConstraints.FIRST_LINE_START, // anchor (if too small,
				// where
				// to)
				GridBagConstraints.NONE, // fill (in which direction to fill if
				// too small)
				new Insets(5, 5, 5, 5), // insets (padding on the outside) top,
				// left, bottom, right
				0, // ipadx (padding on the inside)
				0); // ipady

		// adding the box to the tab
		contactDetails.add(boxOfTexts, boxConstraints);

		// making picture button
		JButton addPic = new JButton();
		addPic.setPreferredSize(new Dimension(137, 177));
		addPic.addActionListener(new PictureButtonListener());

		// setting correct position of picture button
		GridBagConstraints addPicConstraints = new GridBagConstraints(2, // gridx
				// ("at"
				// which
				// row)
				1, // gridy
				1, // gridwidth (dimensions of grid to be applied)
				1, // gridheight
				1.0, // weightx (how much extra space)
				1.0, // weighty
				GridBagConstraints.CENTER, // anchor (if too small, where
				// to)
				GridBagConstraints.NONE, // fill (in which direction to fill if
				// too small)
				new Insets(5, 5, 5, 5), // insets (padding on the outside) top,
				// left, bottom, right
				0, // ipadx (padding on the inside)
				0); // ipady

		// adding the finished button to the tab
		contactDetails.add(addPic, addPicConstraints);

		// adding the finished contact details tab to the tab pane
		jtp.addTab(CVGui.CONTACT_TITLE, contactDetails);
	}

	/**
	 * Helper function adding the preferences tab to the tab pane.
	 * 
	 * @param jtp
	 *            the tab pane to which to add this tab
	 */
	private void addPrefsTab(JTabbedPane jtp) {
		// making preferences panel
		JPanel cvPreferences = new JPanel();
		cvPreferences.setBorder(BorderFactory.createLineBorder(Color.orange));
		// don't set layout for this, because flowLayout is just perfect anyways

		// making a panel for the colors' radio buttons
		JPanel colors = new JPanel();
		colors.setBorder(BorderFactory
				.createTitledBorder(CVGui.PREFS_COLOR_TITLE));
		colors.setLayout(new BoxLayout(colors, BoxLayout.Y_AXIS));
		for (CVTheme.ThemeColor c : CVTheme.ThemeColor.values()) {
			JRadioButton radio = new JRadioButton();
			radio.setText(c.toString());
			Color bg = c.toColor();
			radio.setBackground(bg);
			colors.add(radio);
		}
		// adding the colors panel to the preferences tab
		cvPreferences.add(colors);

		JPanel styles = new JPanel();
		styles.setBorder(BorderFactory
				.createTitledBorder(CVGui.PREFS_STYLE_TITLE));
		styles.setLayout(new BoxLayout(styles, BoxLayout.Y_AXIS));
		for (CVTheme.ThemeStyle s : CVTheme.ThemeStyle.values()) {
			JRadioButton radio = new JRadioButton();
			radio.setText(s.toString());
			styles.add(radio);
		}
		// adding the styles panel to the preferences tab
		cvPreferences.add(styles);

		// adding the finished preferences tab to the tab pane
		jtp.addTab(CVGui.PREFS_TITLE, cvPreferences);
	}

	private void addContentTab(JTabbedPane jtp) {
		// making content panel
		JPanel cvContent = new JPanel();
		cvContent.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		cvContent.setLayout(new GridBagLayout());

		// making panel with box layout to encapsulate adding and choosing
		// sections
		JPanel chooseAddSections = new JPanel();
		chooseAddSections.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		chooseAddSections.setLayout(new BoxLayout(chooseAddSections,
				BoxLayout.Y_AXIS));

		// making combo box to display section names
		JComboBox comboSections = new JComboBox();
		// making text fields to enter section names
		JTextField sectionName = new JTextField();
		sectionName.setText(CVGui.CONTENT_SECTION_NAME_TEXTFIELD);
		sectionName.addFocusListener(new FieldCleanerFocusListener(
				CONTENT_SECTION_NAME_TEXTFIELD));
		// making button for adding sections
		JButton addSection = new JButton();
		addSection.setText(CVGui.CONTENT_ADD_SECTION_BUTTON);
		addSection.addActionListener(new SectionButtonListener(sectionName,
				comboSections));

		// adding elements to their panel
		chooseAddSections.add(sectionName);
		chooseAddSections.add(addSection);
		chooseAddSections.add(comboSections);

		// setting container panel's position
		GridBagConstraints cASConstraints = new GridBagConstraints(0, // gridx
				// ("at"
				// which
				// row)
				0, // gridy
				1, // gridwidth (dimensions of grid to be applied)
				1, // gridheight
				1.0, // weightx (how much extra space)
				1.0, // weighty
				GridBagConstraints.FIRST_LINE_START, // anchor (if too small,
				// where
				// to)
				GridBagConstraints.NONE, // fill (in which direction to fill if
				// too small)
				new Insets(5, 5, 5, 5), // insets (padding on the outside) top,
				// left, bottom, right
				0, // ipadx (padding on the inside)
				0); // ipady
		// adding this panel to tab
		cvContent.add(chooseAddSections, cASConstraints);
		
		// making another container panel for entry vs line
		JPanel entryLine = new JPanel();
		entryLine.setLayout(new BoxLayout(entryLine, BoxLayout.Y_AXIS));
		JTextField line1 = new JTextField();
		JTextField line2 = new JTextField();
		JTextField line3 = new JTextField();
		JTextField line4 = new JTextField();
		JTextField line5 = new JTextField();
		JTextField line6 = new JTextField();
		entryLine.add(line1);
		entryLine.add(line2);
		entryLine.add(line3);
		entryLine.add(line4);
		entryLine.add(line5);
		entryLine.add(line6);
		
		JRadioButton cvEntry = new JRadioButton();
		cvEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});

		// adding the finished content tab to the tab pane
		jtp.addTab(CVGui.CONTENT_TITLE, cvContent);
	}

	class FieldCleanerFocusListener implements FocusListener {

		String content;

		FieldCleanerFocusListener(String content) {
			this.content = content;
		}

		public void focusGained(FocusEvent e) {
			JTextField f = (JTextField) e.getComponent();
			if (f.getText().equals(this.content))
				f.setText("");
		}

		public void focusLost(FocusEvent e) {
			JTextField f = (JTextField) e.getComponent();
			if (f.getText().equals(""))
				f.setText(this.content);
		}
	}

	class AreaCleanerFocusListener implements FocusListener {

		String content;

		AreaCleanerFocusListener(String content) {
			this.content = content;
		}

		public void focusGained(FocusEvent e) {
			JTextArea f = (JTextArea) e.getComponent();
			if (f.getText().equals(this.content))
				f.setText("");
		}

		public void focusLost(FocusEvent e) {
			JTextArea f = (JTextArea) e.getComponent();
			if (f.getText().equals(""))
				f.setText(this.content);
		}
	}

	class PictureButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(button);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();
				ImageIcon icon = new ImageIcon(file.getAbsolutePath());
				Image image = icon.getImage().getScaledInstance(137, 177,
						Image.SCALE_SMOOTH);
				icon.setImage(image);
				button.setIcon(icon);
				cv.setPicture(file.getAbsolutePath());
			}
		}
	}

	class SectionButtonListener implements ActionListener {

		JTextField jtf;
		JComboBox jcb;

		SectionButtonListener(JTextField jtf, JComboBox jcb) {
			this.jtf = jtf;
			this.jcb = jcb;
		}

		public void actionPerformed(ActionEvent e) {
			if (!(this.jtf.getText()
					.equals(CVGui.CONTENT_SECTION_NAME_TEXTFIELD))) {
				Section section = new Section(this.jtf.getText());
				this.jcb.addItem(section);
				cv.addSection(this.jtf.getText());
			}
		}
	}
}
