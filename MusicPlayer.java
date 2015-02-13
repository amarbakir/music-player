import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class MusicPlayer extends JFrame{

	public static int songCount = 0;
	JButton add, edit, delete, confirm, clear;
	JLabel nLabel, artLabel, albLabel, yLabel;
	JTextField name, artist, album, year;
	JLabel userMessage;
	JList<String> songList;
	DefaultListModel<String> model;
	ArrayList<String> songDB = new ArrayList<String>();
	
	public MusicPlayer(String title){
		super(title);
		
		String delims = "|";
		
		// use FlowLayout
		setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		

		// Set up the Panels
		JPanel listPanel = new JPanel(new GridLayout(0,1));
		JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 0, 15 ));
		JPanel textPanel = new JPanel(new GridLayout(0, 1, 0, 0));
		
		//AddListbox
		model = new DefaultListModel<String>();
		songList = new JList<String>();
		songList.setModel(model);
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
		confirm.setEnabled(false);
		buttonPanel.add(confirm);
		clear = new JButton("Clear");
		buttonPanel.add(clear);
		
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
		
		//Add JLabel
	    
		userMessage = new JLabel();
		listPanel.add(userMessage);
		userMessage.setText("Here is the label");
		userMessage.setPreferredSize(new Dimension (500, 50));
		userMessage.setMaximumSize(new Dimension (500, 50));
		userMessage.setMinimumSize(new Dimension (500, 50));
		
		//add the panels
		add(listPanel);
		add(textPanel);
		add(buttonPanel);
		
		name.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	        	name.setText("");
	        }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
	    });
		
		artist.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	        	artist.setText("");
	        }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
	    });
		
		album.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	        	album.setText("");
	        }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
	    });
		
		year.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	        	year.setText("");
	        }

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    });
		
		songList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	String[] tokens = songDB.get(songList.getSelectedIndex()).split(delims);
                	String album;
                	String year;
                	if (tokens[2].isEmpty()) {
                		album = "N/A";
                	} else {
                		album = tokens[2];
                	}
                	if (tokens[3].isEmpty()) {
                		year = "N/A";
                	} else {
                		year = tokens[3];
                	}
                	userMessage.setText("Artist: " + tokens[1] + " Album: " + album + " Year: " + year);
                }
            }
        });

		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if (name.getText().trim().isEmpty() || artist.getText().trim().isEmpty()) {
					return;
				}
				sb.append(name.getText().trim() + "|");
				sb.append(artist.getText().trim() + "|");
				if (!album.getText().trim().isEmpty()) {
					sb.append(album.getText().trim() + "|");
				}
				if (!year.getText().trim().isEmpty()) {
					sb.append(year.getText().trim());
				}
				
				String[] tokens = sb.toString().split(delims);
				String[] currentEntry;
				String[] temp;
				if (songDB.size() == 0 || songCount == 0) {
					songDB.add(sb.toString());
					name.setText(null);
					artist.setText(null);
					album.setText(null);
					year.setText(null);
					model = new DefaultListModel<String>();
					songList.setModel(model);
			        songList.setSelectedIndex(0);
			        temp = songDB.toArray(new String[songDB.size()]);
			        songList.setListData(temp);
			        songCount++;
			        return;
				}
				int i = 0;
				for (i = 0; i < songDB.size(); i++) {
					currentEntry = songDB.get(i).split(delims);
					if (tokens[0].equalsIgnoreCase(currentEntry[0]) && tokens[1].equalsIgnoreCase(currentEntry[1])) {
						return;
					} else {
						if(tokens[0].compareToIgnoreCase(currentEntry[0]) > 0) {
							continue;
						} else if (tokens[0].equalsIgnoreCase(currentEntry[0]) && tokens[1].compareToIgnoreCase(currentEntry[1]) > 0) {
							continue;
						} else {
							songDB.add(i, sb.toString());
							model = new DefaultListModel<String>();
							for(int j = 0; j < songDB.size(); j++) {
						        model.addElement(songDB.get(j));
						    }
							songList.setModel(model);
					        songList.setSelectedIndex(i);
					        temp = songDB.toArray(new String[songDB.size()]);
					        songList.setListData(temp);
					        songCount++;
					        name.setText(null);
							artist.setText(null);
							album.setText(null);
							year.setText(null);
							return;
						}
					}
				}
				if (i == songDB.size()) {
					songDB.add(sb.toString());
					name.setText(null);
					artist.setText(null);
					album.setText(null);
					year.setText(null);
					model = new DefaultListModel<String>();
					songList.setModel(model);
			        songList.setSelectedIndex(songDB.size() - 1);
			        temp = songDB.toArray(new String[songDB.size()]);
			        songList.setListData(temp);
			        songCount++;
			        return;
				}
			}
		});
		
		edit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				confirm.setEnabled(true);
			}
		});
		
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String[] temp;
				songDB.remove(songList.getSelectedIndex());
				model = new DefaultListModel<String>();
				songList.setModel(model);
		        songList.setSelectedIndex(0);
		        temp = songDB.toArray(new String[songDB.size()]);
		        songList.setListData(temp);
		        songCount--;
			}
		});
		
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				name.setText(null);
				artist.setText(null);
				album.setText(null);
				year.setText(null);
				confirm.setEnabled(false);
			}
		});
	}
	
	public static void main(String[] args){
		MusicPlayer mp = new MusicPlayer("Our Library");
		mp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mp.setSize(750,300);
		mp.setResizable(false);
		mp.setLocationRelativeTo(null);
		mp.setVisible(true);
		
	}
}
