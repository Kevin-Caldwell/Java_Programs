package CCC_2002;

import java.util.Scanner;

public class AmeriCanadian {

	public AmeriCanadian() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getCanadian(String American) {
		
		
		if(American.length() >= 4 && American.substring(American.length()-2, American.length()).toLowerCase().equals("or")) {
			
			return American.substring(0, American.length()-2).concat("our");
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter words to be translated: ");
		
		String american = "";
		
		do {
			if(getCanadian(american)==null) {
				System.out.println(american);
			} else {
				System.out.println(getCanadian(american));
			}
			
			american = scanner.nextLine();
		} while (!american.equals("quit!"));
		
		scanner.close();
	}

}
