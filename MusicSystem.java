import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javafx.scene.*;
//import javafx.scene.media.*;
import java.io.*;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;

class Files extends JFrame implements ActionListener
{
	JComboBox cmb_list;
	JButton b_play;
	JLabel lbl_Logo,lbl_Track;

	public Files()
	{
		cmb_list = new JComboBox();
		b_play = new JButton("Play");
		lbl_Logo = new JLabel(new ImageIcon("Logo.png"));
		lbl_Track = new JLabel(new ImageIcon("abc.gif"));

		b_play.addActionListener(this);

		cmb_list.setToolTipText("Contains the media files");
		b_play.setToolTipText("Press to play the Selected tune");

		cmb_list.setBounds(10,310,350,50);
		b_play.setBounds(380,310,100,50);
		lbl_Logo.setBounds(0,0,500,500);
		lbl_Track.setBounds(0,-50,500,500);

		add(cmb_list);
		add(b_play);
		//add(lbl_Logo);
		add(lbl_Track);

		setLayout(null);
		setVisible(true);
		setSize(500,420);
		setResizable(false);
		setTitle("Protron Media Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if ((new File("C:/Protron")).isDirectory()) 
		{
			File f = new File("C:/Protron");
			File s[] = f.listFiles();

			if (f.list().length == 0) 
			{
				JOptionPane.showMessageDialog(null,"Please Fill the Protron Folder in C drive with your Moving Tracks! \nand Restart the Application!");	
				this.dispose();
			}
			else
			{
				for(File str : s)
				{
					if(str.isFile())
					{
						cmb_list.addItem(str.getName());
					}
				}
			}
		}
		else
		{
			(new File("C:/Protron")).mkdir();
			JOptionPane.showMessageDialog(null,"Folder: Protron is Created for you in C Directory \n Copy your Songs There and\n ENJOY!!");
			this.dispose();
		}
		//cmb_list.setMaximumRowCount(10);
	}
/////////////////////////////////////////////////////////////////////////////////
	public void actionPerformed(ActionEvent p)
	{
		if ((new File("C:/Protron")).isDirectory()) 
		{
			String str = (String)(cmb_list.getItemAt(cmb_list.getSelectedIndex()));
			try
			{
				Desktop dk=Desktop.getDesktop();
				dk.open(new File("C:/Protron/"+str));
			} 
			catch (Exception e)
			{
			}
		}
		else
		{
			(new File("C:/Protron")).mkdir();
			JOptionPane.showMessageDialog(null,"Folder: Protron is Created for you in C Directory \n Copy your Songs There and\n ENJOY!!");
		}
	}
}
class MusicSystem
{
	public static void main(String[] args) 
	{
		Files f = new Files();
	}
}