package fightclub;

import java.util.Scanner;

/*--------------------------------------------------------------*
 *  File Name: FightClub.java					|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Homework Number: 03						|
 *  Description: TODO - WRITE DESCRIPTION OF THE PROGRAM HERE	|
 *  File Created: Apr 6, 2013					|
 *  Last Changed: Apr 6, 2013					|
 ---------------------------------------------------------------*/

public class FightClub {
  private static int turns;
  private static Fighter fighter1;
  private static Fighter fighter2;
  private static boolean shouldLoop;
  private static Scanner keyboard01 = new Scanner(System.in);
  private static int fighters = 1;

  public static void main(String[] args) {
    initialize(fighter1);
    initialize(fighter2);
    do {
      play();
      shouldLoop = checkShouldLoop();
    } while(shouldLoop);

  }

  public static void initialize(Fighter fighter) {
    System.out.printf("=============================="
	    + "\nRead fighter%d's information form the keyboard", fighters);
    fighter.input();
    fighters++;
  }

  public static void play() {

    fighter1.takeTurn(getTurnType());
    fighter2.takeTurn(getTurnType());

    turns++;

  }

  public static int getTurnType() {

  }

  private static boolean checkShouldLoop() { // Note[01];
    System.out.print("\nDo you want to try another ball?"
	    + "\nPlease enter 1 for Yes, 0 for No: ");
    //Grab the first character of the user's response for if/else checking
    char chkChar = keyboard01.next().charAt(0);

    if (chkChar == '1' || chkChar == 'y' || chkChar == 'Y') {return true;}
    else if (chkChar == '0' || chkChar == 'n' || chkChar == 'N') {
      System.out.println("\nGoodbye!");
      return false;
    }
    else {
      System.out.println("That was an invalid selection; please try again!");
      return checkShouldLoop();
    }
  }
}