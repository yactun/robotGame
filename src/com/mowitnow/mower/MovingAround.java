package com.mowitnow.mower;

public interface MovingAround {

	default Coordinates move(Coordinates c, Movements m){
		return c;
	}

}
