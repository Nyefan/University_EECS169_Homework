package fightclub;

import java.util.Random;
import java.util.Scanner;

/*--------------------------------------------------------------*
 *  File Name: Fighter.java					|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Homework Number: 03						|
 *  Description: TODO - WRITE DESCRIPTION OF THE PROGRAM HERE	|
 *  File Created: Apr 6, 2013					|
 *  Last Changed: Apr 6, 2013					|
 ---------------------------------------------------------------*/

public class Fighter {
  private String name;
  private int hitpoints;
  private int defenseLevel;
  private int attackSpeed;
  private Random random = new Random();
  private boolean shouldLoop = false;
  private static Scanner keyboard01 = new Scanner(System.in);

  public void input() {
    askName();
    askHP();
    askASandDL();
  }

  private void askName() {
    System.out.print("\nPlease give a name for fighter: ");
    name = keyboard01.nextLine();
  }
  private void askHP() {
    do{
      System.out.print("\nHow many hitpoints does the fighter have? ");
      hitpoints = keyboard01.nextInt();
      if(hitpoints < 1 || hitpoints > 50) {
	System.out.print("\nThe fighter's hitpoints must be between 1 and 50 (inclusive)"
		+ "\nPlease try again...");
	shouldLoop = true;
      }
      else {shouldLoop = false;}
    } while(shouldLoop);
    shouldLoop = false;
  }
  private void askASandDL() {
    do{
      askAS();
      askDL();
      if(attackSpeed + defenseLevel > 50){
	System.out.print("\nThe fighter's attack speed + defense level must be less than 50."
		+ "\nPlease try again...");
	shouldLoop = true;
      }
    } while(shouldLoop);
    shouldLoop = false;
  }
  private void askAS() {
    do {
      System.out.print("\nWhat is the attack speed of the fighter? ");
      attackSpeed = keyboard01.nextInt();
      if(attackSpeed < 1) {
	System.out.print("\nThe fighter's attack speed must be at least 1."
		+ "\nPlease try again...");
	shouldLoop = true;
      }
      else {shouldLoop = false;}
    } while(shouldLoop);
    shouldLoop = false;
  }
  private void askDL() {
    do {
      System.out.print("\nWhat is the defense level of the fighter? ");
      defenseLevel = keyboard01.nextInt();
      if(defenseLevel < 1) {
	System.out.print("\nThe fighter's defense level must be at least 1."
		+ "\nPlease try again...");
	shouldLoop = true;
      }
    } while(shouldLoop);
    shouldLoop = false;
  }

  public boolean takeTurn(char turnType, Fighter opponent) { //TODO: System.out.print statements describing action
    if(turnType == 'a' || turnType == 'A') {
      return magAS();
    }
    else if(turnType == 'd' || turnType == 'D') {
      return magDL();
    }
    else {
      return attack(opponent);
    }
  }
  private boolean attack(Fighter opponent) {
    double att = rollAttack();
    double oppdef = opponent.rollDefense();

    if(att < oppdef) {return false;}
    else {
      opponent.hitFor( rollAttack() ); //TODO: round up rollAttack's return value;
      if(opponent.getHP() <= 0) {return true;}
      else {return false;}
    }
  }

  private boolean magAS() {
    attackSpeed++; return false;
  }

  private boolean magDL() {
    defenseLevel++; return false;
  }

  private double rollAttack() {
    return random.nextDouble() * attackSpeed;
  }
  public double rollDefense() {
    return random.nextDouble() * defenseLevel;
  }
  public void hitFor(int points) {
    hitpoints -= points;
  }
  public int getHP() {
    return hitpoints;
  }

}