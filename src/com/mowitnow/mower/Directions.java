package com.mowitnow.mower;

public enum Directions {

	N("North"),E("East"),S("South"),W("West");
	private String inter;
private Directions(String s){
	this.inter = s; 
}	
@Override
public String toString() {
	return inter;
}
}
