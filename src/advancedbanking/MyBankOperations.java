/*
//amanpreetk126@gmail.com
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedbanking;

/**
 *
 * @author Akash
 */
import java.util.Scanner;

public class MyBankOperations {

    MyBankBean arr[] = new MyBankBean[10];
     int currentAccountNo = 100;
    int count = 0;

    public void openAccount(String name, double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount value");
        } else {
            if (count < 10) {

                arr[count] = new MyBankBean();
                arr[count].setName(name);
                arr[count].setAmount(amount);
                arr[count].setAccountNo(currentAccountNo);
                System.out.println();
                System.out.println("A new account has been opened");
                System.out.println("Account No: " + arr[count].getAccountNo());
                System.out.println("Name: " + arr[count].getName());
                System.out.println("Amount: " + arr[count].getAmount());
                arr[count].setTransaction("New Account Opened" + arr[count].getName() + " " + arr[count].getAccountNo() + " " + arr[count].getAmount());

                System.out.println();
                count++;
                currentAccountNo++;

            } else {
                System.out.println("Account Limit reached");
                System.out.println("Your Account was not opened");
                arr[count].setTransaction("Account Limit reached");
            }
        }

    }

    public void showAll() {
        System.out.println("Below is the list of all accounts");
        for (int i = 0; i < count; i++) {
            MyBankBean ob = arr[i];
            System.out.println();
            System.out.println("Account No: " + ob.getAccountNo());
            System.out.println("Name: " + ob.getName());
            System.out.println("Amount: " + ob.getAmount());
            System.out.println("---------------------------------");
            System.out.println();

        }
    }

    public void deposit(int accountNo, double amount) {
        boolean flag = false;
        if (amount < 0) {
            System.out.println("Invalid amount value");

        }
        if (count == 0) {
            System.out.println("Open Account First");

        } else {
            for (int i = 0; i < count; i++) {
                if (arr[i].getAccountNo() == accountNo) {
                    arr[i].setAmount(arr[i].getAmount() + amount);
                    arr[i].setTransaction(amount + " Amount deposited to accountNo " + arr[i].getAccountNo());
                    System.out.println(amount + "deposited to accountNo " + arr[i].getAccountNo());
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("No account found.Open Account First ");
            }
        }
        System.out.println();
        System.out.println("---------------------------");
        System.out.println();
    }

    public void withDraw(int accountNo, double amount) {
        boolean flag=false;
        if (amount < 0) {
            System.out.println("Invalid amount value");

        } else {
            for (int i = 0; i < count; i++) {
                if (arr[i].getAccountNo() == accountNo) {
                    if (arr[i].getAmount() - amount < 1000) {
                        System.out.println("INSUFFICENT FUNDS");
                        arr[i].setTransaction("Insufficient funds occured in withdraw operation");
                    } else {
                        arr[i].setAmount(arr[i].getAmount() - amount);
                        System.out.println("Requested amount withdrawn");
                        arr[i].setTransaction(amount + " Amount withdrawn from  accountNo " + arr[i].getAccountNo());
                        flag=true;
                        break;
                    }
                }
            }
            if (!flag) {
                System.out.println("No account found.Open Account First ");
            }
            System.out.println();
            System.out.println("---------------------------");
            System.out.println();
        }
    }

    public void checkAmount(int accountNo) {
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (arr[i].getAccountNo() == accountNo) {
                System.out.println("Name: " + arr[i].getName());
                System.out.println("Your account balance is: " + arr[i].getAmount());
                arr[i].setTransaction("Amount checked for account " + arr[i].getAccountNo());
                flag = true;
                break;
            }

        }
        if (!flag) {
            System.out.println("Invalid Account no");
        }
        System.out.println();
        System.out.println("---------------------------");
        System.out.println();
    }

    public void menu() {
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("Welcome To Axis Bank");
        System.out.println("Enter your choice");
        System.out.println("1: Open a new account");
        System.out.println("2: Deposit funds");
        System.out.println("3: WithDraw Funds");
        System.out.println("4: Check Account");
        System.out.println("5: Check Transaction");
        System.out.println("6: Show all Accounts");
        System.out.println("7: Show all user transaction History ");
        System.out.println("0: Exit");
        System.out.println("---------------------------");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        try {
            int input = Integer.parseInt(scan.next());
            switch (input) {
                case 1:
                    System.out.println("Enter your name");
                    String inputName = scan.next().toUpperCase();
                    System.out.println("Enter amount to be deposited");
                    int inputAmount = Integer.parseInt(scan.next());
                    openAccount(inputName, inputAmount);
                    menu();
                case 2:
                    System.out.println("Enter your account No");
                    int inputAccountNo = Integer.parseInt(scan.next());
                    System.out.println("Enter amount to be deposited");
                    inputAmount = Integer.parseInt(scan.next());
                    deposit(inputAccountNo, inputAmount);
                    menu();
                case 3:
                    System.out.println("Enter your account No");
                    inputAccountNo = Integer.parseInt(scan.next());
                    System.out.println("Enter amount to be withdrawn");
                    inputAmount = Integer.parseInt(scan.next());
                    withDraw(inputAccountNo, inputAmount);
                    menu();
                case 4:
                    System.out.println("Enter your account No");
                    inputAccountNo = Integer.parseInt(scan.next());
                    checkAmount(inputAccountNo);
                    menu();
                case 5:
                    System.out.println("Enter your account No");
                    inputAccountNo = Integer.parseInt(scan.next());
                    transactionCheck(inputAccountNo);
                    menu();
                case 6:
                    showAll();
                    menu();
                case 7:
                    allTransactions();
                    menu();
                case 0:
                    System.out.println("Exiting the application");
                    System.exit(0);
                default:
                    System.out.println("No match found.Please retry");
                    menu();

            }
        } catch (Exception e) {
            System.out.println("Invalid input.Try Again");
            menu();
        }
    }

    public void transactionCheck(int accountNo) {
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (arr[i].getAccountNo() == accountNo) {
                System.out.println("TRANSACTIONDETAILS");
                System.out.println(arr[i].getTransaction());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Invalid Account no");
        }
    }
    
    public void allTransactions(){
    for(int i = 0;i<count;i++){
        System.out.println("TRANSACTION HISTORY FOR USER "+ arr[i].getName());
        System.out.println(arr[i].getTransaction());
        System.out.println("==================================");
    }
    }
}
