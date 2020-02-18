
public class GeometricObject {
	private String color = "White";
	private Boolean filled = false;
	private java.util.Date dateCreated;
	
	/* Constructs a default geometric object */
	public GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	/** Constructs a geometric object with the specific color 
	 * and filled value */
	public GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	/* Returns color */
	public String getColor() {
		return color;
	}
	
	/* Set a new color */
	public void setColor(String color) {
		this.color = color;
	}
	
	/* Returns filled, since filled is boolean,
	 * its getter method is names isFilled */
	public boolean getisFilled() {
		return filled;
	}
	
	/* Set a new filled */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	/* Get dateCreated */
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	/* Return a string representation of this object */
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color +
				" and filled: " + filled;
	}
}
