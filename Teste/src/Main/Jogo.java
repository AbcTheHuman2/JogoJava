package Main;

import javax.swing.JFrame;

public class Jogo {
	
	public static void main (String[] args) {
		
		JFrame tela = new JFrame("Teste");
		tela.setContentPane(new JogoPainel());
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.pack();
		tela.setVisible(true);
	}
}
