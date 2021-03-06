package Logics;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class logic {
	File directory = null;

	public void displaAllFiles(File dir) {
		boolean success = false;
		try {
			File f = new File(dir + "/");

//			List listFile = Arrays.asList(f.list());			
//			Collections.sort(listFile);
//			System.out.println("Sorting by filename in ascending order");
//			for(Object s:listFile){
//				System.out.println(s);

//			}
			String[] child = f.list();
			if (child.length==0) {
				System.out.println("No File's Present in this directory:- "+dir);
			} else {
				for (int i = 0; i < child.length - 1; i++) {
					for (int j = i + 1; j < child.length; j++) {
						if (child[i].compareTo(child[j]) > 0) {
							String temp = child[i];
							child[i] = child[j];
							child[j] = temp;
						}
					}
				}
			}
			for (int i = 0; i < child.length; i++) {

				System.out.println("File name is:- " + child[i]);
			}
			System.out.println("\n");
			successfullmessage();

		} catch (InputMismatchException e) {
			System.out.println("Please enter valid input.\n");

		} catch (Exception f) {
			System.out.println("Something went wrong \n" + f);
		}

	}

//	public void add_file() {
//		Scanner reader = new Scanner(System.in);
//		boolean success = false;
//		try {
//			System.out.println("Enter file name to be created:\n");
//			String filename = reader.nextLine();
//			File f = new File(directory + "/" + filename);
//			if (f.exists()) {
//				System.out.println(f.getName() + ":" + " File is already exist in this:- " + directory + ":( \n");
////				failure();
//			} else {
//				success = f.createNewFile();
//				if (success) {
//					System.out.printf("New File created Successfully in this Directory:- " + directory
//							+ " and the File name is:-%s%n\n", f.getName());
////					successful();
//				} else {
//					System.out.printf("Failed to create new file:( %s%n\n", f.getName());
////					failure();
//				}
//			}
//		} catch (Exception f) {
//			System.out.println("Something went wrong \n" + f);
//		}
//	}

	public void add_files(File dir) {
		Scanner reader = new Scanner(System.in);
		boolean success = false;
		try {
			System.out.println("Enter file name to be created:\n");
			String filename = reader.nextLine();
			File f = new File(dir + "/" + filename);
			if (f.exists()) {
				System.out.println(f.getName() + ":" + " File is already exist in this:- " + dir + ":( \n");
						failuremessage();
			} else {
				success = f.createNewFile();
				if (success) {
					System.out.printf("New File created Successfully in this Directory:- " + dir
							+ " and the File name is:-%s%n\n", f.getName());
							successfullmessage();
				} else {
					System.out.printf("Failed to create new file:( %s%n\n", f.getName());
							failuremessage();
				}
			}
		} catch (Exception f) {
			System.out.println("Something went wrong \n" + f);
		}

	}

	public void delete_files(File dir) {
		Scanner reader = new Scanner(System.in);
		boolean success = false;
		try {
			System.out.println("Enter file name to be Delete:\n");
			String filename = reader.nextLine();
			File f = new File(dir + "/" + filename);
			if (f.exists()) {
				success = f.delete();
				if (success) {
					System.out.printf("The File was Successfully Deleted From this directory:- " + dir
							+ " and the file name is:- %s%n\n", f.getName());
					successfullmessage();
				} else {
					System.out.printf("File Not Found:( %s%n\n", f.getName());
					failuremessage();
				}

			} else {
				System.out.println(f.getName() + ":" + " File is not exist try with another name:( \n");
				failuremessage();
			}

		} catch (InputMismatchException e) {
			System.out.println("Please enter valid input.\n");
			reader.next();
		} catch (Exception f) {
			System.out.println("Something went wrong \n" + f);
		}
	}

	public void search_files(File dir) {
		Scanner reader = new Scanner(System.in);
		boolean success = false;
		try {
			System.out.println("Enter file name to be Search:\n");
			String filename = reader.nextLine();
			File f = new File(dir + "/");
			String[] children = f.list();
			boolean status = false;
			if (children == null) {
				System.out.println("does not exist\n");
				failuremessage();
			} else {
				for (int i = 0; i < children.length; i++) {
					if (filename.toLowerCase().equals(children[i].toLowerCase())) {
						status = true;
						break;
					} else {
						status = false;
					}
				}
				if (status == true) {
					System.out.println("The file is found in the directory:) " + dir + "\n");
					successfullmessage();
				} else {
					System.out.println("The file is Not Found in the directory:(\n");
					failuremessage();
				}
			}

		} catch (InputMismatchException e) {
			System.out.println("Please enter valid input.\n");
			reader.next();
		} catch (Exception f) {
			System.out.println("Something went wrong \n" + f);
		}

	}
	
	public void successfullmessage()
	{
		System.out.println("------:)------\n");
	}
	public void failuremessage()
	{
		System.out.println("------:(------\n");
	}

}
