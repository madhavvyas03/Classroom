package assign_2_ap_2020310;
import java.util.Scanner;
public class Classroom {
	public static void main(String[] args) {
		int a = Integer.MAX_VALUE ;
		for (int i = 0 ; i<a ; i++) {
			display();
			Scanner sc = new Scanner(System.in);	
			int f = sc.nextInt();
			if (f==1) {
				System.out.println("Instructor");
				Instructor.pseudo();
				Student.default_ass();
				continue;
			}
			else if (f==2) {
				System.out.println("Student");
				Student.main();
			}
			else if (f==3) {
				System.out.println("Exiting..");
				return ;
			}
			else {
				System.out.println("Wrong input");
				continue ;
			}
		}
	}

	private static void display() {
		System.out.println("Welcome to Bakcpack");
		System.out.println("1. Enter as instructor");
		System.out.println("2. Enter as student");
		System.out.println("3. Exit");
	}
}
