package companylockersltd;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class locker {

	public static void main(String[] args) throws IOException {
		int ch = 0, choice = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("\t`*`*`*`*`*`*`*`*`*`*`*`*`\n");
		System.out.println("\t    Welcome to locker ");
		System.out.println("\t    COMPANYLOCKERSLTD \n");
		System.out.println("\t`*`*`*`*`*`*`*`*`*`*`*`*`");
		System.out.println(" Developer\t: Shakti Tiwari \n Company\t: XYZcmpy \n");

		while (true) {
			System.out.println("Please choose one of the following options :");
			System.out.println("1. List Current Files");
			System.out.println("2. Business Operations");
			System.out.println("3. Close Application");
			try {
				ch = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Null Exception occurred");
			}

			switch (ch) {
			case 1: // List function feature to list all files in ascending order.
				listFiles();
				break;
			case 2:

				System.out.println("Please choose one of the following options :");
				System.out.println("1. Add a File");
				System.out.println("2. Delete a File");
				System.out.println("3. Search for a File");
				System.out.println("4. Back to main ");
				try {
					choice = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Null Exception occurred");
				}
				switch (choice) {
				case 1:
					// Creation of a file takes place
					System.out.println("Input the name of a file to be created: ");
					String fileCreate = sc.next();

					// Calling the function to create the file
					createFile(fileCreate);
					break;

				case 2:
					// deletion of a file takes place
					System.out.print("Input the name of a file to be deleted: ");
					String fileDelete = sc.next();

					// Calling the function to delete the file
					deleteFile(fileDelete);
					break;
				case 3:
					// Search for a file takes place
					System.out.println("Input the name of a file to be searched: ");
					String fileSearch = sc.next();

					// Calling the function to search the file
					searchFile(fileSearch);
					break;
				case 4:
					// Back to main
					break;

				default:
					// In the case of unprecedented input execute this
					System.out.println("\n Opps! Invalid Input,Re-do the process\n");
					break;
				}

				break;
			case 3:

				// Voluntarily exiting the application
				sc.close();
				System.out.println("\n It was nice having you here! See you again. Good bye...");
				System.exit(1);
				break;

			default:
				// In the case of unprecedented input execute this
				System.out.println("\n\n Opps! Invalid Input, Select within the range of 1-3\n");
				break;

			}
		}

	}

	// Bubble sort to sort file in ascending order
	public static String[] sort_sub(String array[], int size) {
		String temp = "";
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < (size - i); j++) {
				if (array[j - 1].compareToIgnoreCase(array[j]) > 0) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	// File listing function
	public static void listFiles() {

		int fileCount = 0;
		ArrayList<String> filenames = new ArrayList<String>();

		File directoryPath = new File("E:\\JAVAFSD\\phaseprojects\\VirtualkeysforyourRepositories\\src");
		File[] listOfFiles = directoryPath.listFiles();
		fileCount = listOfFiles.length;

		System.out.println("Files in ascending fashion: ");
		for (int i = 0; i < fileCount; i++) {
			if (listOfFiles[i].isFile()) {
				filenames.add(listOfFiles[i].getName());
			}
		}

		String[] str = new String[filenames.size()];

		for (int i = 0; i < filenames.size(); i++) {
			str[i] = filenames.get(i);
		}

		String[] sorted_filenames = sort_sub(str, str.length);

		for (String currentFile : sorted_filenames) {
			System.out.println(currentFile);
		}

	}

	// File delete function
	public static void deleteFile(String fileToBeDeleted) {

		File file = new File(
				("E:\\JAVAFSD\\phaseprojects\\VirtualkeysforyourRepositories\\src") + "\\" + fileToBeDeleted);

		if (file.exists()) {
			if (file.delete()) {
				System.out.println("Hoorah! File deleted successfully!");
			}
		} else {
			System.out.println("Sorry, File wasn't deleted (File Not Found)");
		}
	}

	// File search function
	public static void searchFile(String fileToBeSearched) {

		File file = new File(
				("E:\\JAVAFSD\\phaseprojects\\VirtualkeysforyourRepositories\\src") + "\\" + fileToBeSearched);

		// Check whether file whether file exists or not.
		// If yes then display associated message
		if (file.exists()) {
			System.out.println("Yep! File found!");
		} else {
			System.out.println("Sorry, File is not here (File Not Found)");
		}
		PrintWriter pw;
		try {
			pw = new PrintWriter(fileToBeSearched); // may throw exception
			pw.println("saved");
		}
		// providing the checked exception handler
		catch (FileNotFoundException e) {

			System.out.println(e);
		}
	}

	// File creation function
	public static void createFile(String fileToBeCreated) {
		File file = new File(
				("E:\\JAVAFSD\\phaseprojects\\VirtualkeysforyourRepositories\\src") + "\\" + fileToBeCreated);

		try {
			if (file.createNewFile()) {
				System.out.println("File Created!");
			} else {
				System.out.println("File already exists :(");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
