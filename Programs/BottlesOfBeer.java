//BottlesOfBeer.java
public class BottlesOfBeer {												//1
	public static void main(String[] arg) {
		int MAX_BOTTLES = 99;												//2
		int bottles = MAX_BOTTLES;
		
		while (bottles > 0) {
			if (bottles == 1) {
				System.out.println("1 bottle of beer on the wall.");
				System.out.println("1 bottle of beer.");
			} else {
				System.out.println(bottles + " bottles of beer on the wall.");
				System.out.println(bottles + " bottles of beer.");
			}
			bottles--;		
			System.out.println("You take one down, pass it around.");		//3
		switch (bottles) {
		case 0:
			System.out.println("No more bottles of beer on the wall.");
			System.out.println("Go to the store and buy some more, "
					+ "99 bottles of beer on the wall.");
			break;
		case 1:
			System.out.println("Only one bottle of beer on the wall.");		//4
			break;
		default:															//5
			System.out.println(bottles +" bottles of beer on the wall");
		}
		System.out.println();
	
		}
	}
}
