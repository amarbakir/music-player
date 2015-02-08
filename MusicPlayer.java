import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;


public class MusicPlayer extends JFrame{

	JButton add, edit, delete, confirm, cancel;
	JTextField name, artist, album, year;
	JList songList;
	
	public MusicPlayer(){
		
		
	}
	
	public static void main(String[] args){
		MusicPlayer mp = new MusicPlayer();
		mp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mp.setSize(300,400);
		mp.setLocationRelativeTo(null);
		mp.setVisible(true);
		
	}
}
