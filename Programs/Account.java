
public class Account {
	private int number = 0;
	public Customer customer = new Customer(0);
	private String type = " ";
	private double balance = 0;
	private static int tranCount = 0;
	
	// Now the object takes in values.
	public Account(int number, String type, double balance)
	{
		this.number = number;
		this.type = type;
		this.balance = balance;
		this.customer = getCustomer(number);
	}
	
	/* Returns a Customer */
	public Customer getCustomer(int number)
	{
		Customer customer = new Customer(number);
		return customer;
	}
	
	/* Returns number */
	public int getNumber() {
		return number;
	}
	
	/* Set a new number */
	public void setNumber(int n) {
		this.number = n;
	}
	
	/* Returns type */
	public String getType() {
		return type;
	}
	
	/* Set a new type */
	public void setType(String type) {
		this.type = type;
	}

	/* Returns balance */
	public double getDouble() {
		return balance;
	}
	
	/* Set a new balance */
	public void setDouble(double b) {
		this.balance = b;
	}
}

class Customer {
	private int customernumber = 0;
		
	//Now the object takes in a value.
	public Customer(int customernumber)
	{
		this.customernumber = customernumber;
	}
	
	/* Returns number */
	public int getCustomer() {
		return customernumber;
	}
	
	/* Set a new number */
	public void setCustomer(int customernumber) {
		this.customernumber = customernumber ;
	}
	
	public String info() {
		return "The index is " + customernumber + ".";
	}
}
