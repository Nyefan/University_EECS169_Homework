package fightclub;

import java.util.Scanner;

/*--------------------------------------------------------------*
 *  File Name: FightClub.java					|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Homework Number: 03						|
 *  Description: TODO - WRITE DESCRIPTION OF THE PROGRAM HERE	|
 *  File Created: Apr 10, 2013					|
 *  Last Changed: Apr 12, 2013					|
 ---------------------------------------------------------------*/

/*
 * TODO: find a better way to eliminate the Scanner error that keeps throwing an
 * extra line at the Fighter.input() function on all fighters past the first
 * one;  Elsewise, the program is function perfectly, but it can still be
 * cleaned up;
 */

public class FightClub {

  private static Fighter fighter1 = new Fighter();
  private static Fighter fighter2 = new Fighter();
  private static boolean shouldLoop;
  private static Scanner keyboard01;
  private static int fighters = 0; // Keeps track of the number of Fighter objects that have been initialized;
  private static boolean isInitialGame = true;


  public static void main(String[] args) {
    // Create the first batch of Fighters;
    initialize(fighter1);
    initialize(fighter2);
    // Fight until the user decides to quit;
    do {
      keyboard01 = new Scanner(System.in);
      shouldLoop = playGame();
    } while(shouldLoop);
    keyboard01.close();
  }

  // Prepares Fighters for battle;
  private static void initialize(Fighter fighter) {
    fighters++;
    System.out.printf("\n=============================="
	    + "\nRead fighter%d's information from the keyboard", fighters);
    fighter.input(isInitialGame);
  }
  //
  private static boolean playGame() {
    if (firstHit()) { // firstHit returns true if fighter1 goes first; else false;
      System.out.println(fighter1.getName() + " will attack first.");
      return rounds(fighter1, fighter2);
    }
    else {
      System.out.println(fighter2.getName() + " will attack first.");
      return rounds(fighter2, fighter1);
    }
  }
  // A true return statement tells main to play another game; false exits;
  private static boolean rounds(Fighter first, Fighter second) {

    // Begin for loop; Each Fighter gets 10 alternating turns to destroy their opponent
    for(int turn = 1; turn < 11; turn++) {
      System.out.printf("Round %d: ", turn);

      // If the first fighter wins, ask the user if s/he wants to play again;
      if(first.takeTurn(getTurnType(turn), second)) {
	// If the user would like to play again, set up a new game;
        if(checkShouldLoop()) {
	  isInitialGame = false; // Tells dead Fighter to clear the Scanner buffer;
          initialize(second); // Resets the dead Fighter;
	  first.restoreHP(); // Refreshes the living Fighter;
          return true; // Continue playing;
        }
        else return false; // Exit game;
      }
      // If the second Fighter wins, ask the user if s/he wants to play again;
      else if(second.takeTurn(getTurnType(turn), first)) {
	// If the user would like to play again, set up a new game;
        if(checkShouldLoop()) {
	  isInitialGame = false; //Tells dead Fighter to clear the Scanner buffer;
          initialize(first); // Resets the dead Fighter;
	  second.restoreHP(); // Refreshes the living Fighter;
          return true; // Continue playing;
        }
        else return false; // Exit game;
      }
    }
    // End for loop;

    // If neither Fighter wins, ask the user if s/he wants to play again;
    System.out.println("Time has run out.  The fight is a tie!");
    // If the user would like to play again, set up a new game;
    if(checkShouldLoop()) {
      // Refreshes the Fighters;
      first.restoreHP();
      second.restoreHP();
      return true; // Continue playing;
    }
    else return false; // Exit game;

  }

  // Functions written to clean up rounds();
  // Asks the user what type of move they would like to take;
  private static char getTurnType(int turn) {
    System.out.println("Please select an action...");
    if(turn == 1) {
      System.out.println("'H' or 'h' for Haste"
              + "\n'S' or 's' for Spirit Guard"
              + "\n'A' or 'a' to Attack");
    }
    return keyboard01.nextLine().charAt(0);
  }
  // Determines which of the current Fighters gets to attack first;  Preference
  // is given to the Fighter with the higher attackSpeed;  Because
  // Fighter.rollAttack() returns a double, the elif(f2a>f1a) could be replaced
  // by "else return false;", removing the "else return firstHit();" statement;
  private static boolean firstHit() {
    double f1a = fighter1.rollAttack();
    double f2a = fighter2.rollAttack();
    if(f1a > f2a) {
      return true; //true is read as "fighter1 goes first";
    }
    else if(f2a > f1a) {
      return false; //false is read as "fighter2 goes first";
    }
    else return firstHit();
  }

  //Asks the user if they would like to play again;
  private static boolean checkShouldLoop() { // Note[01];
    System.out.print("\nThat was fun! Do you want to play again?"
	    + "\nPlease enter 1 for Yes, 0 for No: ");
    //Grab the first character of the user's response for if/else checking
    char chkChar = keyboard01.next().charAt(0);

    if (chkChar == '1' || chkChar == 'y' || chkChar == 'Y') {
      return true;}
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

/**--------------------------------NOTES----------------------------------------
 * 
 */

