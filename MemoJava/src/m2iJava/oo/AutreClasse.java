package m2iJava.oo;

import java.util.List;

public class AutreClasse {

	// Composition, une classe en attribut d'une classe
	private ClassExample classExample;
	
	// Aggregation, une collection de classe en attribut
	private List<ClassExample> examples;
	
	// Association, une classe en paramètre d'une méthode
	private void SomeMethod(ClassExample example)
	{
		
	}
}
