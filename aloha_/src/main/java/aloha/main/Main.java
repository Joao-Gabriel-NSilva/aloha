package aloha.main;

import aloha.DAO.Configuracoes;
import aloha.views.main.MainFeed;
import aloha.views.main.ViewInicial;

public class Main {

	public static void main(String[] args) {
		Configuracoes config = new Configuracoes();
		//config.salvarConfigs();
		
		
		if(config.getUsuarioConectado() == null) {
			ViewInicial.main(null);
		} else {
			MainFeed.main(null);
		}
		
	}

}
