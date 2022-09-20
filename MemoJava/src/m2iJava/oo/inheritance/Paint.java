package m2iJava.oo.inheritance;

/**
 * Paint hérite de Tool.
 * 
 * Paint a deux responsabilités :
 * 
 * - Construire correctement Tool
 * - Implémenter les méthodes abstraites
 */
public class Paint extends Tool {

	private Color color;
	
	/**
	 * Mon constructeur va initialiser Paint et Tool
	 * 
	 * @param price
	 * @param color
	 */
	public Paint(int price, Color color) {
		super("Paint" , price);
		
		this.color = color;
	}

	@Override // Spécifique à Java quand on ré-implémente une méthode
	public void Use(Car car) {
		car.setColor(color);
	}
}
