package TileMap;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.image.*;
import javax.imageio.ImageIO;

import Main.JogoPainel;

public class Fundo {
	
	private BufferedImage imagem;
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	private double moveScale;
	
	public Fundo(String s, double ms) {
		
		try {
			imagem = ImageIO.read(
					getClass().getResourceAsStream(s)
					);
			moveScale = ms;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void setPosition(double x, double y) {
		this.x = (x * moveScale) % JogoPainel.WIDTH;
		this.y = (y * moveScale) % JogoPainel.HEIGHT;
	}
	
	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void update() {
		x += dx;
		y += dy;
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(imagem, (int)x, (int)y, null);
		if (x < 0) {
			g.drawImage(imagem, (int)x + JogoPainel.WIDTH,
					(int)y, null
					);
		}
		
		if (x > 0) {
			g.drawImage(
					imagem,
					(int)x - JogoPainel.WIDTH,
					(int)y,
					null
			);
		}
	}
}
