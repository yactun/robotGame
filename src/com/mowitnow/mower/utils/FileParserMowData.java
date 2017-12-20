package com.mowitnow.mower.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mowitnow.mower.CartesianCoordinates;
import com.mowitnow.mower.CartesianGridMovingAround;
import com.mowitnow.mower.Directions;
import com.mowitnow.mower.Movements;
import com.mowitnow.mower.Mow;
import com.mowitnow.mower.SquareGrid;

public class FileParserMowData {
	static List<Mow> mows = new ArrayList<Mow>();
	static SquareGrid grid;
	static CartesianGridMovingAround moving;
	static List<List<Movements>> movements = new ArrayList<List<Movements>>();

	public static void main(String[] args) {
		init();
	}

	public static void init() {
		String workingDirectory = System.getProperty("user.dir");
		System.out.println(workingDirectory);
		try (BufferedReader br = new BufferedReader(new FileReader(
				"D:\\DEV\\projects\\game\\robot\\robotGame\\src\\com\\mowitnow\\mower\\utils\\textfile.txt"))) {
			boolean firstLine = true;
			int cpt = 0;
			String line;
			CartesianCoordinates c;
			Mow m;
			List<Movements> lmvt;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(" ");
				// parse line
				if (firstLine && tokens.length == 2) {
					grid = new SquareGrid(Integer.parseInt(tokens[0]),
							Integer.parseInt(tokens[1]));
					moving = new CartesianGridMovingAround(grid);
					firstLine = false;
				}
				switch (tokens.length) {
				case 3:
					c = new CartesianCoordinates();
					c.setX(Integer.parseInt(tokens[0]));
					c.setY(Integer.parseInt(tokens[1]));
					c.setDirection(Directions.valueOf(tokens[2]));
					m = new Mow("Mow N° " + cpt, c, moving);
					mows.add(m);
					cpt++;
					break;
				case 1:
					lmvt = new ArrayList<Movements>();
					for (char i : tokens[0].toCharArray()) {
						lmvt.add(Movements.valueOf(String.valueOf(i)));
					}
					;
					movements.add(lmvt);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<Mow> getMows() {
		return mows;
	}

	public static SquareGrid getGrid() {
		return grid;
	}

	public static CartesianGridMovingAround getMoving() {
		return moving;
	}

	public static List<List<Movements>> getMovements() {
		return movements;
	}

}
