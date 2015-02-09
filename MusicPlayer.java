import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


public class MusicPlayer extends JFrame{

	JButton add, edit, delete, confirm, cancel;
	JLabel nLabel, artLabel, albLabel, yLabel;
	JTextField name, artist, album, year;
	JList songList;
	
	public MusicPlayer(String title){
		super(title);
		
		// use FlowLayout
		setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		

		// Set up the Panels
		JPanel listPanel = new JPanel(new GridLayout(0,1));
		JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 0, 15 ));
		JPanel textPanel = new JPanel(new GridLayout(0, 1, 0, 0));
		
		//AddListbox
		songList = new JList();
		songList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		songList.setSelectedIndex(0);
		//songList.addListSelectionListener(this);
		songList.setVisibleRowCount(15);
	    JScrollPane listScrollPane = new JScrollPane(songList);
	    listPanel.add(listScrollPane);
	    listPanel.setPreferredSize(new Dimension (500, 200));
	    
		//Add Buttons
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
		
		//Add TextFields
		name = new JTextField("Name", 10);
		nLabel = new JLabel("Name");
		textPanel.add(nLabel);		
		textPanel.add(name);
		artLabel = new JLabel("Artist");
		artist = new JTextField("Artist", 10);
		textPanel.add(artLabel);
		textPanel.add(artist);
		albLabel = new JLabel("Album");
		album = new JTextField("Album", 10);
		textPanel.add(albLabel);
		textPanel.add(album);
		yLabel = new JLabel("Year");
		year = new JTextField("Year", 10);
		textPanel.add(yLabel);
		textPanel.add(year);
		
		
		//add the panels
		add(listPanel);
		add(textPanel);
		add(buttonPanel);
	}
	
	public void addActionPerformed(ActionEvent e) throws IOException {
		File songFile = new File("MusicPlayer.txt");
		if(!songFile.exists()) {
			songFile.createNewFile();
		} 
		FileOutputStream outFile = new FileOutputStream(songFile, false);
		StringBuilder sb = new StringBuilder();
		sb.append(name.getText() + "|");
		sb.append(artist.getText() + "|");
		sb.append(album.getText() + "|");
		sb.append(year.getText());
	}
	
	public void deleteActionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args){
		MusicPlayer mp = new MusicPlayer("Our Library");
		mp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mp.setSize(850,300);
		mp.setResizable(false);
		mp.setLocationRelativeTo(null);
		mp.setVisible(true);
		
	}
}
