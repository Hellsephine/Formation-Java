package m2iJava.oo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

/**
 * Classe contenant des examples d'utilisation de collections
 */
public class CollectionExample {

	private static void HashSetExample()
	{
		// Table de hashage, ne contient que des éléments uniques
		HashSet<Integer> intSet = new HashSet<Integer>();
		
		intSet.add(3);
		intSet.add(3);
		intSet.add(3);
		
		System.out.println(intSet.size());
		
		intSet.remove(3);
		
		System.out.println(intSet.size());
		
		// HashSet n'a pas d'indexe, on ne peut pas get(int i)
		// HashSet est très efficace pour ajouter un élément et garantir son unicité
		// HashSet est très efficace pour retirer un élément spécifique
		// HashSet est moins efficace à itérer
		
		/**
		 * A l'intérieur de la classe, on va trouver un grand tableau
		 * 
		 * internal = 
		 * [
		 * 0,
		 * 1,
		 * 
		 * 
		 * ...
		 * 
		 * 
		 * 
		 * 
		 * 391 = A
		 * 
		 * 
		 * 
		 * 
		 * n-2,
		 * n-1,
		 * n
		 * ]
		 * 
		 * Insérer un objet A, la table de hashage va appeler la méthode A.getHashCode();
		 * getHashCode renvoie un entier qui est calculé en fonction des attributs de la classe,
		 * ça sert d'identifiant numérique
		 * 
		 * int hashCode = A.getHashCode();
		 * int index = hashCode % n; // modulo, créer un index qui tient dans le tableau
		 * internal[index] = A;
		 * 
		 * Si un élément est déjà présent à "index", on a peut-être un doublon
		 * Sinon, on est unique
		 */
		
	}
	
	private static void ArrayListExample()
	{
		// Un tableau redimensionnable
		ArrayList<Integer> intList = new ArrayList<Integer>(6);
		
		/**
		 * internal =
		 * [
		 * <--- extra capacity --->
		 * 0 => null,
		 * 1 => null,
		 * 2 => null,
		 * 3 => null
		 * 4 => null
		 * 5 => null
		 * ]
		 * 
		 * size = 0
		 * capacity = 6
		 */
		
		intList.add(2);
		intList.add(4);
		intList.add(10);
		
		/**
		 * internal =
		 * [
		 * 0 => 2,
		 * 1 => 4,
		 * 2 => 10,
		 * <--- extra capacity --->
		 * 3 => null
		 * 4 => null
		 * 5 => null
		 * ]
		 * 
		 * size = 3
		 * capacity = 6
		 */
		
		intList.add(7);
		intList.add(8);
		intList.add(11);
		intList.add(12);
		
		/**
		 * internal2 =
		 * [
		 * 0 => 2,
		 * 1 => 4,
		 * 2 => 10,
		 * 3 => 7
		 * 4 => 8
		 * 5 => 11
		 * 6 => 12
		 * <--- extra capacity --->
		 * 7 => null
		 * 8 => null
		 * 9 => null
		 * 10 => null
		 * 11 => null
		 * ]
		 * 
		 * size = 7
		 * capacity = 12
		 */
		
		intList.remove(0);
	}
	
	public static void main(String[] args)
	{
		ArrayListExample();
		HashSetExample();
		
		// Queue = efficace pour du FIFO (first in first out) -- fil d'attente
		// Deck = efficace pour du LIFO (last in first out) -- tas de carte (Stack dans les autres langages)
		
		// TreeSet = efficace pour garder une collection triée
		// HashSet = efficace pour l'unicité
		
		// TreeMap = comme TreeSet mais clé + valeur
		// HashMap = comme hashSet mais clé + valeur
		Map<Integer, String> errorMessages = new HashMap<Integer, String>();
		errorMessages.put(404, "Page non trouvée");
		
		System.out.println(errorMessages.get(404));
		
		TreeSet treeSet = new TreeSet();
	}
}
