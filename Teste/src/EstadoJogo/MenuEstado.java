package EstadoJogo;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import TileMap.Fundo;

import java.awt.*;

public class MenuEstado extends JogoEstado {
	
	private Fundo f;
	
	private int escolhaAtual = 0;
	private String[] opcoes = {
			"Começar",
			"Instruções",
			"Sair"
	};
	
	private Color corTitulo;
	private Font fonteTitulo;
	
	private Font fonte;
	
	
	
	public MenuEstado(StateManager sm) {
		
		this.sm = sm;
		
		try {
			
			f = new Fundo("/Fundos/aaa.gif", 1);
			f.setVector(-0.1, 0);
			
			corTitulo = new Color(128, 0, 0);
			fonteTitulo = new Font(
					"Century Gothic", Font.PLAIN, 28);
			
			fonte = new Font("Arial", Font.PLAIN, 12);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
		
	}

	@Override
	public void update() {
		f.update();
	}

	@Override
	public void draw(Graphics2D g) {
		
		//Fundo
		f.draw(g);
		
		//título
		g.setColor(corTitulo);
		g.setFont(fonteTitulo);
		g.drawString("Teste", 130, 70);
		
		//opções do menu
		g.setFont(fonte);
		for (int i = 0; i < opcoes.length; i++) {
			if (i == escolhaAtual) {
				g.setColor(Color.BLACK);
			} else {
				g.setColor(Color.RED);
			}
			g.drawString(opcoes[i], 135, 140 + i * 15);
		}
	}
	
	private void select() {
		if (escolhaAtual == 0) {
			// iniciar
		}
		
		if (escolhaAtual == 1) {
			// ajuda
		}
		
		if (escolhaAtual == 2) {
			//sair
			System.exit(0);
		}
	}
	
	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {
			select();
		}
		
		if (k == KeyEvent.VK_UP) {
			escolhaAtual--;
			if (escolhaAtual == -1) {
				escolhaAtual = opcoes.length - 1;
			}
		}
		
		if (k == KeyEvent.VK_DOWN) {
			escolhaAtual++;
			if (escolhaAtual == opcoes.length) {
				escolhaAtual = 0;
			}
		}
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}
