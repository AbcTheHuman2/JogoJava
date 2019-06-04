package EstadoJogo;

import java.util.ArrayList;

public class StateManager {
	
	private ArrayList<JogoEstado> estados;
	private int estadoAtual;
	
	public static final int ESTADOMENU = 0;
	public static final int ESTADOFASE1 = 1;
	
	public StateManager() {
		
		estados = new ArrayList<JogoEstado>();
		
		estadoAtual = ESTADOMENU;
		estados.add(new MenuEstado(this));
	}
	
	public void setEstado(int estado) {
		estadoAtual = estado;
		estados.get(estadoAtual).init();
	}
	
	public void update() {
		estados.get(estadoAtual).update();
	}
	
	public void draw(java.awt.Graphics2D g) {
		estados.get(estadoAtual).draw(g);
	}
	
	public void keyPressed(int k) {
		estados.get(estadoAtual).keyPressed(k);
	}
	
	public void keyReleased(int k) {
		estados.get(estadoAtual).keyReleased(k);
	}
}
