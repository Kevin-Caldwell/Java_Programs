package CCC_2002;

import java.util.Scanner;

public class Prob_1 {
	
//	1	2
//	* * *	5
//	*	*
//	*	*
//	* * *	6
//	*	*
//	*	*
//	*	*
//	* * *	7
//	3	4

	static String[][][] arr = {
						{	
							{"         "},
							{"         "},
							{"         "},
							{"         "},
							{"         "},
							{"         "}, 
							{"         "},
							{"         "},
							{"         "}},{
							
							{"         "},
							{"        *"},
							{"        *"},
							{"        *"},
							{"         "},
							{"        *"}, 
							{"        *"},
							{"        *"},
							{"         "}},{
								
							{"  * * *  "},
							{"        *"},
							{"        *"},
							{"        *"},
							{"  * * *  "},
							{"*        "}, 
							{"*        "},
							{"*        "},
							{"  * * *  "}},{

										
							{"  * * *  "},
							{"        *"},
							{"        *"},
							{"        *"},
							{"  * * *  "},
							{"        *"}, 
							{"        *"},
							{"        *"},
							{"  * * *  "}},{
								
							{"         "},
							{"*       *"},
							{"*       *"},
							{"*       *"},
							{"  * * *  "},
							{"        *"}, 
							{"        *"},
							{"        *"},
							{"         "}},{
								
							{"  * * *  "},
							{"*        "},
							{"*        "},
							{"*        "},
							{"  * * *  "},
							{"        *"}, 
							{"        *"},
							{"        *"},
							{"  * * *  "}},{
							
							{"  * * *  "},
							{"*        "},
							{"*        "},
							{"*        "},
							{"  * * *  "},
							{"*       *"}, 
							{"*       *"},
							{"*       *"},
							{"  * * *  "}},{
										
							{"  * * *  "},
							{"        *"},
							{"        *"},
							{"        *"},
							{"         "},
							{"        *"}, 
							{"        *"},
							{"        *"},
							{"         "}},{
											
							{"  * * *  "},
							{"*       *"},
							{"*       *"},
							{"*       *"},
							{"  * * *  "},
							{"*       *"}, 
							{"*       *"},
							{"*       *"},
							{"  * * *  "}},{
												
							{"  * * *  "},
							{"*       *"},
							{"*       *"},
							{"*       *"},
							{"  * * *  "},
							{"        *"}, 
							{"        *"},
							{"        *"},
							{"  * * *  "}}};

	public Prob_1() {
		// TODO Auto-generated constructor stub
	}
	
	public static void displayDigit(int digit) {
		String[][] DisplayDigit = arr[digit];
		
		for(int i = 0; i < DisplayDigit.length; i++) {
			for(int j = 0; j < DisplayDigit[0].length; j++) {
				System.out.println(DisplayDigit[i][j]);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Enter a digit between 0 and 9");
		Scanner scanner = new Scanner(System.in);
		
		int digit = scanner.nextInt();
		
		displayDigit(digit);
		
		scanner.close();
	}

}
