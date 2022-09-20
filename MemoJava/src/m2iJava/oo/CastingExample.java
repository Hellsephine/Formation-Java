package m2iJava.oo;

import java.util.ArrayList;
import java.util.List;

/**
 * Exemples d'interactions entre une classe et une interface
 */
public final class CastingExample {

	public static void main(String[] args)
	{
		// Je peux assigner une instance de ClassExample dans une référence de ClassExample
		ClassExample classExample = new ClassExample();
		classExample.ExampleMethod(3); // J'ai accès à toutes les méthodes de ClassExample
		
		// Je ne peux pas instancier une interface, son code n'existe pas
		// InterfaceExample interfaceExample = new InterfaceExample()
		
		// Je peux assigner une instance de ClassExample dans une référence de InterfaceExample
		// uniquement car ClassExample implémente InterfaceExample
		InterfaceExample interfaceExample = new ClassExample();
		 // interfaceExample.ExampleMethod(3); je n'ai pas accès aux autres méthodes de ClassExample
		
		// interface List<E>
		// class ArrayList<E> implements List<E>
		List<Integer> intList = new ArrayList<Integer>();
		
		InterfaceExample interfaceExample2 = classExample;
		
		ImplicitCastExample(interfaceExample);
		
		// Cast implicit, garanti de fonctionner
		ImplicitCastExample(classExample); 
		
		// Cast explicit (la reponsabilité est au développeur)
		ClassExample newClassExample = (ClassExample) interfaceExample2;
	}
	
	public static void ImplicitCastExample(InterfaceExample interfaceEx)
	{
		
	}
}
