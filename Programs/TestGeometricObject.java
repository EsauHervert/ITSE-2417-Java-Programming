
public class TestGeometricObject {
	public static void main(String[] args) {
		
		//Object 1
		System.out.println("Obect 1: ");
		GeometricObject Ob1 = new GeometricObject();
		Ob1.setColor("Lavender");
		Ob1.setFilled(true);
		System.out.println(Ob1.toString());
		
		System.out.println();
		
		//Object 2
		System.out.println("Object 2: ");
		GeometricObject Ob2 = new GeometricObject();
		Ob2.setColor("Maroon");
		Ob1.setFilled(false);
		System.out.println(Ob2.toString());
	}

}
