package largestPalindromeFinder;

import java.util.ArrayList;

public interface PalindromeFinder {
	
	public String reverse(String str);
	
	public boolean isPalindrome(String str);
	
	public ArrayList<String> findAllPalindromes(String str);

}
