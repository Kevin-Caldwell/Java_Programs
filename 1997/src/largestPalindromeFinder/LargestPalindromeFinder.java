/**
 * 
 */
package largestPalindromeFinder;

import java.util.ArrayList;

/**
 * @author Kevin
 *
 */
public class LargestPalindromeFinder implements PalindromeFinder{

	@Override
	public String reverse(String str) {
		String reverse = "";
		
		for(int i = 0; i < str.length(); i++) {
			
			reverse += str.charAt(str.length() - i - 1);
		}
		return reverse;
	}

	@Override
	public boolean isPalindrome(String str) {
		return str.equals(reverse(str)); 
	}

	@Override
	public ArrayList<String> findAllPalindromes(String str) {
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			for(int j = i+1; j < str.length(); j++) {
				if(str.charAt(j) == c) {
					String temp = str.substring(i, j+1);					
					if(isPalindrome(temp)) {
						palindromes.add(temp);
					}
				} else {
				}
			}
		}
		return palindromes;
	}
	
	

}
