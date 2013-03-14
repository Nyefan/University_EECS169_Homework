/**-------------------------------------------------------------*
 *  File Name: AsciiArt.java                                    |
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Homework Number: 02                                         |
 *  Description: Outputs one of three pre-defined patterns (5x5 |
 *    grid, checker board, or reverse diagonal) at the prompting|
 *    of the user.						|
 *  Last Changed: 7-March-2013					|
 ---------------------------------------------------------------*/
package asciiart;

import java.util.Scanner;
public class AsciiArt {
  public static void main(String[] args) {
    //Initialize necessaries;
    Scanner keyboard01 = new Scanner(System.in);
    boolean isInputValid;

    do {
    promptUser(); //Ask the User what to output;
    isInputValid = parseInput(keyboard01.nextInt()); //Grab input and produce output;
    } while(!isInputValid); //Repeat if parseInput throws and exception;
  }

  public static void promptUser() {
    System.out.println(""
	    + "Choose one of the following patterns by typing the corresponding number: "
	    + "\n1) 5x5 Grid"
	    + "\n2) Checker Board"
	    + "\n3) Reverse Diagonal"
	    + "");//\n
  }

  public static boolean parseInput(int input) {
    if(input == 1) {fiveByFiveGrid(); return true;}
    else if(input == 2) {checkerBoard(); return true;}
    else if(input == 3) {reverseDiagonal(); return true;}
    else { //Throw an exception;
      System.out.print("That is not a valid selection, please try again.\n\n\n\n");
      return false;
    }
  }

  public static void fiveByFiveGrid() {
    for (byte ii = 0; ii < 5; ii++) { // limitiing values: -128<ii<127
      System.out.print("\n" + ii);
      for (byte jj = 0; jj < 5; jj++) { // limitiing values: -128<jj<127
	System.out.print(" *");
      }
    }
  }

  public static void checkerBoard() {
    for (byte ii = 0; ii < 5; ii++) { // limitiing values: -128<ii<127
      System.out.print(ii);
      if(ii%2 == 0) {System.out.print(" *");}
      System.out.println("   *   *");
    }
  }


  public static void reverseDiagonal() {
    for (byte ii = 5; ii >0; ii--) { // limitiing values: -128<ii<127
      System.out.print("\n" + (5-ii));
      for (byte jj = 1; jj < ii; jj++) { // limitiing values: -128<jj<127
	System.out.print("  ");
      }
      System.out.print(" *");
    }
  }

}
