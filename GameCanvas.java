package com.solarexplorer.solarexplorer;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.List;




public class GameCanvas extends Canvas {

	private GraphicsContext gc;
	
	public GameCanvas(double width , double height) {
		super(width, height);
		gc = getGraphicsContext2D();
	}
	
	//Redraws solar system each round
	public void render(List<Planet> planets , Planet activePlanet) {
		
		//Sets Black Background
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, getWidth(), getHeight());
		
		double cx = getWidth() / 2;
		double cy = getHeight() /2;
		
		//Draws sun
		gc.setFill(Color.YELLOW);
		gc.fillOval(cx - 20 ,  cy - 20 ,  40 ,  40);
		
		
		
		for (Planet p : planets) {
			double orbitR = p.getDistanceFromSun();
			gc.setStroke(Color.rgb(255, 255, 255, 0.15));
			gc.setLineWidth(0.5);
			gc.strokeOval(cx - orbitR, cy -  orbitR,  orbitR * 2 , orbitR * 2);
			
			
			if (p == activePlanet) {
				gc.setStroke(Color.rgb(150, 140, 255, 0.8));
				gc.setLineWidth(2);
				gc.strokeOval(p.getX() - 3 ,  p.getY() - 3,
						p.getSize() + 6 , p.getSize() + 6);
			}
			
			p.update();
	
		
	}
	}
	
}
