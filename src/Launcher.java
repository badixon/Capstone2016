import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Launcher extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	
	// Left Panel
	JPanel leftPanel;
	JTextArea EEG1;
	JTextArea EEG2;
	
	// Right Panel
	JPanel rightPanel;
	private JTabbedPane tabbedPanels;
	
	final int WIDTH = 900;		// Changed these to fit the GUI to my screen - appropriate ratio is 1.5 width/height
	final int HEIGHT = 600;
	
	public Launcher() {
        frame = new JFrame();
		tabbedPanels = initGUI();
        
        frame.setTitle("Display Values");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(tabbedPanels);
		frame.setVisible(true);
	}
		
	public JTabbedPane initGUI() {		// Building the GUI
	
		JTabbedPane tabbedPanel = new JTabbedPane();
		tabbedPanel.setTabPlacement(JTabbedPane.BOTTOM);
		
		JPanel mainPanel = new JPanel();
		
		mainPanel = initMainPanel(mainPanel);		
		tabbedPanel.add("Main", mainPanel);
		
		for( int i=0; i<=8; i++) {							// Creates 8 other tabs for each region
			
			if(i == 0) {
				JPanel panel = new Tabs(i);
				tabbedPanel.add("EEG", panel);
			}
			else {
				JPanel panel = new Tabs(i);
				tabbedPanel.add("Region " + i, panel);
			}
		}
		
		return tabbedPanel; 
	} 
	
	public JPanel initMainPanel(JPanel mainPanel) {			// Builds the main Panel
	
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
				
		leftPanel = new JPanel(new GridLayout(1,1));
		leftPanel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
		leftPanel.setBorder(BorderFactory.createTitledBorder(""));
				
		BrainPanel test = new BrainPanel();
		leftPanel.add(test);
		
		rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));	
		rightPanel.setBorder(BorderFactory.createTitledBorder(""));
		JLabel right = new JLabel("right testing");	
		rightPanel.add(right);
		
		mainPanel.add(rightPanel);
		mainPanel.add(leftPanel);
		
		return mainPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("this is sort of working?");
	}
	
}
