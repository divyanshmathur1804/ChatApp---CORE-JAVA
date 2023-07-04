package LoginSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import LoginSystem.Label.ChatLabel;
import LoginSystem.utils.ProjectConstants;

public class FrameImage extends JPanel implements ProjectConstants {
	BufferedImage ChatImage;
	private int x = 70;
	private int y = 50;
	public FrameImage() {
		LoadChatImage();
		setFocusable(true);
		setVisible(true);
		setBounds(0,PanelY , 500, 500);
		setBackground(Color.white);
		setLayout(null);
		ChatLabel cLabel = new ChatLabel();
		add(cLabel);
	
		
	}
	private void LoadChatImage() {
		
		try {
			ChatImage = ImageIO.read(FrameImage.class.getResource("Messenger.png"));
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,"OOPS Something went wrong" );
			System.out.println(ex);
			System.exit(0);
		}
		
	}
	@Override
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		PrintImage(pen);
		
	}
	public void PrintImage(Graphics pen) {
		pen.drawImage(ChatImage,x,y,400,230,null);
	}

}
