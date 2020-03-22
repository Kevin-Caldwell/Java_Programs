package nasty_numbers;

import java.util.ArrayList;

public class NastyNumberFinder {
	
	public int number;
	
	ArrayList<Integer> factors;
	
	public boolean isNastyNumber;
	
	public NastyNumberFinder(int number) {
		this.number = number;
		factors = setFactors(number);
		isNastyNumber = NastyNumber(factors);
		
	}
	
	public ArrayList<Integer> setFactors(int number) {
		
		ArrayList<Integer> factor = new ArrayList<Integer>();
		
		for(int i = 1; i <= number; i++) {
			if(number % i == 0) factor.add(i);
		}
		
		return factor;
	}
	
	public boolean NastyNumber(ArrayList<Integer> factors) {
		
		boolean nastyNumber = false;
		
		for(int i = 0; i < factors.size(); i++) {
			
			for(int j = 0; j < factors.size(); j++) {
				
				for(int k = 0; k < factors.size(); k++) {
					
					for(int l = 0; l < factors.size(); l++) {
						
						if(isNastyNumber(factors.get(i), factors.get(j), factors.get(k), factors.get(l))) {
							nastyNumber = true;
							
						}
						
					}
				}
			}
		}
		
		return nastyNumber;
	}
	
	public boolean isNastyNumber(int diff0, int diff1, int sum0, int sum1) {
		
		int diff = diff1 - diff0;
		int sum = sum1 + sum0;
		
		if(diff < 0) diff *= -1;
		
		if(((diff0 != diff1) & (sum0 != sum1)) & (diff == sum)) {
			return true;
		} else {
			return false;
		}
	}

}
