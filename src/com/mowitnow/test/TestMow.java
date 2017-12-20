package com.mowitnow.test;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mowitnow.mower.CartesianGridMovingAround;
import com.mowitnow.mower.Movements;
import com.mowitnow.mower.Mow;
import com.mowitnow.mower.SquareGrid;
import com.mowitnow.mower.utils.FileParserMowData;

public class TestMow {
	List<Mow> mows;
	SquareGrid grid;
	CartesianGridMovingAround moving;
	List<List<Movements>> movements;

	@Before
	public void setUp() throws Exception {
		FileParserMowData.init();
		mows = FileParserMowData.getMows();
		grid = FileParserMowData.getGrid();
		moving = FileParserMowData.getMoving();
		movements = FileParserMowData.getMovements();
	}

	@Test
	public void test() {

		for (int i = 0; i < mows.size(); i++) {
			Mow mow = mows.get(i);
			for (Movements mvt : movements.get(i)) {
				mow.move(mvt);
			}
			System.out.println(mow.toString());
		}
	}

}
