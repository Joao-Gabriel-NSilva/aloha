package aloha.util;

import javax.swing.ImageIcon;

public class Icones {

	public ImageIcon getImgVerificado() {
		return new ImageIcon(this.getClass().getResource("/icons/verificado.png"));
	}

	public ImageIcon getImgNaoVerificado() {
		return new ImageIcon(this.getClass().getResource("/icons/nao_verificado.png"));
	}

	public ImageIcon getImgOlhoAberto() {
		return new ImageIcon(this.getClass().getResource("/icons/eye_visible_hide_hidden_show_icon.png"));
	}

	public ImageIcon getImgOlhoAbertoComRisco() {
		return new ImageIcon(this.getClass().getResource("/icons/eye_slash_visible_hide_hidden_show_icon.png"));
	}
	
	public ImageIcon getImgUsuario() {
		return new ImageIcon(this.getClass().getResource("/icons/user_icon.png"));
	}
	
	public ImageIcon getImgSenha() {
		return new ImageIcon(this.getClass().getResource("/icons/password_icon.png"));
	}
	
	public ImageIcon getImgVoltar() {
		return new ImageIcon(this.getClass().getResource("/icons/botao_voltar.png"));
	}
	
	public ImageIcon getImgLightTheme() {
		return new ImageIcon(this.getClass().getResource("/icons/ligth_theme.png"));
	}
	
	public ImageIcon getImgDarkTheme() {
		return new ImageIcon(this.getClass().getResource("/icons/dark_theme.png"));
	}
	
	public ImageIcon getImgArrouba() {
		return new ImageIcon(this.getClass().getResource("/icons/arrouba_resized.png"));
	}
	
	public ImageIcon getImgFundoPretoComBordaRosa() {
		return new ImageIcon(this.getClass().getResource("/icons/fundo_preto_com_borda_rosa.jpg"));
	}

}
