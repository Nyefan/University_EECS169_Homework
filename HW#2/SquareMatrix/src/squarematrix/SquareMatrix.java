/**-------------------------------------------------------------*
 *  File Name: SquareMatrix.java				|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Homework Number: 02						|
 *  Description: Outputs a square matrix of user input size	|
 *    inputSize and its inverse.  The initial matrix consists of|
 *    integers arranged in ascending order first from left to	|
 *    right and then from top to bottom, while the inverse's	|
 *    components are arranged first from top to bottom, and then|
 *    from left to right.					|
 *  Last Changed: 13-March-2013					|
 ---------------------------------------------------------------*/
package squarematrix;

import java.util.Scanner;

public class SquareMatrix {

  public static void main(String[] args) {
//    Initialize Necessaries
    Scanner keyboard01 = new Scanner(System.in);

    askMatrixSize(); // Ask the User what size Matrix to Print;
    printMatrices(keyboard01.nextInt()); //Receive the User's input, and Print out the Square Matrix and its Inverse;
  }

  public static void askMatrixSize() {
    System.out.println("Enter the Size of the Square Matrix:");
  }

  public static void printMatrices(int inputVar) {
//    Print the Square Matrix;
    System.out.println("Square Matrix:");
    for(int ii = 0 ; ii < inputVar; ii++) {
      for(int jj = 1; jj <= inputVar; jj++) {
	System.out.printf("%4d ",ii*inputVar+jj);
      }
      System.out.println("");
    }
//    Print the Inverse Matrix;
    System.out.println("Transpose:");
    for(int ii = 1; ii <= inputVar; ii++) {
      for(int jj = 0; jj < inputVar; jj++) {
	System.out.printf("%4d ",(ii + jj*inputVar));
      }
      System.out.println("");
    }
  }
}
