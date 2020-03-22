package largestPalindromeFinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
//		String str = "ABCB";
		
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		
		int numberOfStrings = 0;
		try {
			numberOfStrings = Integer.valueOf(scanner.readLine());
		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String[] list = new String[numberOfStrings]; 
		
		for(int i = 0; i < numberOfStrings; i++) {
			try {
				list[i] = scanner.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		LargestPalindromeFinder myFinder = new LargestPalindromeFinder();
		
		for (String test : list) {
			ArrayList<String> palindromes = myFinder.findAllPalindromes(test);
			
			int max = 0;
			int index = 0;
			
			for (String string : palindromes) {
				if(string.length() > max) {
					max = string.length();
					index = palindromes.indexOf(string);
				}
			}
			
			System.out.println(palindromes.get(index));
			System.out.println(max);
		}
		
		try {
			scanner.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
