package aloha.views.cadastro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

public class ConhecerMelhor {

	private JFrame frame;
	private static Usuario USUARIO;
	private static JFrame FRAME_ANTERIOR;
	public static JFrame FRAME_SEGUINTE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConhecerMelhor window = new ConhecerMelhor();
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
	public ConhecerMelhor() {
		initialize();
	}

	public ConhecerMelhor(Usuario usuario, JFrame frameAnterior) {
		USUARIO = usuario;
		FRAME_ANTERIOR = frameAnterior;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 460, 840);
		frame.setLocation(700, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame = ViewUtil.criaJFrame(100, 100, 460, 840);
		frame.setTitle("Vamos nos conhecer melhor?");

		// lbl 1, 2 e 3
		JLabel lbl1 = new JLabel("Para o melhor de sua experiência,");
		lbl1.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(10, 102, 434, 62);
		lbl1.setForeground(Color.BLACK);
		//JLabel lbl1 = ViewUtil.criaJLabel(50, 195, 418, 62, "Vamos nos conhecer melhor?", 30);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("precisamos conhecer");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lbl2.setBounds(10, 158, 434, 62);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("seus gostos.");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setForeground(Color.BLACK);
		lbl3.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		lbl3.setBounds(10, 216, 434, 62);
		frame.getContentPane().add(lbl3);
		//
		
		// botao sim
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.setOpaque(true);
		btnAvancar.setContentAreaFilled(false);
		btnAvancar.setForeground(Color.BLACK);
		btnAvancar.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnAvancar.setBounds(149, 571, 155, 44);
		btnAvancar.setFocusable(false);
		btnAvancar.setBorderPainted(false);
		//JButton btnSim = ViewUtil.criaBotao(60, 373, 90, 44, "Sim");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				if(FRAME_SEGUINTE != null) {
					FRAME_SEGUINTE.setVisible(true);
				} else {
					new Gostos(USUARIO, frame);
				}
			}
		});
		btnAvancar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnAvancar.setForeground(Color.BLUE);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		if(frame.getContentPane().getBackground().equals(Color.WHITE)) {
        			btnAvancar.setForeground(Color.BLACK);
        		} else {
        			btnAvancar.setForeground(Color.WHITE);
        		}
        	}
        });
		btnAvancar.setFocusable(false);
		frame.getContentPane().add(btnAvancar);
		//
		
		// botao pq disso
		JButton btnPQDisso = new JButton("Por que disso?");
		btnPQDisso.setOpaque(true);
		btnPQDisso.setContentAreaFilled(false);
		btnPQDisso.setForeground(Color.BLACK);
		btnPQDisso.setFont(new Font("Arial Narrow", Font.PLAIN, 32));
		btnPQDisso.setBounds(111, 644, 232, 44);
		btnPQDisso.setFocusable(false);
		btnPQDisso.setBorderPainted(false);

		//JButton btnPQDisso = ViewUtil.criaBotao(220, 373, 170, 44, "Agora não");
		btnPQDisso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPQDisso.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnPQDisso.setForeground(Color.BLUE);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		if(frame.getContentPane().getBackground().equals(Color.WHITE)) {
        			btnPQDisso.setForeground(Color.BLACK);
        		} else {
        			btnPQDisso.setForeground(Color.WHITE);
        		}
        	}
        });
		btnPQDisso.setFocusable(false);
		frame.getContentPane().add(btnPQDisso);
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar(this);
		frame.getContentPane().add(lblVoltar);
		
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				FRAME_ANTERIOR.setVisible(true);
				CrieASenha.FRAME_SEGUINTE = frame;
			}
		});
		//
		
//		JLabel lblBackground = new JLabel("");
//        ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("/wallpaper_gradient-pink-black-linear.png"));
//        lblBackground.setIcon(imgBackground);
//        lblBackground.setBounds(0, 0, 444, 802);
//        frame.getContentPane().add(lblBackground);
	}
}
