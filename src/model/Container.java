package model;

import java.util.ArrayList;

import it.unical.mat.embasp.languages.asp.SymbolicConstant;

public class Container {
	
	private static Container instance = null;
	
	private ArrayList<Pallina> palline;
	
	private Container() {
		palline = new ArrayList<Pallina>();
		createBalls();
	}
	
	public static Container getInstance() {
		if (instance == null)
			instance = new Container();
		return instance;
	}
	
	public ArrayList<Pallina> getPalline() {
		return palline;
	}
	
	public void clearAll() {
		palline.clear();
	}

	public void createBalls() {
		palline.add(new Pallina(new SymbolicConstant(Pallina.ROSA),0,0));
		palline.add(new Pallina(new SymbolicConstant(Pallina.ROSA),1,0));
		palline.add(new Pallina(new SymbolicConstant(Pallina.ROSSA),2,0));
		palline.add(new Pallina(new SymbolicConstant(Pallina.GIALLA),3,0));
		palline.add(new Pallina(new SymbolicConstant(Pallina.VERDE),0,1));
		palline.add(new Pallina(new SymbolicConstant(Pallina.ROSSA),1,1));
		palline.add(new Pallina(new SymbolicConstant(Pallina.BLU),2,1));
		palline.add(new Pallina(new SymbolicConstant(Pallina.ROSA),3,1));
		palline.add(new Pallina(new SymbolicConstant(Pallina.VERDE),0,2));
		palline.add(new Pallina(new SymbolicConstant(Pallina.BLU),1,2));
		palline.add(new Pallina(new SymbolicConstant(Pallina.ROSSA),2,2));
		palline.add(new Pallina(new SymbolicConstant(Pallina.VERDE),3,2));
		palline.add(new Pallina(new SymbolicConstant(Pallina.GIALLA),0,3));
		palline.add(new Pallina(new SymbolicConstant(Pallina.BLU),1,3));
		palline.add(new Pallina(new SymbolicConstant(Pallina.VERDE),2,3));
		palline.add(new Pallina(new SymbolicConstant(Pallina.ROSA),3,3));
		palline.add(new Pallina(new SymbolicConstant(Pallina.GIALLA),0,4));
		palline.add(new Pallina(new SymbolicConstant(Pallina.BLU),1,4));
		palline.add(new Pallina(new SymbolicConstant(Pallina.ROSSA),2,4));
		palline.add(new Pallina(new SymbolicConstant(Pallina.GIALLA),3,4));

		palline.add(new Pallina(new SymbolicConstant(Pallina.VUOTA),0,5));
		palline.add(new Pallina(new SymbolicConstant(Pallina.VUOTA),1,5));
		palline.add(new Pallina(new SymbolicConstant(Pallina.VUOTA),2,5));
		palline.add(new Pallina(new SymbolicConstant(Pallina.VUOTA),3,5));
		
		palline.add(new Pallina(new SymbolicConstant(Pallina.VUOTA),0,6));
		palline.add(new Pallina(new SymbolicConstant(Pallina.VUOTA),1,6));
		palline.add(new Pallina(new SymbolicConstant(Pallina.VUOTA),2,6));
		palline.add(new Pallina(new SymbolicConstant(Pallina.VUOTA),3,6));
	}
}
