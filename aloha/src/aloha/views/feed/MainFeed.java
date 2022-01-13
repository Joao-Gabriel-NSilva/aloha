package aloha.views.feed;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import aloha.util.ViewUtil;

public class MainFeed {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFeed window = new MainFeed();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFeed() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 840);
		frame.getContentPane().setBackground(ViewUtil.COR_ATUAL_FUNDO);
		frame.setResizable(false);
		frame.setLocation(700, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(31, 103, 390, 381);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPublicadoPor = new JLabel("João");
		lblPublicadoPor.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		lblPublicadoPor.setBounds(64, 11, 152, 14);
		panel.add(lblPublicadoPor);
		
		TextArea textArea = new TextArea("", 10, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		textArea.setBounds(10, 58, 370, 224);
		textArea.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		textArea.setFocusable(false);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 328, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(190, 328, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(291, 328, 89, 23);
		panel.add(btnNewButton_2);
	}
}
