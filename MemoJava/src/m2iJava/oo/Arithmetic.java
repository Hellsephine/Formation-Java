package m2iJava.oo;

public class Arithmetic {

	public static void main(String[] args)
	{
		int a = 2 + 2; // a vaut 4
		float b = 2.5f + 2; // b vaut 4.5f
		
		float c = 3 / 2; // c vaut 1
		
		float d = 3f / 2; // d vaut 1.5f
		
		float e = 3 / 2f; // e vaut 1.5f
		
		int f = 10 % 3; // f vaut 1
		
		// 0000 0010 -> 0000 0001
		int g = 2 >> 1; // g vaut 1, bitshift droite
				
		boolean h = 4 > 2; // true
		
		// 0100 | 0010 = 0110 = 6
		int i = 4 | 2; // i vaut 6, bitwise or
		
		// 0110 | 0010 = 0010 = 2
		int j = 6 & 2; // j vaut 2, bitwise and
		
		
	}
}
