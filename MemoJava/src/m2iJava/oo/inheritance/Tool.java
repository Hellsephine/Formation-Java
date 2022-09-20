package m2iJava.oo.inheritance;


/**
 * La classe Tool s'utilise sur une voiture.
 * 
 * Elle a un prix, il faut payer pour l'utiliser.
 */
public abstract class Tool {

	// On hérite de Tool, mais je suis quand même privé
	private int price;
	
	private String name;
	
	public Tool(String name, int price)
	{
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public abstract void Use(Car car);
}
