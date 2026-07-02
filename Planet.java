package com.solarexplorer.solarexplorer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.List;

//Model class - represents a planet , Extending from GameObject
public class Planet extends GameObject{
	private String name;
	private Color color;
	private double size;
	private int moons;
	private double distanceFromSun;
	private List<String> clues;
	
	
	public Planet(GraphicsContext gc , double x , double y,
			String name , Color color , double size,
			int moons, double distanceFromSun, List<String> clues) {
		super(gc, x , y);
		this.name = name;
		this.color = color;
		this.size = size;
		this.moons = moons;
		this.distanceFromSun = distanceFromSun;
		this.clues = clues;
		
	
		
		
	}
	
	public void update() {
		
		//Draws a circle instead of image
		gc.setFill(color);
		gc.fillOval(x, y, size, size);
		
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font("Arial", 11));
		gc.fillText(name,  x + size + 4,  y + size / 2);
		
		
		
		
	}
	
	public String getname() {return name;}
	public int getMoons() {return moons; }
	public double getDistanceFromSun() { return distanceFromSun; }
	public List<String> getClues() {return clues;} //Educational clues revealed one at a time
	public double getSize() { return size; }
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

}
