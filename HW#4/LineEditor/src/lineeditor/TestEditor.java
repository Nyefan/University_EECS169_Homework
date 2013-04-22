package lineeditor;

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

public class TestEditor {
    private static final int maxLength = 10; // Formatted this way for the sake of debugging;
    private static Scanner keyboard01 = new Scanner(System.in);
    private static boolean shouldLoop = true;
    private static LineEditor Editor = new LineEditor(maxLength);
    
    public static void main(String[] args) {
        System.out.println("+++++++ LineEditor starts... +++++++");
        initialize();
        printCurrentLine();
        while(shouldLoop){
            menu();
        }
        
    }
    
    private static void initialize() {
        System.out.println("\n* Write the text you want (maximum length: " + maxLength + "):");
        String textString = keyboard01.nextLine();
        
        if (textString.length() > maxLength) {
            catchLengthException();
            initialize();
        }
        else {
            Editor.insert_text(textString.toCharArray(), 0) ;
        }
    }
    
    private static void menu() {
        System.out.println("\n----------------------------------------"
                + "\n"
                + "\n*Choose an editing option:"
                + "\n1. Insert"
                + "\n2. Delete"
                + "\n3. Replace"
                + "\n4. Quit"
                + "\n");
        int userInput = keyboard01.nextInt();
        
        if(userInput == 1) {insert();}
        else if(userInput == 2) {delete();}
        else if(userInput == 3) {replace();}
        else if(userInput == 4) {quit();}
        else {
            System.out.println("\nThat is not a valid selection.  Please try again.");
        }
    }
    
    private static void insert() {
        System.out.println("\n* Enter the starting position:");
        int startingPosition = keyboard01.nextInt();
        System.out.println("\n* Enter the text you would like to insert:");
        char[] insertion = keyboard01.next().toCharArray();
        
        if(Editor.insert_text(insertion, startingPosition-1)) {
            printCurrentLine();
        }
        else {
            catchLengthException();
        }
    }
    
    private static void delete() {
        System.out.println("\n* Enter the starting and ending position for deletion:");
        int startingPosition = keyboard01.nextInt();
        int endingPosition = keyboard01.nextInt();
        
        if(Editor.delete_text(startingPosition-1, endingPosition)) {
            printCurrentLine();
        }
        else {
            catchLengthException();
        }
    }
    
    private static void replace() {
        System.out.println("\n* Enter the starting and ending position for deletion:");
        int startingPosition = keyboard01.nextInt();
        int endingPosition = keyboard01.nextInt();
        System.out.println("\n* Enter the text you would like to insert in its place:");
        char[] insertion = keyboard01.next().toCharArray();
        
        if(Editor.replace_text(insertion, startingPosition-1, endingPosition)) {
            printCurrentLine();
        }
        else {
            catchLengthException();
        }
    }
    
    private static void quit() {
        shouldLoop = false;
        System.out.println("Goodbye!");
    }
    
    private static void printCurrentLine() {
        System.out.println("\n" + new String(Editor.getText()));
    }
    
    private static void catchLengthException() {
        System.out.println("\n* Operation failed: You exceeded the maximum length.");
    }
}

/**--------------------------------NOTES----------------------------------------
 * 
 */