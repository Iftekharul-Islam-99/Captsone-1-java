public class Person {
	private String name;
	private String teleNum;
	private String email;
	private String address;
	private String job;
	
	// Constructor that stores all the values in the specified attributes.
	public Person(String name, String teleNum, String email, String address, String job) {
		this.name = name;
		this.teleNum = teleNum;
		this.email = email;
		this.address = address;
		this.job = job;
	}
	
	// These are setters that will update info for the called object.
	public void setName(String newName) {
		name = newName;
	}
	
	public void setTeleNum(String newTeleNum) {
		name = newTeleNum;
	}
	
	public void setEmail(String newEmail) {
		name = newEmail;
	}
	
	public void setAddress(String newAddress) {
		name = newAddress;
	}
	
	// String representation of all the attributes of the object.
	public String toString() {
		String output = "Customer name: " + name
						+ "\nTelephone No.: " + teleNum
						+ "\nEmail: " + email
						+ "\nAddress: " + address;
		
		return output;
	}
	
}
