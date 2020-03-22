package lottery;

public class Lottery {

	public Lottery() {
		
	}
	
	public static String lottery(String input) {
		String temp = "";
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) != ' ') {
				temp += input.charAt(i);
			}
		}
		
		input = temp;
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '/') {
//				int j = i;
//				int k = i;
				while(!(input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || !(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')) {
//					j--;
				}
			}
		}
		return temp;
	}

}
