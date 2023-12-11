package Labs;

import java.util.*;

class Main {
  
  static Scanner s = new Scanner(System.in);
  
  public static void main(String[] args) {
        
    System.out.println("Would you like to (E)ncrypt or (D)ecrypt a message?");
    boolean doEncrypt = getEorD().equals("E");
    
    System.out.println("Enter your shift value: ");
    int shift = getShift();
    
    System.out.println("Enter your message: ");
    String message = s.nextLine();
    
    System.out.printf("Your %s message is: %n%s%n", 
                      doEncrypt ? "encrypted" : "decrypted", 
                      shiftMessage(message, shift, doEncrypt));
  }
  
  public static String shiftMessage(String message, int shift, boolean doEncrypt) {
    StringBuilder sb = new StringBuilder();
    // StringBuilder is a tool that helps build a more custom string. 

    // This method takes the <message> parameter you input and shifts it according to the <shift> parameter. 

    // If the program is meant to encrypt, then <doEncrypt> is true, 
    // and you should shift every letter in <message> FORWARDS <shift> letters.

    // If the program is meant to decrypt, then <doEncrypt> is false, 
    // and you should shift every letter in <message> BACKWARDS <shift> letters. 

    // Iterate through each character in the input message
    for (char c : message.toCharArray()) {
      // Check if the character is a letter
      if (Character.isLetter(c)) {
        // Determine the shift direction based on encryption or decryption
        int shiftDirection = doEncrypt ? 1 : -1;
        // Shift the character by the specified amount
        char shiftedChar = (char) ('A' + (c - 'A' + shiftDirection * shift + 26) % 26);
        // Append the shifted character to the result
        sb.append(shiftedChar);
      } else {
        // If the character is not a letter, append it as it is
        sb.append(c);
      }
    }
    return sb.toString();
  }
  
  public static int getShift() {
    // Data validation: 
    // This method should return an integer between -25 and 25, inclusive.
    int shift;
    while (true) {
      // Read user input
      String input = s.nextLine();
      try {
        // Try to parse the input as an integer
        shift = Integer.parseInt(input);
        // Check if the integer is within the valid range
        if (shift >= -25 && shift <= 25) {
          break;  // Exit the loop if the input is valid
        } else {
          // Ask the user to enter a valid shift value
          System.out.println("Please enter a shift value between -25 and 25: ");
        }
      } catch (NumberFormatException e) {
        // Handle the case where the input is not a valid integer
        System.out.println("Please enter a valid integer: ");
      }
    }
    return shift;
  }
  
  public static String getEorD() {
    // Data Validation:
    // This method should return either "E" or "D". 
    // The main method asks whether they want to (e)ncrypt or (d)ecrypt, 
    // and this method validates that they input either "E" or "D" properly. 
    // You should accept either uppercase or lowercase e/d, 
    // but they should enter only one letter, otherwise have them input again. 
    String input;
    while (true) {
      // Read user input
      input = s.nextLine().toUpperCase();
      // Check if the input is a single letter "E" or "D"
      if (input.length() == 1 && (input.equals("E") || input.equals("D"))) {
        break;  // Exit the loop if the input is valid
      } else {
        // Ask the user to enter a valid option
        System.out.println("Please enter either 'E' or 'D': ");
      }
    }
    return input;
  }
}