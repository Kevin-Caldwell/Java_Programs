package nasty_numbers;

public class Test {

	public static void main(String[] args) {
		
		int temp = 0;
		
		for(int i = 1; i < 32001; i++) {
			if((new NastyNumberFinder(i)).isNastyNumber) {
				temp++;
			}
		}
		
		System.out.println(temp);
	}
}
