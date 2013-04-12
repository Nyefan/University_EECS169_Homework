package fightclub;

//import java.io.IOException; // Required for one of the Scanner cleaners that didn't work;
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
 *  Last Changed: Apr 12, 2013					|
 ---------------------------------------------------------------*/

public class Fighter {
  private String name;
  private int hitpoints; //Fighter's current hitpoints;
  private int maxHitpoints;
  private int defenseLevel;
  private int attackSpeed;
  private Random random = new Random();
  private Scanner keyboard01 = new Scanner(System.in);

  /*
   * Overloaded input function;
   * input() always initiallizes a new Scanner object to ensure hangovers in the
   *   System.in buffer don't compromise the program;
   * input(boolean isInitial) only creates a new Scanner if the Fighter has not
   *   participated in any precious fights;
   */
  public void input() {
    /* Attempts to clean up the System.in buffer without creating a new Scanner;
     * throws IOException {
     * while(System.in.read()!= -1){}
     * while(keyboard01.hasNextLine()){keyboard01.nextLine();}
     * while(keyboard01.hasNext()) {keyboard01.nextLine();}
     * if(System.in.read() != -1){}
     * if(keyboard01.hasNextLine()){keyboard01.nextLine();}
     * keyboard01 = keyboard01.reset();
     */
    keyboard01 = new Scanner(System.in); // Ensures the integrity of the System.in buffer;
    askName(); // Requests a name for the Fighter;
    askHP(); // Requests appropriate maxHitpoints;
    askASandDL(); // Requests appropriate attackSpeed and defenseLevel;
  }
  public void input(boolean isInitial) {
    if(!isInitial) {keyboard01 = new Scanner(System.in);} // Ensures the integrity of the System.in buffer;
    // System.out.print("\n" + isInitial);  // Used for debugging;
    askName(); // Requests a name for the Fighter;
    askHP(); // Requests appropriate maxHitpoints;
    askASandDL(); // Requests appropriate attackSpeed and defenseLevel;
  }
  //Functions written to clean up the input function;
  private void askName() { // Requests this.name;
    System.out.print("\nPlease give a name for fighter: ");
    name = keyboard01.nextLine();
  }
  private void askHP() { // Requires that 0 < maxHitpoints <= 50;
    System.out.print("How many hitpoints does the fighter have? ");
    maxHitpoints = keyboard01.nextInt();
    if(maxHitpoints < 1 || maxHitpoints > 50) {
      System.out.println("The fighter's hitpoints must be between 1 and 50 (inclusive)"
	      + "\nPlease try again...");
      askHP();
    }
    else {hitpoints = maxHitpoints;}
  }
  private void askASandDL() { // Requires that AS + DL <= 50;
    askAS(); // Requests appropriate attackSpeed;
    askDL(); // Requests appropriate attackSpeed;
    if(attackSpeed + defenseLevel > 50){
      System.out.println("The fighter's attack speed + defense level must be less than 50."
	      + "\nPlease try again...");
      askASandDL();
    }
  }
  private void askAS() { // Requires that 0 < attackSpeed < 50;
    System.out.print("What is the attack speed of the fighter? ");
    attackSpeed = keyboard01.nextInt();
    if(attackSpeed < 1) {
      System.out.println("The fighter's attack speed must be at least 1."
	      + "\nPlease try again...");
      askAS();
    }
    else if (attackSpeed > 50) {
      System.out.println("The fighter's attack speed cannot exceed 50."
	      + "\nPlease try again...");
      askAS();
    }
  }
  private void askDL() { // Requires that 0 < defenseLevel < 50;
    System.out.print("What is the defense level of the fighter? ");
    defenseLevel = keyboard01.nextInt();
    if(defenseLevel < 1) {
      System.out.println("\nThe fighter's defense level must be at least 1."
	      + "\nPlease try again...");
      askDL();
    }
    else if (defenseLevel > 50) {
      System.out.println("The fighter's defense level cannot exceed 50."
	      + "\nPlease try again...");
      askDL();
    }
  }

  /* Handles each Fighter's turn; Each turn the Fighter can do one of three
   * things, as instructed by the user:
   *   1. Cast Haste, increasing attackSpeed by 1;
   *   2. Cast Spirit Guard, increasing defenseLevel by 1;
   *   3. Attack the opponent;
   * Note that Haste and Spirit guard CAN increase AS + DL beyond the initial
   * 50 point limit;
   * Returns true if Fighter defeated opponent; else false;
   */
  public boolean takeTurn(char turnType, Fighter opponent) {
    if(turnType == 'h' || turnType == 'H') {
      System.out.println(name + " has cast Haste, increasing his attack speed by one!");
      haste();
      return false; // Opponent yet lives;
    }
    else if(turnType == 's' || turnType == 'S') {
      System.out.println(name + " has cast Spirit Guard, increasing his defense level by one!");
      spiritGuard();
      return false; // Opponent yet lives;
    }
    else {
      return attack(opponent);
    }
  }
  // Functions called exclusively by takeTurn;
  /* Handles an attack against this Fighter's opponent; Returns true if opponent
   * has been defeated; else false;
   */
  private boolean attack(Fighter opponent) {
    // If Fighter rolls a higher AS than opponent rolls DL, hit opponent for an
    // amount determined by a new attack roll;
    if(rollAttack() > opponent.rollDefense()) {
      System.out.println(name + " hits " + opponent.name + " for "
              + opponent.hitFor( (int) rollAttack() + 1 ) // rounds up rollAttack's return value
              + " points!  " + opponent.name + " has " + opponent.hitpoints + " HP remaining.");
      if(opponent.hitpoints <= 0) {return true;} // The opponent has fallen;
      else {return false;} // The opponent yet lives;
    }
    // Else, Fighter misses opponent;
    else {
      System.out.println(name + " misses " + opponent.name + ".");
      return false;  // the opponent yet lives;
    }
  }
  private boolean haste() {
    attackSpeed++; return false;
  }
  private boolean spiritGuard() {
    defenseLevel++; return false;
  }

  //Extraneous public functions
  public double rollAttack() {
    return random.nextDouble() * attackSpeed;
  }
  public double rollDefense() {
    return random.nextDouble() * defenseLevel;
  }
  public int hitFor(int points) {
    if (points < hitpoints) {
      hitpoints -= points;
    }
    else hitpoints = 0; // Ensure HP never falls below 0;
    return points;
  }
  public int getHP() {
    return hitpoints;
  }
  public void restoreHP( ) {
    hitpoints = maxHitpoints;
  }
  public String getName() {
    return name;
  }

}