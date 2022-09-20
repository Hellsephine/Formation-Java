package m2iJava.oo;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Compare spécifique pour Coords, permet de changer la logique de tri
 * 
 * Ici on compare par y en premier
 */
public class CoordsCustomSort implements Comparator<Coords> {

	@Override
	public int compare(Coords o1, Coords o2) {
		
		int yCompare = Integer.compare(o1.getY(), o2.getY());
		
		// if ternaire
		// condition ? valeur si vrai : valeur si faux
		return yCompare == 0 ? Integer.compare(o1.getX(), o2.getX()) : yCompare;
	}

	public static void main(String[] args)
	{
		TreeSet<Coords> treeMap = new TreeSet<Coords>(new CoordsCustomSort());
		
		treeMap.add(new Coords(10, 15));
		treeMap.add(new Coords(2, 15));
		treeMap.add(new Coords(-4, 10));
		treeMap.add(new Coords(10, 13));
		
		for (Coords coords : treeMap)
			System.out.println(coords);
	}
}
