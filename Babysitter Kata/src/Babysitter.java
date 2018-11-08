import java.util.Scanner;

public class Babysitter {

	public static void main(String[] args) {
		TimeAnalyzer timeAnalyzer = new TimeAnalyzer();
		Scanner in = new Scanner(System.in);
	
		System.out.print("Enter the start time in following format '#:##' followed by a space and either PM OR AM: ");
		String userInput = in.nextLine();
		String startTime = timeAnalyzer.properTimeInputs(userInput);
		while(startTime == null) {
			System.out.print("Enter the start time in following format '#:##' followed by a space and either PM OR AM: ");
			userInput = in.nextLine();
			startTime = timeAnalyzer.properTimeInputs(userInput);
		}
		
		
	}

}

