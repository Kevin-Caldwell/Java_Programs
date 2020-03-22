package sentences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numberOfDataSets = 0;
		int numberOfSubjects = 0;
		int numberOfVerbs = 0;
		int numberOfObjects = 0;
		
		try {
			numberOfDataSets = Integer.valueOf(reader.readLine());
			numberOfSubjects = Integer.valueOf(reader.readLine());
			numberOfVerbs = Integer.valueOf(reader.readLine());
			numberOfObjects = Integer.valueOf(reader.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		String[] Subjects = new String[numberOfSubjects];
		String[] Verbs = new String[numberOfVerbs];
		String[] Objects = new String[numberOfObjects];
		
		for(int i = 0; i < numberOfDataSets;  i++) {
			for(int k = 0; k < numberOfSubjects; k++) {
				try {
					Subjects[k] = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			for(int k = 0; k < numberOfVerbs; k++) {
				try {
					Verbs[k] = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			for(int k = 0; k < numberOfObjects; k++) {
				try {
					Objects[k] = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			String[] result = (new SentenceConstructor(Subjects, Verbs, Objects)).getAllPossibleSentences();
			
			printStringArray(result);
			
			
		}

	}
	
	public static void printStringArray(String[] arr) {
		for (String var : arr) {
			System.out.println(var);
		}
	}

}
