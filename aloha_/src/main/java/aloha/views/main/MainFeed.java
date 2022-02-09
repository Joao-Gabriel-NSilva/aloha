package aloha.views.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

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
		frame.getContentPane().setBackground(Color.WHITE /* ViewUtil.COR_ATUAL_FUNDO */);
		frame.setResizable(false);
		frame.setLocation(700, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 103, 422, 381);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPublicadoPor = new JLabel("@Jaum");
		lblPublicadoPor.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		lblPublicadoPor.setBounds(64, 24, 152, 21);
		panel.add(lblPublicadoPor);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBorder(new LineBorder(Color.BLACK, 2));
		panel_1.setBounds(12, 65, 400, 227);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(4, 4, 393, 220);
		panel_1.add(scrollPane);

		JTextArea txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		txtArea.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		txtArea.setLineWrap(true);
		txtArea.setText(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer iaculis auctor purus faucibus ultrices. Suspendisse hendrerit ornare odio, at varius metus euismod in. In ultrices purus vitae imperdiet pharetra. Aliquam accumsan pellentesque ante, ut elementum nulla viverra a. In bibendum lacus nisi. Suspendisse tempus arcu et nisl tincidunt ullamcorper. Curabitur commodo elementum vestibulum. Nunc massa augue, malesuada sed justo id, auctor sodales lacus. Integer id magna id lorem molestie dignissim. Vivamus lorem libero, maximus in neque vitae, placerat luctus est. Praesent vitae nisi ut metus varius pharetra. Maecenas ac leo sit amet dolor sodales malesuada porta vel ipsum. Suspendisse eget mollis nisl, non mattis nulla. Phasellus vel tempus tortor, ac congue turpis.\r\n"
						+ "\r\n"
						+ "Integer fermentum porttitor nisl, vitae molestie quam tempor id. Praesent eget placerat quam. Duis molestie justo nibh, at vestibulum elit dapibus id. Nulla luctus vel lorem ac iaculis. Morbi posuere turpis tortor, a aliquet ex congue non. Curabitur dignissim ut lectus vitae lacinia. Suspendisse fermentum dolor odio, ac ullamcorper lorem gravida vitae. Aliquam et lacus mi. In sit amet eros at nisl tempus feugiat varius id justo. Sed pulvinar ex at tortor ultricies, nec condimentum ligula tincidunt. Praesent pharetra arcu arcu, vitae feugiat sem imperdiet commodo. Donec erat ante, interdum pretium tincidunt id, pretium in leo. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam tristique bibendum erat, non rhoncus risus faucibus vitae.\r\n"
						+ "\r\n"
						+ "Nulla facilisi. Aenean luctus, eros sed malesuada aliquam, risus mauris luctus lorem, ac rhoncus eros libero in quam. Mauris eget volutpat orci. Integer vel ullamcorper lectus, at facilisis ipsum. Donec sollicitudin eu metus vel commodo. Sed justo ex, vestibulum quis nisi sit amet, vulputate vestibulum erat. Aliquam sodales, metus elementum rutrum laoreet, ipsum turpis iaculis elit, ut feugiat sem felis vel augue. Donec pharetra orci volutpat sem ornare placerat.\r\n"
						+ "\r\n"
						+ "Sed rhoncus tincidunt ligula id consequat. Etiam nisl sem, facilisis vitae purus in, tristique ornare dui. Morbi luctus volutpat orci, ut auctor magna ornare vel. Nullam eu lectus vel neque auctor hendrerit. Quisque facilisis ultricies elit vel iaculis. Praesent dictum risus et pellentesque ultricies. Phasellus at justo at lorem placerat convallis. Maecenas lorem eros, sagittis eget faucibus eu, eleifend sed nisl. Suspendisse faucibus, metus sit amet gravida tempor, nunc risus aliquet nisi, nec tincidunt magna ante sit amet nibh.\r\n"
						+ "\r\n"
						+ "Vestibulum convallis convallis efficitur. In consectetur mattis ligula eu efficitur. Aliquam nec purus at odio faucibus cursus sed in urna. Cras nunc nisl, condimentum id mi nec, tempus gravida tellus. Donec in mauris euismod, porta purus vitae, fermentum felis. Etiam et est libero. Aenean tincidunt et nibh sed placerat. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Ut viverra dictum turpis sed bibendum. Vestibulum eget hendrerit mi. Curabitur ultricies velit eget mi sollicitudin, at vestibulum leo dictum. Pellentesque congue mauris augue, ac molestie orci fermentum ut. Mauris ac justo tempus, consectetur leo non, mattis tellus. In lacinia lorem nec tellus fringilla, non consequat massa ornare. Morbi imperdiet, arcu nec placerat bibendum, diam elit lacinia mi, in imperdiet turpis sem nec quam. Pellentesque porta ex in egestas fermentum.");
		txtArea.setEditable(false);
		txtArea.setWrapStyleWord(true);
		txtArea.setBackground(new Color(230, 230, 250));

		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/icons/coracao.png"));
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/icons/balao_de_fala.png"));
		ImageIcon img3 = new ImageIcon(this.getClass().getResource("/icons/aviao.png"));
		ImageIcon img4 = new ImageIcon(this.getClass().getResource("/icons/marcador.png"));

		JLabel lblBotao1 = new JLabel();
		lblBotao1.setIcon(img1);
		lblBotao1.setBounds(12, 339, 37, 32);
		panel.add(lblBotao1);

		JLabel lblBotao2 = new JLabel();
		lblBotao2.setIcon(img2);
		lblBotao2.setBounds(64, 339, 37, 32);
		panel.add(lblBotao2);

		JLabel lblBotao3 = new JLabel();
		lblBotao3.setIcon(img3);
		lblBotao3.setBounds(111, 339, 37, 32);
		panel.add(lblBotao3);
		
		JLabel lblBotao4 = new JLabel();
		lblBotao4.setIcon(img4);
		lblBotao4.setBounds(159, 339, 37, 32);
		panel.add(lblBotao4);

		JLabel lblFoto = new JLabel("");
		lblFoto.setBounds(9, 15, 44, 39);
		panel.add(lblFoto);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(this.getClass().getResource("/icons/foto.jpg").getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblFoto.setIcon(imageIcon);

		JLabel lblNewLabel = new JLabel("Teste");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		lblNewLabel.setBounds(8, 302, 302, 14);
		panel.add(lblNewLabel);
		
		ImageIcon imagem1 = new ImageIcon(this.getClass().getResource("/icons/homepage.png"));
		ImageIcon imagem2 = new ImageIcon(this.getClass().getResource("/icons/lupa.png"));
		ImageIcon imagem3 = new ImageIcon(this.getClass().getResource("/icons/sino.png"));
		ImageIcon imagem4 = new ImageIcon(this.getClass().getResource("/icons/avatar_perfil.png"));
		
		JLabel lblHome = new JLabel();
		lblHome.setIcon(imagem1);
		lblHome.setBounds(35, 748, 48, 53);
		frame.getContentPane().add(lblHome);
		
		JLabel lblLupa = new JLabel();
		lblLupa.setIcon(imagem2);
		lblLupa.setBounds(118, 748, 48, 53);
		frame.getContentPane().add(lblLupa);
		
		JLabel lblPerfil = new JLabel();
		lblPerfil.setIcon(imagem4);
		lblPerfil.setBounds(367, 748, 48, 53);
		frame.getContentPane().add(lblPerfil);
		
		JLabel lblSino = new JLabel();
		lblSino.setIcon(imagem3);
		lblSino.setBounds(284, 748, 48, 53);
		frame.getContentPane().add(lblSino);
		
		JLabel lblNewLabel_1 = new JLabel("F");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(201, 756, 48, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel labelAloha = new JLabel("Aloha");
		labelAloha.setFont(new Font("Brush Script MT", Font.PLAIN, 40));
		labelAloha.setBounds(10, 11, 88, 36);
		frame.getContentPane().add(labelAloha);
		
	}
}
