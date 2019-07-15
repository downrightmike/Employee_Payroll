/*************************************************************************
  *  Compilation:  javac Employee_Payroll.java
  *  Author: downrightMike
  *  
  *************************************************************************
  *************************************************************************/
  import java.util.Scanner;

public class Employee_Payroll{
        // keyboard is a global variable because it is above main. Notice the static label also. 
        private static Scanner keyboard = new Scanner(System.in);
        public static void main(String[] args) {
            //Declare the employee and payroll arrays in the main method.
            int empArray [] = new int [6];
            double payArray [][] = new double [6][5];

            popEmp(empArray);
            popPay(payArray);
            calcPay(payArray);
            printPay(empArray, payArray);
        }
        //Pass the employee array into a method that populates it with hardcoded employee IDs.
        public static void popEmp(int[] empArray){
            empArray[0] = 100;
            empArray[1] = 200;
            empArray[2] = 300;
            empArray[3] = 400;
            empArray[4] = 500;
            empArray[5] = 600;
            }

        //Pass the payroll array into a method that populates it with hardcoded hours worked and pay rates.
            public static void popPay(double[][] payArray){
                //Hours
                payArray[0][0] = 40.0;
                payArray[1][0] = 40.0;
                payArray[2][0] = 50.0;
                payArray[3][0] = 60.0;
                payArray[4][0] = 42.0;
                payArray[5][0] = 45.5;
                //Payrate
                payArray[0][1] = 20.0;
                payArray[1][1] = 20.0;
                payArray[2][1] = 30.0;
                payArray[3][1] = 40.0;
                payArray[4][1] = 22.0;
                payArray[5][1] = 15.5;
            }
        //After returning to main, pass the payroll array into another method that loops through
         //it, calculates gross regular pay (based on 40 hours or less) for each employee and stores
          //this value in the array’s gross regular pay column.
          public static void calcPay(double[][] payArray){
              for(int i = 0; i < payArray.length; i++){
                  if(payArray[i][0] >= 40.0){
                      payArray[i][2] = 40.0 * payArray[i][1];
                  } else {
                    payArray[i][2] = payArray[i][10] * payArray[i][1];
                  }
                  // This method will also calculate gross overtime pay (based on hours over 40) for each employee 
                  if(payArray[i][0] > 40.0){ payArray[i][3] =  (payArray[i][0] - 40.0) * (payArray[i][1] * 1.5); } 
                  //and add regular pay and overtime pay to total gross pay. 
                  payArray[i][4] = payArray[i][3] + payArray[i][2]; 
              }
          }
          
          
        //After returning to main, pass both arrays into a display method which will output the employee’s ID, 
        //hours worked, pay rate, regular gross pay, overtime gross pay and total gross pay. 
        //Produce a well-aligned table like the following:
            /*Hours Regular Overtime Total
            Employee ID Worked Pay Rate Gross Pay Gross Pay Gross Pay
            100 50.00 25.00 1000.00 375.00 1375.00
            200 15.00 15.00 225.00 0.00 225.00
            300 48.00 27.00 1080.00 324.00 1404.00
            400 40.00 25.00 1000.00 0.00 1000.00
            500 40.00 23.00 920.00 0.00 920.00
            600 45.00 10.00 400.00 75.00 475.00 */
            public static void printPay(int[] empArray, double[][] payArray){
                System.out.println("               Hours               Regular    Overtime   Total     ");
                System.out.println("Employee ID    Worked   Pay Rate  Gross Pay  Gross Pay  Gross Pay");
                for(int i = 0; i < empArray.length; i++){
                    //  System.out.printf("%4.2f %2s", rateThisLoop, " ");
                    System.out.printf("%7d %12.2f %10.2f %10.2f %10.2f %10.2f", empArray[i] , payArray[i][0] , payArray[i][1] , payArray[i][2] , payArray[i][3] , payArray[i][4]);
                    System.out.println();
                }
            }
        }