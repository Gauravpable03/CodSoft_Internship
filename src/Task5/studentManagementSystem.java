package Task5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class studentManagementSystem {
	static ArrayList<Student> AL = new ArrayList<>();

	public static void main(String args[]) throws IOException {
		MemoryReader();
		Scanner s = new Scanner(System.in);
		boolean CanIKeepRunningTheProgram = true;
		while (CanIKeepRunningTheProgram) {
			System.out.println("....Welcome to StudentManagementSystem....");
			System.out.println("1.Add Student");
			System.out.println("2.Edit Student");
			System.out.println("3.Delete Student");
			System.out.println("4.Search Student");
			System.out.println("5.Display all Student");
			System.out.println("6.Exit\n");

			int OptionBySelectByUser = s.nextInt();
			if (OptionBySelectByUser == StudentOption.add) {
				AddUser();
			} else if (OptionBySelectByUser == StudentOption.Edit) {
				System.out.println("Enter the Email to Edit");
				s.nextLine();
				String UN = s.nextLine();
				EditUser(UN);
			} else if (OptionBySelectByUser == StudentOption.Delete) {
				System.out.println("Enter the Email to Delete");
				s.nextLine();
				String UND = s.nextLine();
				DeleteUser(UND);
			} else if (OptionBySelectByUser == StudentOption.Search) {
				System.out.println("Enter the Email to Search");
				s.nextLine();
				String UNS = s.nextLine();
				SearchUser(UNS);
			}else if (OptionBySelectByUser == StudentOption.Display) {
				DisplayallStudent();
			}else if (OptionBySelectByUser == StudentOption.Quit) {
				File F = new File("C:\\Users\\Admin\\eclipse-workspace\\Codsoft_Intership\\src\\Task5\\Student.txt");

				FileWriter FW = new FileWriter(F, false);

				BufferedWriter BW = new BufferedWriter(FW);

				for (Student u : AL) {
					BW.write(u.RollNo + "," + u.Name+ "," + u.Email + "," + u.Grade+"\n");
					
				}
				BW.close();
				FW.close();
				F = null;
				System.out.println("!...Program Closed...!");

				CanIKeepRunningTheProgram = false;
				
			}
		}
	}

	private static void DisplayallStudent() {
	    if (AL.isEmpty()) {
	        System.out.println("No students to display.");
	    } else {
	        System.out.println("All Students:\n");
	        for (Student u : AL) {
	            System.out.println("RollNo: " + u.RollNo);
	            System.out.println("Name: " + u.Name);
	            System.out.println("Email: " + u.Email);
	            System.out.println("Grade: " + u.Grade);
	            System.out.println("---------------------------");
	        }
	    }
	}
	public static void AddUser() {
		Scanner s = new Scanner(System.in);
		Student StudentObject = new Student();
		System.out.println("RollNO :");
		StudentObject.RollNo = s.nextLine();
		System.out.println("Name :");
		StudentObject.Name = s.nextLine();
		System.out.println("Email :");
		StudentObject.Email = s.nextLine();
		System.out.println("Grade");
		StudentObject.Grade = s.nextLine();
		System.out.println("\n");
		System.out.println("RollNo :" + StudentObject.RollNo);
		System.out.println("Name :" + StudentObject.Name);
		System.out.println("Email :" + StudentObject.Email);
		System.out.println("Grade :" + StudentObject.Grade);
		System.out.println("\n");
		AL.add(StudentObject);
	}

	public static void EditUser(String Email) {
		for (Student u : AL)
			if (u.Email.equalsIgnoreCase(Email)) {
				Scanner s = new Scanner(System.in);
				System.out.println("Editing User " + u.Email );
				System.out.println("RollNO :");
				u.RollNo = s.nextLine();
				System.out.println("Name :");
				u.Name = s.nextLine();
				System.out.println("Email :");
				u.Email = s.nextLine();
				System.out.println("Grade");
				u.Grade = s.nextLine();
				System.out.println("\n");
				System.out.println("Information Updated");
				return;
			}
	}

	public static void DeleteUser(String Email) {
		Iterator<Student> UserIterator = AL.iterator();
		while (UserIterator.hasNext()) {
			Student U = UserIterator.next();
			if (U.Email.equalsIgnoreCase(Email)) {
				UserIterator.remove();
				System.out.println(U.Email + " has been deleted");
			}
		}
	}

	public static void SearchUser(String Email) {
		for (Student u : AL) {
			if (u.Email.equalsIgnoreCase(Email)) {
				System.out.println("RollNo : "+u.RollNo);
				System.out.println("Name : "+u.Name);
				System.out.println("Grade  : "+u.Grade);
				return;
			}
		}
	}

	public static void MemoryReader() throws IOException {
		File F = new File("C:\\Users\\Admin\\eclipse-workspace\\Codsoft_Intership\\src\\Task5\\Student.txt");

		FileReader FR = new FileReader(F);

		BufferedReader BR = new BufferedReader(FR);

		String Line;

		while ((Line = BR.readLine()) != null) {
			Student u = new Student();

			String[] userarraylist = Line.split(",");

			if (userarraylist.length > 3) {
				u.RollNo = userarraylist[0];
				u.Name = userarraylist[1];
				u.Email = userarraylist[2];
				u.Grade = userarraylist[3];
				AL.add(u);
			}
		}

	}

}
