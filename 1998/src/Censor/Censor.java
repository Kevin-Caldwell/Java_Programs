package Censor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Censor {

	public static String getCensoredSentence(String str) {
		str += " ";
		String outputString = "";

		String word = "";

		for (int j = 0; j < str.length(); j++) {

			if (!str.substring(j, j + 1).equals(" ")) {
				word = word + str.substring(j, j + 1);

			} else {
				if (word.length() == 4) {
					outputString = outputString + "**** ";
				} else {
					outputString = outputString + word + " ";
				}

				word = "";
			}
		}

		return outputString;
	}

	public static void main(String[] args) {
		int i = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			i = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] output = new String[i];

		for (int j = 0; j < output.length; j++) {
			try {
				output[j] = getCensoredSentence(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (String string : output) {
			System.out.println(string);
		}
		
		
	}

}
