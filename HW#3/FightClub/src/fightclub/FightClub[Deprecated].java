/*package fightclub;

import java.util.Scanner;

/*--------------------------------------------------------------*
 *  File Name: FightClub.[Deprecated]java					|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Homework Number: 03						|
 *  Description: TODO - WRITE DESCRIPTION OF THE PROGRAM HERE	|
 *  File Created: Apr 6, 2013					|
 *  Last Changed: Apr 8, 2013					|
 ---------------------------------------------------------------*/
/*
public class FightClubDeprecated {
  private static int turn;
  private static Fighter fighter1;
  private static Fighter fighter2;
  private static Fighter firstHitter;
  private static Fighter secondHitter;
  private static boolean shouldLoop;
  private static Scanner keyboard01 = new Scanner(System.in);
  private static int fighters = 1;

  public static void main(String[] args) {
    initialize(fighter1);
    initialize(fighter2);
    do {
      shouldLoop = play();
    } while(shouldLoop);

  }

  public static void initialize(Fighter fighter) {
    System.out.printf("=============================="
	    + "\nRead fighter%d's information form the keyboard", fighters);
    fighter.input();
    fighters++;
  }

  public static boolean play() { //TODO: make first hit work properly;
    System.out.println(firstHit().getName() + " will attack first.");

    for(turn = 0; turn < 10; turn++) {
      System.out.printf("Round %d:", turn);

      if(fighter1.takeTurn(getTurnType(), fighter2)) {
        turn = 0;
        if(checkShouldLoop()) {
          initialize(fighter2);
	  fighter1.restoreHP();
          return true;
        }
        else return false;
      }

      else if(fighter2.takeTurn(getTurnType(), fighter1)) {
        turn = 0;
        if(checkShouldLoop()) {
          initialize(fighter1);
	  fighter2.restoreHP();
          return true;
        }
        else return false;
      }
    }

    System.out.println("Time has run out.  The fight is a tie!");
    if(checkShouldLoop()) {
      fighter1.restoreHP();
      fighter2.restoreHP();
      return true;
    }
    else return false;

  }

  public static char getTurnType() {
    System.out.println("Please select an action...");
    if(turn == 0) {
      System.out.println("'H' or 'h' for Haste"
              + "\n'S' or 's' for Spirit Guard"
              + "\n'A' or 'a' to Attack");
    }
    return keyboard01.nextLine().charAt(0);
  }

  public static void firstHit() {
    double f1a = fighter1.rollAttack();
    double f2a = fighter2.rollAttack();
    if(f1a > f2a) {
      firstHitter =  fighter1;
      secondHitter = fighter2;
    }
    else if(f2a > f1a) {
      firstHitter =  fighter2;
      secondHitter = fighter1;
    }
    else return firstHit();
  }

  private static boolean checkShouldLoop() { // Note[01];
    System.out.print("\nDo you want to try another ball?"
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
}*/