package m2iJava.oo;

import java.util.TreeSet;

public class Coords implements Comparable<Coords>
{

	private int x;
	private int y;
	
	public Coords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getHashCode()
	{
		// return x + y; coords 1-3 a le même hash que 3-1
		return Integer.hashCode(x)^2 + Integer.hashCode(y);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean Equals(Coords coords)
	{
		return x == coords.x && y == coords.y;
	}
	
	@Override
	public int compareTo(Coords coords) {
		/**
		 * -1 je suis plus petit
		 * 0 je suis égal
		 * 1 je suis plus grand
		 */
		
		if (x < coords.x)
			return -1;
		else if (x > coords.x)
			return 1;
		else
			return Integer.compare(y, coords.y);
		
		/**
		 * int compareX = Integer.compare(x, coords.x);
		 * if (compareX == 0)
		 * 	 return Integer.compare(y, coords.y);
		 * else
		 * 	 return compareX;
		 */
	}
	
	public String toString()
	{
		return x + ":" + y;
	}
	
	public static void main(String[] args)
	{
		TreeSet<Coords> treeMap = new TreeSet<Coords>();
		
		treeMap.add(new Coords(10, 15));
		treeMap.add(new Coords(2, 15));
		treeMap.add(new Coords(-4, 10));
		treeMap.add(new Coords(10, 13));
		
		for (Coords coords : treeMap)
			System.out.println(coords);
	}
}
