public class Project {
	// All the attributes for each object.
	private String projName;
	private String projNum;
	private String address;
	private int paidAmount;
	private int fee;
	private String deadline;
	private boolean finalised = false;
	private Person customer, contractor, architech;
	private String buildType;
	private String dateCompleted;
	
	// Using a constructor to set certain attributes of the object.
	public Project(String projName, String projNum, String address,
			int paidAmount, String deadline, Person customer,
			Person contractor, Person architech, String buildType,int fee) {
		this.projName = projName;
		this.projNum = projNum;
		this.address = address;
		this.paidAmount = paidAmount;
		this.deadline = deadline;
		this.customer = customer;
		this.contractor = contractor;
		this.architech = architech;
		this.buildType = buildType;
		this.fee = fee;
	}
	
	// Getters are used to get certain attributes of an object when called.
	// Getters under the class 'Person' is used to access Methods and Public attributes
	// in the specific object.
	public Person getCustomer() {
		return customer;
	}
	
	public Person getContractor() {
		return contractor;
	}
	
	public Person getArchitech() {
		return architech;
	}
	
	public int getPaidAmount() {
		return paidAmount;
	}
	
	public int getFee() {
		return fee;
	}
	
	public String getDeadline() {
		return deadline;
	}
	
	public String getDateCompleted() {
		return dateCompleted;
	}

	public void setName(String newName) {
		projName = newName;
	}
	
	public void setPaidAmount(int newAmount) {
		paidAmount = newAmount;
	}
	
	public void setDeadline(String newdate) {
		deadline = newdate;
	}
	
	public void setFinalised(boolean condi) {
		this.finalised = condi;
	}
	
	public void setDateCompleted(String compDate) {
		dateCompleted = compDate;
	}
	
	// Getting the amount still left to pay.
	public int unpaid() {
		int total = fee - paidAmount;
		
		return total;
	}
	
	// String representation of the relevant attributes of the objects in 'Project' and
	// the 'toString' of the customer object in 'Person'.
	public String toString() {
		String output = "\nProject name: " + projName
						+ "\nProject No.: " + projNum
						+ "\n" + customer
						+ "\nAmount left to pay: "
						+ this.unpaid();
		
		return output;
	}
	
	
}
