package Index;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import Logics.*;

public class index {
	static File directory =null;
	public static void main(String[] args) {
		System.out.println("Welcome Virtual Key for Your Repositories \t Developer Details :Shridhar Dhuttaragi \n\n");
		Scanner sc = new Scanner(System.in);
		boolean success;
		
		System.out.println("Enter path of directory to create\t Ex:(/E:/sample/)\n");

		String dir = sc.nextLine();
		 directory = new File(dir);
		if (directory.exists()) {
			System.out.println("Directory already exists..please Enter 'YES' If you want to perform other Operation in same Directory\n");
			String action=sc.nextLine();	
			if(action.toLowerCase().equals("yes"))
			{
				perform_sometask();
			}
			else
			{
				System.out.println("Please try with some other path of directory to create\n");
			}
		} else {
			
			perform_sometask();
		}
	}
	public static void perform_sometask()
	{
		boolean quit = true;
		Scanner sc = new Scanner(System.in);
		boolean success;
		logic l = new logic();
		int choice;
		
		success = directory.mkdir();
		if (success) {
			System.out.printf("Successfully created new directory : %s%n\n", directory);
			
		} else {
			System.out.printf("Failed to create new directory: %s%n\n", directory);
		}
		
		while (quit) {
			try {
				System.out.println("Enter 1 to Display all File Name's\n");
				System.out.println("Enter 2 to Business level operation\n");
				System.out.println("Enter 3 to Quit\n");
				System.out.println("------------------------------------\n");

				System.out.println("Enter your Option:\n");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					l.displaAllFiles(directory);
					break;

				case 2:
					boolean innerquit = true;
					while (innerquit) {
						System.out.println("Enter '1' to Add  a file to the existing directory\n");
						System.out.println("Enter '2' to Delete a file from existing directory\n");
						System.out.println("Enter '3' to Search a file from  existing directory\n");
						System.out.println("Enter '4' to Quit\n");
						System.out.println("------------------------------------\n");
						System.out.println("Enter your Option:\n");
						int bschoice = sc.nextInt();
						switch (bschoice) {
						case 1:
							l.add_files(directory);
							break;
						case 2:
							l.delete_files(directory);
							break;
						case 3:
							l.search_files(directory);
							break;
						case 4:
							innerquit = false;
							break;
						default:
							System.out.println("Sry please Enter valid Key\n");
							break;
						}
					}
					break;

				case 3:
					System.out.println("Thank you:)");
					quit = false;
					break;

				default:
					System.out.println("Sry please Enter valid Key\n");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter valid input.\n");
				sc.next();
			} catch (Exception f) {
				System.out.println("Something went wrong \n" + f);
			}
		}
	}

}
