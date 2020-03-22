package ccc_2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Smile_With_Similies {

	public Smile_With_Similies() {
	}

	public static void main(String[] args) {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

		int n = 0;
		int m = 0;
		
		try {
			n = Integer.parseInt(scanner.readLine());
			m = Integer.parseInt(scanner.readLine());
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}

		String[] Adjectives = new String[n];
		String[] Nouns = new String[m];

		for (int i = 0; i < n; i++) {
			try {
				Adjectives[i] = scanner.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < m; i++) {
			try {
				Nouns[i] = scanner.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.println(Adjectives[i] + " as " + Nouns[j]);
			}
		}
	}

}
