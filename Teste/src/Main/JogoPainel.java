package Main;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import EstadoJogo.StateManager;

import java.awt.*;
import java.awt.event.*;

public class JogoPainel extends JPanel implements Runnable, KeyListener {
	
	//Constantes de dimensões
	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;
	
	//Thread do jogo
	private Thread thread;
	private boolean rodando;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	//Imagem
	private BufferedImage imagem;
	private Graphics2D g;
	
	private StateManager sm;
	
	public JogoPainel() {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
	}
	
	private void init() {
		
		imagem = new BufferedImage(
				WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB
				);
		g = (Graphics2D) imagem.getGraphics();
		
		rodando = true;
		
		sm = new StateManager();
	}
	
	public void run() {
		
		init();
		
		long start;
		long elapsed;
		long wait;
		
		//loop
		
		while (rodando) {
			
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000;
			
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void update() {
		sm.update();
	}
	
	private void draw() {
		sm.draw(g);
	}
	
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(imagem, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
		
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		sm.keyPressed(e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		sm.keyReleased(e.getKeyCode());
	}
	
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
}
