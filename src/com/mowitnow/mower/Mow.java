package com.mowitnow.mower;

public class Mow {
	private final String name;
	private Coordinates coordinates;
	private final MovingAround movingAround;
	
	public Mow (String name, Coordinates coordinates, MovingAround movingAround){
		this.name=name;
		this.coordinates = coordinates;
		this.movingAround = movingAround; 
	}
	
	public String toString() {
		return super.toString()+ "Mow :"+name+" at :"+coordinates.toString();		
	}

    public void move(Movements m){
    	coordinates = movingAround.move(coordinates, m);
    }
}
