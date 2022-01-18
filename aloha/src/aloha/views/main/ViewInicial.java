package aloha.views.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import aloha.util.OutlineLabel;
import aloha.views.cadastro.InformeNome;

public class ViewInicial {

	private JFrame frame;
	public static JFrame FRAME_LOGIN;
	public static JFrame FRAME_CADASTRO;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInicial window = new ViewInicial();
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
	public ViewInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 840);
		frame.getContentPane().setBackground(new Color(105, 105, 105));
		frame.getContentPane().setLayout(null);
		frame.setLocation(700, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		// label aloha
		OutlineLabel labelAloha = new OutlineLabel("Aloha", JLabel.CENTER, 1);
		labelAloha.setBounds(113, 280, 217, 127);
		labelAloha.setHorizontalAlignment(SwingConstants.CENTER);
        labelAloha.setFont(new Font("Brush Script MT", Font.PLAIN, 101));
        //labelAloha.setOutlineColor(new Color(255, 20, 147));
        labelAloha.setForeground(Color.WHITE);
        frame.getContentPane().add(labelAloha);
        //
        
        // label login
        OutlineLabel labelLogin = new OutlineLabel("Já tem cadastro? Fazer login", JLabel.CENTER, 0);
        labelLogin.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		frame.setVisible(false);
        		if(FRAME_LOGIN == null) {
        			new ViewLogin(frame);
        		} else {
        			FRAME_LOGIN.setVisible(true);
        		}
        	}
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		labelLogin.setForeground(Color.BLUE);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		labelLogin.setForeground(Color.WHITE);
        	}
        });
        labelLogin.setBounds(40, 563, 364, 59);
        labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
        labelLogin.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
        labelLogin.setForeground(Color.WHITE);
        frame.getContentPane().add(labelLogin);
        //
        
        // label cadastro
        OutlineLabel labelCadastro = new OutlineLabel("Novo usuário? Fazer cadastro", JLabel.CENTER, 0);
        labelCadastro.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		frame.setVisible(false);
        		if(FRAME_CADASTRO == null) {
        			new InformeNome(frame);
        		} else {
        			FRAME_CADASTRO.setVisible(true);
        		}
        		
        	}
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		labelCadastro.setForeground(Color.BLUE);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		labelCadastro.setForeground(Color.WHITE);
        	}
        });
        labelCadastro.setBounds(40, 629, 364, 59);
        labelCadastro.setHorizontalAlignment(SwingConstants.CENTER);
        labelCadastro.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
        labelCadastro.setForeground(Color.WHITE);
        frame.getContentPane().add(labelCadastro);
        
        JLabel lblBackground = new JLabel("");
        ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("/fundo_preto_com_borda_rosa.jpg"));
        lblBackground.setIcon(imgBackground);
        lblBackground.setBounds(0, -66, 444, 886);
        frame.getContentPane().add(lblBackground);
        //
        
        
        //
		
//		JButton btnNewButton = new JButton("Já tem cadastro? Fazer login");
//		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
//		btnNewButton.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
//		btnNewButton.setBounds(40, 558, 364, 59);
//		frame.getContentPane().add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("Novo usuário? Fazer cadastro");
//		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
//		btnNewButton_1.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
//		btnNewButton_1.setBounds(40, 649, 364, 59);
//		frame.getContentPane().add(btnNewButton_1);
		
//		JButton btn1 = ViewUtil.criaBotao(40, 570, 364, 59, "Já tem cadastro? Fazer login");
//		btn1.setForeground(Color.WHITE);
//		btn1.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
//		frame.getContentPane().add(btn1);
//		
//		JButton btn2 = ViewUtil.criaBotao(40, 649, 370, 59, "Novo usuário? Fazer cadastro");
//		btn2.setForeground(Color.WHITE);
//		btn2.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
//		frame.getContentPane().add(btn2);
		
	}
}
