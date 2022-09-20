package m2iJava.oo;


/**
 * Défini un ensemble de méthodes qui doivent être implémentées par une classe nous implémentant
 * 
 * Une classe implémente une interface
 * 
 * <portée> interface <identifiant>
 */
public interface InterfaceExample {
	
	// pas de portée (public implicite)
	// <type de retour> <identifiant> <arguments>
	void SetValue(int value);
	
	int GetValue();
	
	/**
	 * Permet de forcer plusieurs implémentations à respecter la même définition
	 * 
	 * Permet de partager une classe "en tant que" à une autre classe, et ainsi de limiter
	 * ce que l'utilisateur peut faire avec votre référence
	 */
}
