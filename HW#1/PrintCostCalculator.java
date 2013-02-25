package printcostcalculator;

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
  public static void main(String[] args) {

    double kdpp; //kilodots per page;
    double cpp; //cost per page;
    Scanner keyboard = new Scanner(System.in);
    //Requests and declares the number of pages to be printed;
    System.out.print(" --- Price Estimator Program ---\nEnter Number of Pages (digits only): ");
    double NumberPages = keyboard.nextInt();
    /*Displays as:
             --- Price Estimator Program ---
            Enter Number of Pages (digits only): []*/		
    //Requests and declares the PrintType;
    System.out.print("\n\n---- Select a Print Type ----\nEnter T or t for Text\nEnter I or i for Image\nEnter C or c for Compressed Text\nEnter S or s for Statement\n-----------------------------\nEnter Print Type: ");
    String inputcharacter = keyboard.next();
    char TempVar = inputcharacter.charAt(0);
        //Determines ink usage based on PrintType;
    if(TempVar == 'T' || TempVar == 't') {kdpp = 5;}
    else if(TempVar == 'I' || TempVar == 'i') {kdpp = 10;}
    else if(TempVar == 'C' || TempVar == 'c') {kdpp = 15;}
    else if(TempVar == 'S' || TempVar == 's') {kdpp = 7;}
    else {kdpp = 5000; System.out.println("Invalid entry for Print Type.\nPrint Type set to Text.\n");}
        /*Displays as:
            ---- Select a Print Type ----
            Enter T or t for Text
            Enter I or i for Image
            Enter C or c for Compressed Text
            Enter S or s for Statement
            -----------------------------
            Enter Print Type: []*/
    //Requests and declares the PrintColorScheme;
    System.out.print("\n\n--- Select a Print Color ---\nEnter 0 for Grayscale\nEnter 1 for Color\n-----------------------------\nEnter Print Color: ");
            /*Displays as:
            --- Select a Print Color ---
            Enter 0 for Grayscale
            Enter 1 for Color
            -----------------------------
            Enter Print Color: []*/
    int PrintColorScheme = keyboard.nextInt();
        if (PrintColorScheme == 0) {cpp = kdpp*0.05;}
        else {cpp = kdpp*0.01;}
    //Requests and declares the existence of a sale;
    System.out.print("\n-----------------------------\nIs there a sale (y/n): ");
    inputcharacter = keyboard.next();
    System.out.print("\ninput successful");
    TempVar = inputcharacter.charAt(0);
    System.out.print("\ncasting successful");
            /*Displays as:
            -----------------------------
            Is there a sale (y/n): []*/
    if(TempVar == 'y' || TempVar == 'Y') {cpp = 0.5*cpp;}
    System.out.print("\ncomparison successful");

//Performs Operations to calculate cost based on user inputs;
   
    double TotalInk = 1000*kdpp*NumberPages;
    double Subtotal = cpp*NumberPages;
    double Tax = 0.0072*Subtotal;
    double Total = Subtotal + Tax;
    System.out.print("\ncalculations successful");
    System.out.printf("\nTotalInk = %2d", TotalInk);
    //Outputs Cost
    System.out.printf("\n\n--- Cost Estimate ---\nInk Usage Per Page: %2e \nTotal Ink Usage: %2d \n\nEstimated Cost Per Page: $%4d \nSubtotal: $%,2d \nTax @ 0.72%: $%2d \nTotal Cost: $%2d", 
    1000*kdpp,TotalInk,cpp,Subtotal,Tax,Total);
  }  
}
    
    
