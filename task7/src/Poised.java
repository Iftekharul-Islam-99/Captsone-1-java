import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Poised {
	public static void main(String args[]) {
		String[] names = {"Customer", "Contractor", "Architech"}; // Array containing 3 titles.
		Person[] obj = new Person[3]; // Creating an array with length 3 of objects of 'Person' class.
		String name, teleNum, email, address;
		String projName, projNum, projAddress, buildType;
		String deadline;
		int paidAmount, fee;
		
		Scanner input = new Scanner(System.in);
		System.out.println("");
		
		// The loop gets 3 sets of info for each title in the names array.
		// After the info is gathered from user 3 objects are created under 'Person'.
		for (int count = 0; count < 3; count++) {
			System.out.println("Enter the details of the " + names[count]);
			System.out.println("\nName: ");
			name = input.nextLine().strip();
			System.out.println("Telephone No.: ");
			teleNum = input.nextLine().strip();
			System.out.println("Email: ");
			email = input.nextLine().strip();
			System.out.println("Address: ");
			address = input.nextLine().strip();
			
			obj[count] = new Person(name, teleNum, email, address, names[count]);
		}
		
		// This gets info for the project from user.
		System.out.println("\nEnter thhe project details:");
		System.out.println("\nProject name: ");
		projName = input.nextLine().strip();
		System.out.println("Project Number: ");
		projNum = input.nextLine().strip();
		System.out.println("Site Address: ");
		projAddress = input.nextLine().strip();
		
		// Making sure correct info is gathered from user.
		while (true) {
			System.out.println("Building type (House, Apartment or Store): ");
			buildType = input.nextLine().strip().toLowerCase();
			
			if (buildType.equals("house") || buildType.equals("apartment") || buildType.equals("store")){
				break;
			}else {
				System.out.println("Incorrect building type. Try again.");
			}
		}
		
		fee = getFee(buildType);
		System.out.println("Due date (dd/mm/yyyy): ");
		deadline = input.nextLine().strip();
		
		// Checking if 'paidAmount' is within the correct boundaries.
		while (true) {
			System.out.println("Paid to date: ");
			paidAmount = input.nextInt();
			
			if (paidAmount <= fee  && paidAmount >= 0) {
				break;
			}else {
				System.out.println("Incorrect value. Try again.");
			}
		}
		
		// Creating an object under the class 'Project'.
		// The object contains all the info gathered from the user.
		// Also contains the 3 objects under 'Person' and all its public info.
		System.out.println(fee);
		Project proj = new Project(projName, projNum, projAddress,
				paidAmount,deadline , obj[0], obj[1], obj[2], buildType, fee);
		
		System.out.println("\n Invoice:\n" + proj);
		Scanner input2 = new Scanner(System.in);
		
		// Creating a menu and carrying out the appropriate actions depending on user choice.
		while (true){
			System.out.println("\nChoose from the menu below.\n"
							    + "ud - Update due date.\n"
								+ "uc - Update cotractors details.\n"
							    + "up - Update total amount paid to date.\n"
								+ "f - Finalise the project.\n"
							    + "e - Exit");
			
			String menu = input2.nextLine();
			
			// This updates the date with new user inputed date using setters in the class.
			if (menu.equals("ud")) {
				System.out.println("Current deadline: " + proj.getDeadline());
				System.out.println("\nEnter new due date (dd/mm/yyyy): ");
				String newDeadline = input2.nextLine();
				proj.setDeadline(newDeadline);
				System.out.println("New deadline set to " + newDeadline);
			
			// This updates the details of the contractor with new user inputed data using setters in the class.
			// We first access the object under 'Person' but using a getter in the 'project' class.
			// Then we can access the setter to set the new value.
			}else if (menu.equals("uc")) {
				System.out.println("Enter new details");
				System.out.println("Name: ");
				String newName = input2.nextLine();
				proj.getContractor().setName(newName);
				
				System.out.println("Telephone No.: ");
				String newTeleNum = input2.nextLine();
				proj.getContractor().setTeleNum(newTeleNum);
				
				System.out.println("Email: ");
				String newEmail = input2.nextLine();
				proj.getContractor().setEmail(newEmail);
				
				System.out.println("Telephone No.: ");
				String newAddress = input2.nextLine();
				proj.getContractor().setAddress(newAddress);
				
				System.out.println("Details updated.");
			
			// This sets the new paid amount.
			}else if (menu.equals("up")) {
				while (true) {
					System.out.println("Total fee of the project: " 
										+ proj.getFee()
										+ "\nCurrent amount paid to date: "
										+ proj.getPaidAmount());
					System.out.println("\nEnter new amount: ");
					int newAmount = input2.nextInt();
					
					if (newAmount <= fee && newAmount >= 0) {
						proj.setPaidAmount(newAmount);
						
						break;
					}else {
						System.out.println("that is an invalid amount. Try again.");
					}
				}
			
			// This finalises the project if the total fee is paid.
			// Also sets the current date if the project is finalised and displays all the info.
			}else if (menu.equals("f")) {
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String today = formatter.format(date);
				
				if (proj.getPaidAmount() == proj.getFee()) {
					proj.setFinalised(true);
					proj.setDateCompleted(today);
					
					System.out.println("Project finalised.");
					System.out.println(proj + "\n" + "Completion date: " + proj.getDateCompleted() );
					
					break;
				}else {
					System.out.println("Unable to finalise project. Thre is still "
										+proj.unpaid()+ " left to be paid");
				}
			
			// Exits the menu.
			}else if (menu.equals("e")) {
				break;
			}else {
				System.out.println("Incorrect choice. Try again.");
			}
		}
		
		input.close();
		input2.close();
	}
	
	// Method that sets the fee depending on the building type.
	public static int getFee(String buildType) {
		int fee = 0;
		
		if (buildType.equals("house")) {
			fee = 2000;
		}
		if (buildType.equals("apartment")) {
			fee = 1000;
		}
		if (buildType.equals("store")){
			fee = 3000;
		}
		
		return fee;
	}
	
}
