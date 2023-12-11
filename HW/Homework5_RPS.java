package HW;
import java.util.Random;
import java.util.Scanner;
class Homework5_RPS {
public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
    Random r = new Random();
    System.out.println("What do you wanna play: Bo1, Bo3, or Bo4 of RPS?");
}

static void RPS(Scanner s) {
    //input from the user
    System.out.println("Pick a move: ( R / P / S)");
    String move = s.nextLine();
    //input from the computer
    int comNum = r.nextInt(3);
    
}
}