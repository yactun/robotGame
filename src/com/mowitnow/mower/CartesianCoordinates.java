package com.mowitnow.mower;

public class CartesianCoordinates implements Coordinates {	
	private int x;
	private int y;
	private Directions direction;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Directions getDirection() {
		return direction;
	}
	public void setDirection(Directions direction) {
		this.direction = direction;
	}
	@Override
	public String toString() {
		return "CartesianCoordinates [x=" + x + ", y=" + y + ", direction="
				+ direction + "]";
	}
}
