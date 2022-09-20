package m2iJava.oo.inheritance;


// Ceci est un héritage, une classe étend une autre classe
public class Nitro extends Tool {

	private int extraSpeed;
	
	public Nitro(int price, int extraSpeed) {
		super("Nitro", price);
		
		this.extraSpeed = extraSpeed;
	}

	@Override
	public void Use(Car car) {
		car.setMaxSpeed(car.getMaxSpeed() + extraSpeed);
	}

}
