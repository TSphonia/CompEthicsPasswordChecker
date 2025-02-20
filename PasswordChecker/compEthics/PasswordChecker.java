package compEthics;

import java.util.Scanner;

public class PasswordChecker {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String password = input.next();
        
        String specialCharacters = "!@#$%^&*()-+";
        
		// Initialize boolean checks
		boolean containsLowercase = false;
		boolean containsUppercase = false;
		boolean containsSpecialChar = false;
		boolean containsConsecutiveSequence = false;
		boolean isLongEnough = password.length() >= 8;
        boolean containsPassword = password.toLowerCase().contains("password");

        // Check each boolean condition and reassign it
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            
            if (Character.isLowerCase(c)) {
                containsLowercase = true;
            }
            if (Character.isUpperCase(c)) {
                containsUppercase = true;
            }
            if (specialCharacters.contains(String.valueOf(c))) {
                containsSpecialChar = true;
            }
            
            if (i >= 2) {
            	char current = password.charAt(i);
                char prev = password.charAt(i - 1);
                char prevPrev = password.charAt(i - 2);
                
                if (Character.isDigit(current) && Character.isDigit(prev) && Character.isDigit(prevPrev)) {
                    int num1 = Character.getNumericValue(current);
                    int num2 = Character.getNumericValue(prev);
                    int num3 = Character.getNumericValue(prevPrev);

                    if ((num2 == num1 + 1 && num3 == num2 + 1) || (num2 == num1 - 1 && num3 == num2 - 1)) {
                        containsConsecutiveSequence = true;
                    } 
                }
            }
        }

        // Give feedback
        if (!containsUppercase) {
        	System.out.println("Password should contain an uppercase letter.");
        }
        if (!containsLowercase) {
        	System.out.println("Password should contain a lowercase letter.");
        }
        if (!containsSpecialChar) {
        	System.out.println("Password should contain a special character.");
        }
        if (containsConsecutiveSequence) {
        	System.out.println("Password shouldn't consecutive increasing or decreasing numbers.");
        }
        if (!isLongEnough) {
        	System.out.println("Password should be at least 8 characters.");
        }
        if (containsPassword) {
        	System.out.println("Password shouldn't contain the word password.");
        }
        
        if (containsUppercase && 
        		containsLowercase && 
        		containsSpecialChar && 
        		!containsConsecutiveSequence && 
        		isLongEnough && 
        		!containsPassword) {
        	System.out.println("Password is strong.");
        }
        else {
        	System.out.println("Password should be stronger.");
        }
		
		input.close();
	}

}
