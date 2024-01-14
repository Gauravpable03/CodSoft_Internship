package Task2;
import java.util.Scanner;

public class StudentGradeCalculator {
	public static void main(String args[]) {
		int i , Avg  ;
		Scanner s = new Scanner(System.in);
		System.out.println(".....Welcome to Student Grade Calculator.....\n");

		System.out.println("Enter your name :");
		String name = s.nextLine();
		System.out.println("\n");

		System.out.println("Hi " + name + "....\n");

		System.out.println("Enter the No.of Subject :");
		int n = s.nextInt();
       
		int totalmarks = 0;
		int k = 1 ;
		for (i = 0; i < n; i++) {
			System.out.println("\n"+"Enter Marks of Subject"+ k++ +":");
			int m = s.nextInt();
			totalmarks += m;
		}
		Avg = totalmarks / i;
		if (Avg >= 90) {
			System.out.println("\n"+name +"\n"+"This is your Total Marks ="+ totalmarks +"\nThis is your Average Marks =" + Avg +"%"+", This is your grade A+");
		} else if (90 > Avg && Avg >= 80) {
			System.out.println("\n"+name + "\n"+"This is your Total Marks ="+ totalmarks +"\nThis is your Average Marks =" + Avg +"%" +", This is your grade A");
		} else if (80 > Avg && Avg >= 70) {
			System.out.println("\n"+name +"\n"+"This is your Total Marks ="+ totalmarks +"\nThis is your Average Marks =" + Avg +"%" + ",This is your grade B+");
		} else if (70 > Avg && Avg >= 60) {
			System.out.println("\n"+name +"\n"+"This is your Total Marks ="+ totalmarks +"\nThis is your Average Marks =" + Avg+"%" + ",This is your grade B");
		} else if (60 > Avg && Avg >= 50) {
			System.out.println("\n"+name +"\n"+"This is your Total Marks ="+ totalmarks +"\nThis is your Average Marks =" + Avg +"%" + ",This is your grade C+");
		} else if (50 > Avg && Avg >= 35) {
			System.out.println("\n"+name +"\n"+"This is your Total Marks ="+ totalmarks +"\nThis is your Average Marks =" + Avg+"%"  + ",This is your grade C");
		} else if (35 > Avg && Avg >= 0) {
			System.out.println("\n"+name +"\n"+"This is your Total Marks ="+ totalmarks +"\nThis is your Average Marks =" + Avg+"%"  + ",This is your garde  F");
		}
	}
}
