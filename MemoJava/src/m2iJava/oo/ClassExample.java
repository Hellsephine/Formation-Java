/**
 * Package contenant la classe
 * Equivalent à la suite de dossiers où se trouve le dossier Java
 */
package m2iJava.oo;

// Ceci est une classe
// <portée> [final] [abstract] <type> <identifiant>
/**
 * final : on ne peut pas hériter de la classe
 * 
 * abstract : la classe contient-elle des méthodes abstraites ?
 * On ne peut pas instancier une classe abstraite
 * 
 * type : classe/interface/@interface/enumeration
 * 
 * identifiant : identifiant Java valide qui commence par une majuscule
 * 
 * "implements <interface>", la classe doit implémenter les méthodes définies dans l'interface
 */
public class ClassExample implements InterfaceExample {
	
	/****************************
	 * Les attributs (variables de classe)
	 ****************************/
	
	// <portée> <type> <identifiant> [ = valeur par défaut];
	/**
	 * portée : private/protected/public
	 * private ne peut être utilisé que dans ce fichier
	 * 
	 * protected ne peut être utilisé que dans ce fichier
	 * et les classes qui héritent de nous-même
	 * 
	 * public peut être utilisé par tout le monde (c'est le mal)
	 */
	private int value;
	
	/**
	 * Les types primitifs
	 */
	
	// Stocké sur 4 octets
	// 0111 1111 1111 1111 1111 1111 1111 1111 = 2147483647 
	private int unEntier = 12;
	
	private float unNombreFlottant = 12.5f;
	
	private double unGrandNombreFlottant = 12.3874767463;
	
	// 0111 1111 1111 1111 = 32767
	private short unPetitEntier = 15;
	
	// 0111 1111 = 128
	private byte unOctet = 124;
	
	private char unCaractere = 'c';
	
	// Max = 9223372036854775807
	private long unGrandEntier = 156153123;
	
	private boolean uneValeurVraiFaux = 3 > 2;
	
	/**
	 * Les attributs de type classe
	 */
	// Peut être null ou peut contenir une instance de String
	// Ceci s'appelle une référence
	private String unMot;
	
	// Peut être null ou peut contenir une instance de Integer
	// Integer est une classe avec un attribut de type "int"
	private Integer uneClasseContenantUnEntier;
	
	private Float uneClasseContenantUnNombreFlottant;
	
	/************************************
	 * Les constructeurs
	 ************************************/
	
	// Permet d'initialiser une nouvelle instance
	// <portée> <nom de la classe> <arguments>
	public ClassExample(int value)
	{ 
		// Appelle le constructeur par défaut de la classe parente
		super();
		
		// Code pour initialiser les attributs
		this.value = value;
		
		// "this" == référence sur l'instance courante
	}
	
	// Constructeur sans argument = constructeur "par défaut"
	public ClassExample()
	{
		super();
	}
	
	/***************************************
	 * Méthodes
	 ***************************************/
	 
	// Code exécuté par une instance de la classe
	
	// [@Override] en cas de surchage
	// <portée> [abstract] [final] <un type de retour> <un identifiant> <arguments>
	public void /* void = pas de retour */ ExampleMethod(int unArgument)
	{
		// Modifier les attributs
		
		// Assigner des nouvelles valeurs
		// Appeler des méthodes de notre instance ou de nos attributs
	}
	
	public String ExampleMethodAvecRetour()
	{
		// Modifier les attributs
		
		// Assigner des nouvelles valeurs
		// Appeler des méthodes de notre instance ou de nos attributs
		
		// Renvoyer une information
		return Integer.toString(value);
	}
	
	// Exemple : getter/setter
	
	// Renvoie une information
	public int GetValue()
	{
		return value;
	}
	
	// Modifie un attribut
	public void SetValue(int value)
	{
		this.value = value;
	}
	
	/**********************************
	 * Méthodes statics
	 **********************************/
	 
	// Souvent dans une classe utilitaire qui n'a pas pour but d'être instanciée
	
	// Executés sans être liées à une instance
	public static String /* renvoie quelque chose */ ExampleCalcul(int a, int b) // a des attributs
	{
		return Integer.toString(a + b);
	}
	
	/***********************************
	 * Exemple d'utilisation
	 ***********************************/
	public static void main(String[] args)
	{
		// <Type> <identifiant variable> <assignation>
		ClassExample exampleA = new ClassExample(3); // new <Type> <argument>, instantiation
		
		ClassExample exampleB = new ClassExample(5);
		
		// exampleA et exempleB ont chacun leur mémoire respective
		
		/**
		 * La référence sharedExample pointe sur la même instance sur la référence exampleA
		 */
		ClassExample sharedExample = exampleA;
		
		// Si on modifie l'instance référence par sharedExample, on modifie exampleA aussi et inversement.
		
		/**
		 * exampleA       -----------------------------> instance new ClassExample(3)
		 * sharedExample  ----------------/
		 * 
		 * 
		 * exampleB       -----------------------------> instance new ClassExample(5)
		 */
		
		// J'appelle la méthode SetValue sur l'instance référencée par exempleA
		// <référence> '.' <méthode> <arguments>
		exampleA.SetValue(5);
	}
}