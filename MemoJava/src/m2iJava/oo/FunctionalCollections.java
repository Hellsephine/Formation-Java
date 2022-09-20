package m2iJava.oo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalCollections {
	
	public static Integer Transform(String value)
	{
		return Integer.parseInt(value);
	}
	
	public static void FunctionExample()
	{
		// x -> Integer.parseInt(x)
		
		Function<String, Integer> referenceSurMethod = FunctionalCollections::Transform;
		referenceSurMethod.apply("13");
		
		Function<String, Integer> referenceSurLambda = x -> Integer.parseInt(x);
		referenceSurLambda.apply("14");
		
		// Function : prend des entrées, renvoie quelque chose
	}
	
	public static void Log(Integer value)
	{
		// Log dans un fichier
	}
	
	public static void ConsumerExample()
	{
		// Un consumer contient une méthode qui ne renvoie rien
		Consumer<Integer> test = FunctionalCollections::Log;
	}
	
	public static void main(String[] args)
	{
		// On initialise une liste
		ArrayList<Coords> coordsList = new ArrayList<Coords>();
		
		coordsList.add(new Coords(10, 15));
		coordsList.add(new Coords(2, 15));
		coordsList.add(new Coords(-4, 10));
		coordsList.add(new Coords(10, 13));
		
		ArrayList<Integer> xList = new ArrayList<Integer>(coordsList.size());
		for (Coords coords : coordsList)
			xList.add(coords.getX());
		
		/**
		 * Coords 10,15  ------> 10
		 * Coords 2,15   ------> 2
		 * Coords -4,10  ------> -4
		 * etc.
		 */
		
		// Une fonction anonyme
		Function<Coords, Integer> referenceSurLambda = coords -> coords.getX();
		
		List<Integer> xList2 = coordsList
			.stream() // Nécessaire pour accéder à la partie fonctionnelle des collections
			.map(referenceSurLambda) // Applique la fonction referenceSurLambda à chaque élément
			.toList(); // Créer une nouvelle collection avec le résultat
		
		/**
		 * map (transform) => transformer chaque valeur de la collection
		 * filter => garder les éléments qui satisfont une condition
		 * reduce => appliquer une opération sur les éléments pour obtenir un résultat
		 * (exemple : somme)
		 */
	}
}
