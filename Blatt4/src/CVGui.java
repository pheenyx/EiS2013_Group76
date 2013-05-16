import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class CVGui extends JFrame {
	
	/**
	 * default serial number
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * fixed title
	 */
	private final String TITLE = "Curriculum Vitae";
	
	/**
	 * fixed height
	 */
	private final int HEIGHT = 640;
	
	/**
	 * fixed width
	 */
	private final int WIDTH = 480;
	
	/**
	 * internally, cv saves the data from input
	 */
	private CurriculumVitae cv;
	
	/**
	 * main panel, as requested
	 */
	private JPanel mainPanel;
	
	/**
	 * panel for buttons
	 */
	private JPanel lsc;
	
	/**
	 * buttons for loading, saving and creating cvs
	 */
	private JButton load, save, create;
	
	CVGui() {
		// setting variables
		this.setTitle(this.TITLE);
		this.setSize(this.WIDTH, this.HEIGHT);
		this.setResizable(false);
		this.setLayout(null);
		
		// making the main panel
		this.mainPanel = new JPanel();
		this.setContentPane(this.mainPanel);
		this.mainPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		this.mainPanel.setLayout(null);
		
		// making a panel for save, load and create buttons
		this.lsc = new JPanel();
		this.lsc.setSize(200, 50);
		this.lsc.setBorder(BorderFactory.createLineBorder(Color.green));
		
		// making buttons for saving, loading and creating cvs
		this.save = new JButton("Save");
		this.save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO do save
			}
		});
		this.load = new JButton("Load");
		this.load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO do load
			}
		});
		this.create = new JButton("Create");
		this.create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO do create
			}
		});
		
		// adding buttons to button panel
		this.lsc.add("load", this.load);
		this.lsc.add("save", this.save);
		this.lsc.add("create", this.create);
		
		// setting correct position of button panel
		int lsc_origin_x = this.mainPanel.getWidth() - this.lsc.getWidth();
		int lsc_origin_y = this.mainPanel.getHeight() - this.lsc.getHeight();
		Point lsc_origin = new Point(lsc_origin_x, lsc_origin_y);
		this.lsc.setLocation(lsc_origin);
		
		// adding the finished button panel to the main panel
		this.mainPanel.add("lsc", this.lsc);
	}

}
