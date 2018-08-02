import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("This is the Country List Menu");
		String input = "";
		int inputNum = 0;
		ArrayList<String> list = new ArrayList<>();
		CountriesTextFile.createFile();
		do {
			printMenu();
			
			inputNum = Validator.getInt(scan, "Please choose!", 1, 3);
			
			if(inputNum == 1) {
				list = CountriesTextFile.readFromFile();
				printCountries(list);
			} else if (inputNum == 2) {
				input = Validator.getString(scan, "What is the name of the country you would like to add?");
				CountriesTextFile.writeToFile(input);
			}else if(inputNum == 3) {
				System.out.println("Good Bye");
			}
		}while(!(inputNum == 3));
	}
	
	public static void printMenu() {
		System.out.println("***********************************");
		System.out.println("1 - List of Countries");
		System.out.println("2 - Add Country");
		System.out.println("3 - Exit");
	}
	
	public static void printCountries(ArrayList<String> list) {
		System.out.println("***********************************");
		for(String country : list) {
			System.out.println(country);
		}
	}
	

}
