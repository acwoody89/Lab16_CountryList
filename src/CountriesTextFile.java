import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class CountriesTextFile {
	
	
	public static void createFile() {
		String fileName = "countries.txt";

		// Path filePath = Paths.get(dirString, fileName);
		Path filePath = Paths.get(fileName);
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("The file was created successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong...createFile()");
				e.printStackTrace();
			}
			System.out.println("File Name: " + filePath.getFileName() + " Found.");
			System.out.println("Absolute Path: " + filePath.toAbsolutePath());
		} else if (Files.exists(filePath)) {
			System.out.println("File: " + filePath.getFileName() + " Found.");
			System.out.println("Absolute Path: " + filePath.toAbsolutePath());
		}

	}
	
	public static void writeToFile(String country) {
//		String dirName = "resources";
		String fileName = "countries.txt";

		Path writeFile = Paths.get(fileName);

		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println(country);
			outW.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Something went wrong...writeToFile()");
		} // true allows us to keep what we previously added

	}
	
	
	public static ArrayList<String> readFromFile() { // make an ArrayList
		String fileName = "countries.txt";

		// Path filePath = Paths.get(dirString, fileName);
		Path filePath = Paths.get(fileName);
		File file = filePath.toFile();
		ArrayList<String> cList = new ArrayList<>();
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();
			while (line != null) {
				cList.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Something went terribly, terribly wrong...");
		}
		
		return cList;

	}
}
