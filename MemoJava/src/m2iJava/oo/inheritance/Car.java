package m2iJava.oo.inheritance;

public class Car {

	private Color color;
	
	private int wheelPressure;
	
	private int maxSpeed;
	
	protected Car(Color color, int wheelPressure, int maxSpeed) {
		super();
		this.color = color;
		this.wheelPressure = wheelPressure;
		this.maxSpeed = maxSpeed;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWheelPressure() {
		return wheelPressure;
	}

	public void setWheelPressure(int wheelPressure) {
		this.wheelPressure = wheelPressure;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void SetColor(Color color)
	{
		this.color = color;
	}
	
}
