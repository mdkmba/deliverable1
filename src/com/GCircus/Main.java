package com.GCircus;

import java.util.Scanner; //Enable user prompted data entry
import java.lang.Math; //Enable higher math functions
import java.util.ArrayList; //Enable parsing & storing of integer digits into an array

public class Main
{

    public static void main(String[] args) {   //Information for the user about the test
        System.out.println("TRY THIS TEST! \n");
        System.out.println("Enter an integer to determine if the sum of it's cubed digits, equal the original number.\n");
        System.out.println("For example: If we pick 153, we get: (1^3 + 5^3 + 3^3) = 1 + 125 + 27 = 153.\n(Note: ^ means 'to the power of'.)\n");
        //For n=3, there are only 4 such numbers, 153,370,371, and 407.
        System.out.println("One thing, for this test, your entry is limited to a 32 bit integer.\nThe largest number you can enter is 2147483647.\nDon't use commas.");
        System.out.print("Find out if your guess is TRUE or FALSE!\nEnter here: ");

        Scanner scnr = new Scanner(System.in); //Enable user prompted data entry

        //Declarations
        int origNum;    //used in this method to validate the number
        int x; //copy of origNum to pass to calcNum method for processing
        int test = 1;   //Used to test condition of proper integer entry

        do {    /* LOOP! Tests user entry of proper integer */

            while (!scnr.hasNextInt()) { //Prevent user from entering non-integers/garbage
                String input = scnr.next();
                System.out.printf("%s is not a valid integer. Try again.\n", input);
            }

            origNum = scnr.nextInt();   //User is prompted to enter an integer

            if (origNum == 153) {   //Check for Example 153
                System.out.println("Sorry! That answer was already given!");
                System.out.println("Try again! ");
            } else if (origNum == 0) {  //Disqualify 0
                System.out.println("Sorry! Zero is not a good number for this test.");
                System.out.println("Try again! ");
            } else if (origNum < 10) {  //Disqualify single digit integers
                System.out.printf("Well... %s is an integer, but for this test, we need at least a double digit number. Cool?\n", origNum);
                System.out.println("Try again! ");
            }

            else {
                test = 0;   //ends verification loop
            }

        } while (test == 1);    //continues verification loop until

            /*System.out.print("READY FOR NEXT METHOD!"); /*"Comment this out" once valid number test is perfected.
            This was used to let me know that the code successfully progressed beyond the do/while loop
             */
        System.out.printf("\nAnalyzing %s...\n", origNum);

        x = origNum; //copies the validated integer for passing to calcNum module
        calcNum(x);  //calling & passing to calcNum module with variable
    }


    private static void calcNum(int x)
       /*
          This Method takes the validated number entered by the user, counts it's digits,
          stores each digit in an array, cubes each digit, sums the cubes, and
          returns the sum to compare with the original user entry.
          */
       {
           //Declarations
           int numDigits = 0;
           int sentNumcnt = x;
           int cubeNum = x;
           double chkOrig = x;
           double chkOrig2 = x;
           //System.out.println(x); Used to make sure the correct value of x was passed into this method


           while (sentNumcnt > 0) {         //calculate & print number of digits in the number
               sentNumcnt = sentNumcnt / 10;
               numDigits = numDigits + 1;
           }
           //System.out.printf("%s digits to cube.\n", numDigits);


           int temp = x;

           ArrayList<Integer> digitArray = new ArrayList<Integer>(); //loads digits into an array

           do {
               digitArray.add(0, temp % 10);
               temp /= 10;
           } while (temp > 0);

           System.out.printf("Preparing each digit: ");

           for (int y: digitArray) //prints the contents of the array


           System.out.print(y + " ");
           System.out.println(" ");


           System.out.printf("\nThe %s digits have been cubed they are: ", numDigits);
           //raises and prints each digit to it's third power

           int n = cubeNum;

           double sum = 0;

           while (n > 0) {
               int d = n / 10;
               double k = n - d * 10;
               n = d;
               k = Math.pow(k,3.0);
               sum = sum + k;  //calculates the sum of all digits
               System.out.print((int)k + " ");





           }
           System.out.printf("\n\nThe sum of these numbers is %s ", (int)sum);

           System.out.println(" \n");

           chkOrig2 = sum;
           if (chkOrig2 == chkOrig) {
               System.out.println("Result of test: TRUE");
               System.out.printf("The sum of %s's cubed digits, equal %s.\n", (int)chkOrig, (int)chkOrig);
               System.out.printf("Great guess! Besides 153, %s is one of only 3 remaining possible answers.\n", (int)chkOrig);
           } else {
               System.out.println("Result of test: False");
               System.out.printf("The sum of %s's cubed digits do not equal %s.\n", (int)chkOrig, (int)chkOrig);
               System.out.printf("Besides 153, there are only 3 remaining possible answers.\n", (int)chkOrig);

           }
       }


}