package com.geometrie.formes;
import com.geometrie.base.Point;

public class Cercle {
  public Point centre ;
  public double rayon;
  public String couleur ="noir";
  public static int nbCercles=0;
  
public Cercle() {
	centre =new Point();
	rayon=1;
	nbCercles++;
} 
public Cercle (Point centre ,double rayon) {
	this.centre=centre;
	this.rayon=rayon;
	nbCercles++;
	
}

public Cercle(double x ,double y ,double rayon ,String couleur) {
	this.centre=new Point(x,y);
	this.rayon=rayon;
	this.couleur=couleur;
	nbCercles++;
}

public void mon_etat() {
	System.out.println("Cercle[centre=("+centre.abs+","+centre.ord+"), rayon ="+rayon+", couleur ="+couleur+"]");
}

public double getPerimetre() {
	return 2*Math.PI*rayon;
}

public double getSurface() {
	return Math.PI*rayon*rayon;
}

public void deplacer(double dx , double dy) {
	this.centre.abs=dx;
	this.centre.ord=dy;
}

public void deplacer (Point  nouveauCentre ) {
	this.centre= nouveauCentre;
}

public boolean estPlusGrandQue (Cercle autre) {
	return this.rayon > autre.rayon;
}
public static int getNbCercles(){
	return nbCercles;
}
}

