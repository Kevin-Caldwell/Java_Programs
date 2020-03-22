package ccc_2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simple_Encryption_Algorithm {

	public Simple_Encryption_Algorithm() {
	}
	
	public static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	public static int getPos(char a) {
		int pos = 0;
		
		while(pos < alphabet.length && alphabet[pos] != a) {
			pos++;
		}
		
		
		return pos;
		
	}
	
	public static char charShift(char a, int shift) {
		if(getPos(a) + shift < alphabet.length) {
			return alphabet[getPos(a) + shift];
		} else {
			return alphabet[(getPos(a) + shift) % alphabet.length];
		}
		
	}
	
	public static String stringShift(String str, int shift) {
		String shiftedStr = "";
		
		for(int i = 0; i < str.length(); i++) {
			shiftedStr += charShift(str.charAt(i), shift);
		}
		
		return shiftedStr;
	}
	
	public static char[][] setBlockedMessage(String header, String message) {
		
		char[][] blockedMessage;
		
		if(message.length() % header.length() == 0) {
			blockedMessage = new char[(int)(message.length()/header.length())][header.length()];
		} else {
			blockedMessage = new char[1 + (int)(message.length()/header.length())][header.length()];
		}
		
		
		for(int i = 0; i < blockedMessage.length; i++) {
			for(int j = 0; j < blockedMessage[0].length; j++) {
				if(header.length() * i + j < message.length()) {
					blockedMessage[i][j] = message.charAt(header.length() * i + j);
				} else {
					blockedMessage[i][j] = 0;
				}
				
			}
		}
		
		return blockedMessage;
	}
	
	public static char[][] encode(String header, String message) {
		char[][] blockedMessage = setBlockedMessage(header, message);
		
		for(int i = 0; i < blockedMessage.length; i++) {//4
			for(int j = 0; j < blockedMessage[0].length; j++) {//3
				if(blockedMessage[i][j] != 0) {
					blockedMessage[i][j] = charShift(blockedMessage[i][j], getPos(header.charAt(j)));
				}
				
			}
		}
		
		return blockedMessage;
	}
	
	public static void main(String[] args) {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String header = null;
		String message = null;
		
		try {
			header = input.readLine();
			message = input.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		message = message.replaceAll("[^a-zA-Z]", "");
		
		
		char[][] encodedMessage = encode(header, message);
		
		for(int i = 0; i < encodedMessage.length; i++) {
			for(int j = 0; j < encodedMessage[0].length; j++) {
				System.out.print(encodedMessage[i][j]);
			}
		}		
		
	}

}
