package aloha.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import aloha.modelo.Usuario;
import aloha.util.ViewUtil;

public class Gostos {

	private JFrame frame;
	private JTextField outraFesta;
	private JTextField outraMusica;
	private JTextField outraComida;
	private static Usuario USUARIO;
	private List<ArrayList<Object>> listas = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gostos window = new Gostos();
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
	public Gostos() {
		initialize();
	}

	public Gostos(Usuario usuario) {
		USUARIO = usuario;
		main(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 508, 685);
		frame.setLocation(700, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// lbl gostos
		JLabel lbl2 = new JLabel("Quais são os seus gostos?");
		lbl2.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
		lbl2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl2.setBounds(95, 45, 311, 62);
		frame.getContentPane().add(lbl2);
		//

		// lbl Festas
		JLabel lblFestas = new JLabel("Quais são os seus estilos de festa favoritos?");
		lblFestas.setHorizontalAlignment(SwingConstants.LEFT);
		lblFestas.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblFestas.setBounds(45, 114, 411, 45);
		frame.getContentPane().add(lblFestas);
		//

		// check box estilos de festa
		ArrayList<Object> listaFesta = new ArrayList<>();
		listas.add(listaFesta);
		JCheckBox chboxRave = new JCheckBox("Rave");
		chboxRave.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxRave.setBounds(28, 172, 68, 23);
		chboxRave.setFocusable(false);
		frame.getContentPane().add(chboxRave);
		listaFesta.add(chboxRave);

		JCheckBox chboxFestival = new JCheckBox("Festival");
		chboxFestival.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxFestival.setBounds(124, 172, 73, 23);
		chboxFestival.setFocusable(false);
		frame.getContentPane().add(chboxFestival);
		listaFesta.add(chboxFestival);

		JCheckBox chboxShow = new JCheckBox("Show");
		chboxShow.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxShow.setBounds(225, 172, 59, 23);
		chboxShow.setFocusable(false);
		frame.getContentPane().add(chboxShow);
		listaFesta.add(chboxShow);

		outraFesta = new JTextField();
		outraFesta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outraFesta.setFocusable(true);
				outraFesta.setText(null);
			}
		});
		outraFesta.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		outraFesta.setText("Outra");
		outraFesta.setBounds(312, 171, 150, 23);
		outraFesta.setFocusable(false);
		frame.getContentPane().add(outraFesta);
		outraFesta.setColumns(10);
		listaFesta.add(outraFesta);
		//

		// lbl musicas
		JLabel lblMusicas = new JLabel("Quais são os seus estilos de música favoritos?");
		lblMusicas.setHorizontalAlignment(SwingConstants.LEFT);
		lblMusicas.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblMusicas.setBounds(39, 220, 423, 45);
		frame.getContentPane().add(lblMusicas);
		//

		// chech box musicas
		ArrayList<Object> listaMusicas = new ArrayList<>();
		listas.add(listaMusicas);
		JCheckBox chboxRap = new JCheckBox("Rap");
		chboxRap.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxRap.setFocusable(false);
		chboxRap.setBounds(28, 277, 59, 23);
		frame.getContentPane().add(chboxRap);
		listaMusicas.add(chboxRap);

		JCheckBox chboxFunk = new JCheckBox("Funk");
		chboxFunk.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxFunk.setBounds(125, 277, 68, 23);
		chboxFunk.setFocusable(false);
		frame.getContentPane().add(chboxFunk);
		listaMusicas.add(chboxFunk);

		JCheckBox chboxSertanejo = new JCheckBox("Sertanejo");
		chboxSertanejo.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxSertanejo.setBounds(231, 277, 85, 23);
		chboxSertanejo.setFocusable(false);
		frame.getContentPane().add(chboxSertanejo);
		listaMusicas.add(chboxSertanejo);

		JCheckBox chboxPagode = new JCheckBox("Pagode");
		chboxPagode.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxPagode.setBounds(359, 277, 97, 23);
		chboxPagode.setFocusable(false);
		frame.getContentPane().add(chboxPagode);
		listaMusicas.add(chboxPagode);

		JCheckBox chboxPop = new JCheckBox("Pop");
		chboxPop.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxPop.setFocusable(false);
		chboxPop.setBounds(28, 317, 63, 23);
		chboxPop.setFocusable(false);
		frame.getContentPane().add(chboxPop);
		listaMusicas.add(chboxPop);

		outraMusica = new JTextField();
		outraMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outraMusica.setFocusable(true);
				outraMusica.setText(null);
			}
		});
		outraMusica.setText("Outra");
		outraMusica.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		outraMusica.setFocusable(false);
		outraMusica.setColumns(10);
		outraMusica.setBounds(125, 317, 191, 23);
		frame.getContentPane().add(outraMusica);
		listaMusicas.add(outraMusica);
		//

		// lbl bebidas
		JLabel lblBebidas = new JLabel("Quais são as suas bebidas favoritas?");
		lblBebidas.setHorizontalAlignment(SwingConstants.LEFT);
		lblBebidas.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblBebidas.setBounds(76, 365, 341, 43);
		frame.getContentPane().add(lblBebidas);
		//

		// check box bebidas
		ArrayList<Object> listaBebidas = new ArrayList<>();
		listas.add(listaBebidas);
		JCheckBox chboxCerveja = new JCheckBox("Cerveja");
		chboxCerveja.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxCerveja.setBounds(29, 415, 85, 23);
		chboxCerveja.setFocusable(false);
		frame.getContentPane().add(chboxCerveja);
		listaBebidas.add(chboxCerveja);

		JCheckBox chboxAlcolicas = new JCheckBox("Alcólicas");
		chboxAlcolicas.setToolTipText("Bebidas alocólicas em geral. Vodka, Uísque, etc.");
		chboxAlcolicas.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxAlcolicas.setBounds(136, 415, 97, 23);
		chboxAlcolicas.setFocusable(false);
		frame.getContentPane().add(chboxAlcolicas);
		listaBebidas.add(chboxAlcolicas);

		JCheckBox chboxRefrigerante = new JCheckBox("Refrigerante");
		chboxRefrigerante.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxRefrigerante.setBounds(255, 415, 106, 23);
		chboxRefrigerante.setFocusable(false);
		frame.getContentPane().add(chboxRefrigerante);
		listaBebidas.add(chboxRefrigerante);

		JCheckBox chboxAgua = new JCheckBox("Água");
		chboxAgua.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxAgua.setBounds(388, 415, 68, 23);
		chboxAgua.setFocusable(false);
		frame.getContentPane().add(chboxAgua);
		listaBebidas.add(chboxAgua);
		//

		// lbl comidas
		JLabel lblComidas = new JLabel("Quais suas comidas favoritas?");
		lblComidas.setHorizontalAlignment(SwingConstants.LEFT);
		lblComidas.setFont(new Font("Arial Narrow", Font.PLAIN, 25));
		lblComidas.setBounds(102, 450, 289, 39);
		frame.getContentPane().add(lblComidas);
		//

		// check box comida
		ArrayList<Object> listaComidas = new ArrayList<>();
		listas.add(listaComidas);
		JCheckBox chboxEspetinho = new JCheckBox("Espetinhos");
		chboxEspetinho.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxEspetinho.setBounds(29, 504, 97, 23);
		chboxEspetinho.setFocusable(false);
		frame.getContentPane().add(chboxEspetinho);
		listaComidas.add(chboxEspetinho);

		JCheckBox chboxComidaBoteco = new JCheckBox("Comida de boteco");
		chboxComidaBoteco.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxComidaBoteco.setBounds(166, 504, 159, 23);
		chboxComidaBoteco.setFocusable(false);
		frame.getContentPane().add(chboxComidaBoteco);
		listaComidas.add(chboxComidaBoteco);

		JCheckBox chboxLanche = new JCheckBox("Lanche");
		chboxLanche.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxLanche.setBounds(359, 504, 97, 23);
		chboxLanche.setFocusable(false);
		frame.getContentPane().add(chboxLanche);
		listaComidas.add(chboxLanche);

		JCheckBox chboxPizza = new JCheckBox("Pizza");
		chboxPizza.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		chboxPizza.setBounds(28, 541, 97, 23);
		chboxPizza.setFocusable(false);
		frame.getContentPane().add(chboxPizza);
		listaComidas.add(chboxPizza);

		outraComida = new JTextField();
		outraComida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outraComida.setFocusable(true);
				outraComida.setText(null);
			}
		});
		outraComida.setText("Outra");
		outraComida.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		outraComida.setFocusable(false);
		outraComida.setColumns(10);
		outraComida.setBounds(166, 541, 159, 23);
		frame.getContentPane().add(outraComida);
		listaComidas.add(outraComida);
		//

		// botão avançar
		JButton btnAvancar = ViewUtil.criaBotao(35, 590, 442, 44, "Avançar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (ArrayList<Object> lista : listas) {
					for (Object obj : lista) {
						try {
							if(((JCheckBox) obj).isSelected()) {
								USUARIO.getGostos().add(((JCheckBox) obj).getText());
							}
						} catch (ClassCastException ex) {
							if(!((JTextField) obj).getText().equals("Outra") & 
									!((JTextField) obj).getText().trim().isEmpty()) {
								USUARIO.getGostos().add(((JTextField) obj).getText());
							}
						}
					}
				}
				System.out.println(USUARIO.getGostos());
			}
		});
		frame.getContentPane().add(btnAvancar);
		//

		// botão voltar
		JLabel lblVoltar = ViewUtil.criaLblVoltar(this);
		frame.getContentPane().add(lblVoltar);

		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				ConhecerMelhor.main(null);
			}
		});
		//

	}
}
