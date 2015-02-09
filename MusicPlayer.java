import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MusicPlayer extends JFrame{

	JButton add, edit, delete, confirm, cancel;
	JTextField name, artist, album, year;
	JList songList;
	
	public MusicPlayer(String title){
		super(title);
		
		// use FlowLayout
		setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		

		// Set up the Panels
		JPanel listPanel = new JPanel(new GridLayout(0,1));
		JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
		add = new JButton("Add");
		buttonPanel.add(add);
		edit = new JButton("Edit");
		buttonPanel.add(edit);
		delete = new JButton("Delete");
		buttonPanel.add(delete);
		confirm = new JButton("Confirm");
		buttonPanel.add(confirm);
		cancel = new JButton("Cancel");
		buttonPanel.add(cancel);
		
		JPanel textPanel = new JPanel(new GridLayout(0, 1));
		
		add(listPanel);
		add(buttonPanel);
		add(textPanel);
		
	}
	
	public static void main(String[] args){
		MusicPlayer mp = new MusicPlayer("Our Library");
		mp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mp.setSize(300,400);
		mp.setLocationRelativeTo(null);
		mp.setVisible(true);
		
	}
}
