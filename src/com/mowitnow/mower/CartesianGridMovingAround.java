package com.mowitnow.mower;

public class CartesianGridMovingAround implements MovingAround {

	private final SquareGrid grid;

	public CartesianGridMovingAround(SquareGrid grid) {
		this.grid = grid;
	}

	@Override
	public Coordinates move(Coordinates c, Movements m) {
		CartesianCoordinates start;
		CartesianCoordinates aim = new CartesianCoordinates();
		try {
			start = (CartesianCoordinates) c;
		} catch (ClassCastException e) {
			throw new IllegalArgumentException(
					" for cartesian moving needs cartesian coordinates");
		}

		updateDirection(start, aim, m);
		updatePosition(start, aim, m);
//		System.out.println("**************");
//		System.out.println("start : "+ start);
//		System.out.println("mouvement :"+ m);
//		System.out.println("aim : "+aim);
//		System.out.println("**************");
		if (grid.isInsideGrid(aim)) {
//			System.out.println("retenu");
			return aim;
		} else {
//			System.out.println(" ! non retenu");
			return start;
		}
	}

	private void updateDirection(CartesianCoordinates start,
			CartesianCoordinates aim, Movements m) {
		Directions[] tabDirections = Directions.values();
		switch (m) {
		case D:
			aim.setDirection(tabDirections[(start.getDirection().ordinal() + 1)
					% (tabDirections.length)]);
			break;
		case G:
			if (start.getDirection().ordinal() - 1 >= 0) {
				aim.setDirection(tabDirections[start.getDirection().ordinal() - 1]);
			} else {
				aim.setDirection(Directions.W);
			}
			break;
		case A:
			aim.setDirection(start.getDirection());
		}

	}

	private void updatePosition(CartesianCoordinates start,
			CartesianCoordinates aim, Movements m) {
		if (m != Movements.A) {
			aim.setX(start.getX());
			aim.setY(start.getY());
			return;
		}

		Directions direction = start.getDirection();
		switch (direction) {
		case N:
			aim.setX(start.getX());
			aim.setY(start.getY() + 1);
			break;
		case E:
			aim.setX(start.getX() + 1);
			aim.setY(start.getY());
			break;
		case S:
			aim.setX(start.getX());
			aim.setY(start.getY() - 1);
			break;
		case W:
			aim.setX(start.getX() - 1);
			aim.setY(start.getY());
		}
	}

}
