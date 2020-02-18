
public class Chapter11Test {

	public static void main(String[] args){

		GeometricObject One = new GeometricObject();
		One.area = 1;
		One.perimeter = 1;
		
		System.out.println(One.area);
		
	}
}

class GeometricObject {
	double area = 0;
	double perimeter = 0;
}

class Circle extends GeometricObject {
	
	double r = 0;
	
	public double Area() {
		area = r * r * 3.14159;
		return area;
	}
	
	public double Perimeter() {
		perimeter = 3.14159 * 2 * r;
		return perimeter;
	}
}

class rectangle extends GeometricObject {
	
	double length = 0;
	double width = 0;
	
	public double Area() {
		area = length * width;
		return area;
	}
	
	public double Perimeter() {
		perimeter = 2 * length + 2 * width;
		return perimeter;
	}
}