package atmpackage;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Options extends Account {

    Scanner scan = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<>();
    boolean flag = true;

    public void login() {

        System.out.println("Hi!Welcome to Techproed ATM..");

        do {

            data.put(12345, 1234);//user 1
            data.put(23456, 2345);//user 2
            data.put(34567, 3456);//user 3
            data.put(45678, 4567);//user 4
            try {
                System.out.println("Enter account number");
                setAccountNumber(scan.nextInt());
                System.out.println("Enter the pin number");
                setPinNumber(scan.nextInt());


            } catch (Exception e) {
                System.out.println("Hey!You have entered an invalid character!");
                System.out.println("Please enter an integer to proceed or you can type in 'Q' to exit");
                scan.nextLine();
                String exit = scan.next().toLowerCase();
                if (exit.equals("q")) {
                    flag = false;
                }
                e.printStackTrace();
            }
            int count = 0;
            for (Map.Entry<Integer, Integer> w : data.entrySet()) {

                if (w.getKey().equals(getAccountNumber()) && w.getValue().equals(getPinNumber())) {
                    System.out.println("Welcome to your account!");
                    selectAccount();
                } else {
                    count++;
                }
            }
            if (count == data.size()) {
                System.out.println("invalid user");
                System.out.println("Press any integer to try again or Press 'Q' to exit");
                String exit = scan.next();
                if (exit.equalsIgnoreCase("q")) {
                    flag = false;
                }
            }


        } while (flag);


    }

    public void selectAccount() {

        do {
           operationsMessage();

            int option = scan.nextInt();

            if (option == 3) {
                break;
            } else if (option == 1) {
                //call checking account operations
                checkingOperations();
            } else if (option == 2) {
                //call saving account operations
                savingOperations();
            } else {
                System.out.println("invalid option!please select a correct one");
            }


        } while (true);
    }

    public void checkingOperations() {

        do {

            operationsMessage();

            int option = scan.nextInt();

            if (option == 4) {
                break;
            }
            switch (option) {
                case 1:
                    System.out.println("Your checking account balance is:  " + moneyFormat.format(getCheckingBalance()));
                    break;
                case 2:
                    if (getCheckingBalance() > 0) {
                        getCheckingWithdraw();
                    } else {
                        System.out.println("You do not have enough money,pls deposit first!");

                    }
                    break;
                default:
                    System.out.println("invalid option!please select a valid option");
                case 3:
                    getCheckingDeposit();

            }

        } while (true);
    }

    public void savingOperations(){

        do{
            operationsMessage();

        int option = scan.nextInt();

        if(option==4){
            break;
        }
          switch(option)  {
              case 1:
                  System.out.println("your saving account balance is:"+moneyFormat.format(getSavingBalance()));
           break;
              case 2:
              if(getSavingBalance()>0) {
                  getSavingWithdraw();
              }else{
                  System.out.println("you do not have enough money,please deposit first!");
              }
              break;
              case 3:
                  getSavingDeposit();
                  break;

              default:
                  System.out.println("invalid option!pls select a valid option");




          }
        }while(true);




    }
    public void operationsMessage(){
        System.out.println("Select option:");
        System.out.println("1:View balance");
        System.out.println("2:Withdraw");
        System.out.println("3:Deposit");
        System.out.println("4:Exit");


    }
}
