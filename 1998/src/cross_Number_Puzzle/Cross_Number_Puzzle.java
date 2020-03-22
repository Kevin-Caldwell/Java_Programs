package cross_Number_Puzzle;

public class Cross_Number_Puzzle {

	public Cross_Number_Puzzle() {
		
	}
	
	public static void printPerfectNumbers(int startInt, int endInt) {
		for(int i = startInt; i <= endInt; i++) {
			int sum = 0;
			
			for(int j = 1; j < i; j++) {
				if(i % j == 0) {
					sum += j;
				}
			}
			
			if(sum == i) {
				System.out.println(i);
			}
		}
	}
	
	public static void cubeFunction(int startInt, int endInt) {
		
		for(int i = startInt; i <= endInt; i++) {
			String integer = i + "";
			int sum = 0;
			for (int j = 0; j < integer.length(); j++) {
				int k = Integer.parseInt(integer.substring(j, j+1));
//				System.out.println(k);
				sum += k * k * k;
			}
			
			if(sum == i) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		printPerfectNumbers(1000, 9999);
		cubeFunction(100, 999);
	}

}
