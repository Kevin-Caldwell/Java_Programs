package sentences;

public class SentenceConstructor {
	
	String[] subjects;
	String[] verbs;
	String[] objects;
	
	public SentenceConstructor(String[] subjects, String[] verbs, String[] objects) {
		this.subjects = subjects;
		this.verbs = verbs;
		this.objects = objects;
	}
	
	public String[] getAllPossibleSentences() {
		String[] allSentences = new String[subjects.length * verbs.length * objects.length];
		int counter = 0;
		
		for(int i = 0; i < subjects.length; i++) {
			
			for(int j = 0; j < verbs.length; j++) {
				
				for(int k = 0; k < objects.length; k++) {
					
					allSentences[counter] = subjects[i] + " " + verbs[j] + " " + objects[k] + ".";
					
					counter++;
				}
			}
		}
		
		return allSentences;
	}

}
