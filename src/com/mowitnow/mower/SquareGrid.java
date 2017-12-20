package com.mowitnow.mower;

public class SquareGrid {
	private final int length;
	private final int width;

	public SquareGrid(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public boolean isInsideGrid(CartesianCoordinates coordinates) {
		return coordinates.getX() >= 0 && coordinates.getX() <= width
				&& coordinates.getY() >= 0 && coordinates.getY() <= length;
	}

}
