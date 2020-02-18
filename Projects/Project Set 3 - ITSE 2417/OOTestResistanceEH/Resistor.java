
public class Resistor {
	
	//***************************************************************************************************************************************
	//The arrays and values that will be used.
	private int color1 = 0, color2 = 0, color3 = 0, color4 = 0;
	
	private String[] Color = {"Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Grey", "White", "Gold", "Silver"};
	
	private int[] Multiplier = {1, (int) 1e2, (int) 1e3, (int) 1e4, (int) 1e5, (int) 1e6, (int) 1e7, (int) 1e8};

	private float[] Tolerance = {20, 1, 2, 0, 0, .5f, .25f, .1f, .05f, 0, 5, 10};
	//***************************************************************************************************************************************
	
	//***************************************************************************************************************************************
	//The Single Constructor
	public Resistor() {}
	//***************************************************************************************************************************************
	
	//***************************************************************************************************************************************
	//Accessor methods.
	
	//Color1.
	public String getColor1() {
		return Color[color1];
	}
	
	public void setColor1(String Scolor1) {
		this.color1 = ConvertToInt(Scolor1);
	}
	
	//Color2.
	public String getColor2() {
		return Color[color2];
	}
	
	public void setColor2(String Scolor2) {
		this.color2 = ConvertToInt(Scolor2);
	}
	
	//Color3.
	public String getColor3() {
		return Color[color3];
	}
	
	public void setColor3(String Scolor3) {
		this.color3 = ConvertToInt(Scolor3);
	}
	
	//Color4.
	public String getColor4() {
		return Color[color4];
	}
		
	public void setColor4(String Scolor4) {
		this.color4 = ConvertToInt(Scolor4);
	}
	//***************************************************************************************************************************************
	
	//***************************************************************************************************************************************
	//This function will calculate the value of the resistance.
	public int getResistance() {
		return (color1 * 10 + color2) * Multiplier[color3];
	}
	
	//This function will let the user know the tolerance and the color of the bands.
	public String getInformation() {
		return ColorBand() + "\nThe Tolerance is \u00B1 " + Tolerance[color4] + ".";
	}
	//***************************************************************************************************************************************
	
	//***************************************************************************************************************************************
	//The bands.
	private String ColorBand() {
		String ColorBand = " ";
		
		//If the user did submit a fourth band.
		if (color4 != 0)
		{
			ColorBand = "The Colors are: " + Color[color1] + ", " + Color[color2] + ", " + Color[color3] + 
					", " + Color[color4] + ".";
		}
		//If the user did not submit a fourth band.
		else
		{
			ColorBand = "The Colors are: " + Color[color1] + ", " + Color[color2] + ", " + Color[color3] + ".";
		}
			
		return ColorBand;
	}
	//***************************************************************************************************************************************

	
	//***************************************************************************************************************************************
	//Function that will turn the string into a integer value.
	private int ConvertToInt(String Color){
		
		int value = 0;
		
		switch (Color) {
			case "Black":
			{
				value = 0;
				break;
			}
			case "Brown":
			{
				value = 1;
				break;
			}
			case "Red":
			{
				value = 2;
				break;
			}
			case "Orange":
			{
				value = 3;
				break;
			}
			case "Yellow":
			{
				value = 4;
				break;
			}
			case "Green":
			{
				value = 5;
				break;
			}
			case "Blue":
			{
				value = 6;
				break;
			}
			case "Violet":
			{
				value = 7;
				break;
			}
			case "Grey":
			{
				value = 8;
				break;
			}
			case "White":
			{
				value = 9;
				break;
			}
			case "Gold":
			{
				value = 10;
				break;
			}
			case "Silver":
			{
				value = 11;
				break;
			}
			default:
			{
				value = 0;
			}
		}
		
		return value;
	}
	//***************************************************************************************************************************************

}
