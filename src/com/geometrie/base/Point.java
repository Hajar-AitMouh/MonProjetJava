package com.geometrie.base;

public class Point {
	public double abs ,ord ;
	public String couleur="noir";
	
public Point() {
	this.abs=0;
	this.ord=0;
}

public Point (double abs ,double ord) {
	this.abs=abs;
	this.ord=ord;
}

public  void mon_etat() {
	System.out.print("("+abs+","+ord+")"+couleur);
}

public double distance (Point p) {
	return Math.sqrt((this.abs-abs)*(this.abs-abs)+(this.ord-ord)*(this.ord-ord));
}
@Override
public String toString() {
	return "Point (abs=" + abs + ", ord=" + ord + ")";
}

}
