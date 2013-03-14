/*--------------------------------------------------------------*
 *  File Name: PrintCostCalculator.java				|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Homework Assignment Number: 1				|
 *  Description: Computes the cost of printing a number of pages|
 *      of text, image, compressed text, or statements based on	|
 *	estimated dots per page, number of pages, print type, 	|
 *	color scheme, the cose of ink, the existence of a sale,	|
 *	and 0.72% sales	tax.					|
 *  Last Changed: 15-February-2013				|
---------------------------------------------------------------*/
import java.util.Scanner;
public class PrintCostCalculator {
  private static Scanner keyboard;
  	public static void main(String[] args) {


      //Initializes several variables and the user input
  	  int kdpp; 												//kilodots per page;
  	  double cpp; 												//cost per page;
  	  keyboard = new Scanner(System.in);


  	  //Requests and declares the number of pages to be printed;
  	  System.out.print(
    		" --- Price Estimator Program ---\n" +
    		"Enter Number of Pages (digits only): ");
  	  int NumberPages = keyboard.nextInt();
  	  //NumberPages = NumberPages - NumberPages%1;				//from an older iteration
  	  //System.out.print(NumberPages); 							//debugging


  	  //Requests and declares the PrintType;
  	  System.out.print(
    		"\n\n" +
    		"---- Select a Print Type ----\n" +
    		"Enter T or t for Text\n" +
    		"Enter I or i for Image\n" +
    		"Enter C or c for Compressed Text\n" +
    		"Enter S or s for Statement\n" +
    		"-----------------------------\n" +
    		"Enter Print Type: ");
  	  String inputcharacter = keyboard.next();
  	  char TempVar = inputcharacter.charAt(0);
  	  //System.out.print(TempVar); 								//debugging


  	  //Determines ink usage based on PrintType, defaulting to text;
  	  if(TempVar == 'T' || TempVar == 't') {kdpp = 5;}
  	  else if(TempVar == 'I' || TempVar == 'i') {kdpp = 10;}
  	  else if(TempVar == 'C' || TempVar == 'c') {kdpp = 15;}
  	  else if(TempVar == 'S' || TempVar == 's') {kdpp = 7;}
  	  else {
  		  kdpp = 5;
  		  System.out.println(
    			"Invalid entry for Print Type.\n" +
    			"Print Type set to Text.");
  	  }


  	  //Requests and declares the PrintColorScheme, defaulting to Color;
  	  System.out.print("\n\n" +
    		"--- Select a Print Color ---\n" +
    		"Enter 0 for Grayscale\n" +
    		"Enter 1 for Color\n" +
    		"-----------------------------\n" +
    		"Enter Print Color: ");
  	  //int PrintColorScheme = keyboard.nextInt(); 				//from an older iteration
  	  //if (PrintColorCheme == 0) {cpp = kdpp*0.05;} 			//with an extra assignment
  	  if (keyboard.nextInt() == 0) {cpp = kdpp*0.01;}
  	  else {cpp = kdpp*0.05;}
  	  //System.out.print(cpp); 									//debugging


  	  //Requests and declares the existence of a sale;
  	  System.out.print("\n" +
    		"-----------------------------\n" +
    		"Is there a sale (y/n): ");
  	  inputcharacter = keyboard.next();
  	  //System.out.print("\ninput successful");					//debugging
  	  TempVar = inputcharacter.charAt(0);
  	  //System.out.print("\ncasting successful");				//debugging
  	  if((TempVar == 'y' || TempVar == 'Y') && NumberPages >= 200) {cpp = 0.5*cpp;}
  	  //System.out.print("\ncomparison successful");			//debugging

  	  //Calculates cost based on user inputs;
  	  int dpp = 1000*kdpp; 										//dots per page
  	  double TotalInkDots = dpp*NumberPages;
  	  double Subtotal = cpp*NumberPages;
  	  double Tax = 0.0072*Subtotal;
  	  double Total = Subtotal + Tax;
  	  //System.out.print("\ncalculations successful");			//debugging
  	  System.out.println("\n\n--- Cost Estimate ---");
  	  System.out.printf("Ink Usage Per Page: %d", dpp);
  	  System.out.printf("\nTotal Ink Usage: %.2e", TotalInkDots);
  	  System.out.printf("\n\nEstimated Cost Per Page: $%.4f", cpp);
  	  System.out.printf("\nSubtotal: $%.2f", Subtotal);
  	  System.out.printf("\nTax @ 0.72%%: $%.2f", Tax);
  	  System.out.printf("\nTotal Cost: $%.2f", Total);
  	}
}