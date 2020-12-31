package rubiks.screen;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import rubiks.driver.Driver;
import rubiks.gui.Display;

public class HomeScreen extends Screen {

	Button[] buttons = new Button[1];
	
	int width, height, buttonsX, buttonsY;
	String title = "Start";
	JButton play, settings, quit;
	
	
	
	public HomeScreen() {

		int width = 400;
		int height = 80;
		int buttonsX = Driver.width / 2 - (width / 2);
		int buttonsY = Driver.height / 2 - (height / 2) + Driver.height / 10;
		
		this.width = width;
		this.height = height;
		this.buttonsX = buttonsX;
		this.buttonsY = buttonsY;
		
//		buttons[0] = new Button(buttonsX, buttonsY, width, height, Color.orange, Color.BLACK, "PLAY", 40);
//		buttons[1] = new Button(buttonsX, buttonsY + height + 10, width, height, Color.orange, Color.BLACK, "Settings", 40);
//		buttons[2] = new Button(buttonsX, buttonsY + (2 * (height + 10)), width, height, Color.orange, Color.BLACK, "Quit", 40);

//		buttons[0].addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				buttons[0].setLabel("Button Clicked");
//			}
//		});

	}
	
	public void setScreen(Display display) {
		int panelWidth = 400;
		int panelHeight = 300;
		
		JPanel panel = new JPanel();
		panel.setBounds((Driver.width-panelWidth)/2,(Driver.height-panelHeight)-Driver.height/20,panelWidth,panelHeight);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		play = new JButton("Play");
		settings = new JButton("settings");
		quit = new JButton("quit");
		
		play.setBounds(0,0,panelWidth,panelHeight/3);
//		play.setPreferredSize(new Dimension(panelWidth,panelHeigtht/3));
		
		settings.setBounds(0,panelHeight/3 - 1,panelWidth,panelHeight/3);
//		settings.setPreferredSize(new Dimension(panelWidth,panelHeigtht/3));
		
		quit.setBounds(0,2*(panelHeight/3) - 2,panelWidth,panelHeight/3);
//		quit.setPreferredSize(new Dimension(panelWidth,panelHeigtht/3));
		
		play.setBackground(Color.orange);
		settings.setBackground(Color.orange);
		quit.setBackground(Color.orange);
		play.setBorder(new LineBorder(Color.BLACK));
		settings.setBorder(new LineBorder(Color.BLACK));
		quit.setBorder(new LineBorder(Color.BLACK));
		
		play.addActionListener(this);
		settings.addActionListener(this);
		quit.addActionListener(this);
		
		play.setText(title);
		
		panel.add(play);
		panel.add(settings);
		panel.add(quit);
//		
		display.getFrame().add(panel);
//		display.getFrame().setSize(400,400);
		display.getFrame().setLayout(null);
		display.getFrame().setVisible(true);
		display.getFrame().add(display.getCanves());
		display.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void removeScreen(Display display) {
		
	}
	
	@Override
	public void draw() {
		
		
		
	}

	public void setButtons(Button[] buttons) {
		this.buttons = buttons;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		arg0.getSource() == play ? removeScreen() : 
		
	}

}
