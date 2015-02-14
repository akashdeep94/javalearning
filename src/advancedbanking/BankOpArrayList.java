/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedbanking;

/**
 *
 * @author Akash
 */
import java.util.*;

public class BankOpArrayList {

    int currentAcct = 101;

    List<MyBankBean> list = new ArrayList<>();

    void openAccount(String name, int amount) {
        MyBankBean banking = new MyBankBean();
        banking.setAccountNo(currentAcct);
        banking.setAmount(amount);
        banking.setName(name);
        banking.setTransaction("New Account Opened" + amount);
        list.add(banking);
        currentAcct++;
    }

    void ShowAll() {
        for (MyBankBean obj : list) {
            System.out.println("Account NO: " + obj.getAccountNo());
            System.out.println("Name: " + obj.getName());
            System.out.println("Amount: " + obj.getAmount());
        }
    }

    public void deposit(int accountNo, double amount) {
        boolean flag = false;

        if (amount < 0) {
            System.out.println("Invalid amount value");

        }
        if (list.isEmpty()) {
            System.out.println("Open Account First");

        } else {
            for (MyBankBean deposit : list) {
                if (deposit.getAccountNo() == accountNo) {
                    deposit.setAmount(deposit.getAmount() + amount);
                    deposit.setTransaction(amount + " Amount deposited to accountNo " + deposit.getAccountNo());
                    System.out.println(amount + "deposited to accountNo " + deposit.getAccountNo());
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
        boolean flag = false;
        if (amount < 0) {
            System.out.println("Invalid amount value");

        } else {
            for (MyBankBean withdraw : list) {
                if (withdraw.getAccountNo() == accountNo) {
                    if (withdraw.getAmount() - amount < 1000) {
                        System.out.println("INSUFFICENT FUNDS");
                        withdraw.setTransaction("Insufficient funds occured in withdraw operation");
                    } else {
                        withdraw.setAmount(withdraw.getAmount() - amount);
                        System.out.println("Requested amount withdrawn");
                        withdraw.setTransaction(amount + " Amount withdrawn from  accountNo " + withdraw.getAccountNo());
                        flag = true;
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
        for (MyBankBean checkAmount : list) {
            if (checkAmount.getAccountNo() == accountNo) {
                System.out.println("Name: " + checkAmount.getName());
                System.out.println("Your account balance is: " + checkAmount.getAmount());
                checkAmount.setTransaction("Amount checked for account " + checkAmount.getAccountNo());
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

    public void showAll() {
        System.out.println("Below is the list of all accounts");
        for (MyBankBean showAll : list) {
            System.out.println();
            System.out.println("Account No: " + showAll.getAccountNo());
            System.out.println("Name: " + showAll.getName());
            System.out.println("Amount: " + showAll.getAmount());
            System.out.println("---------------------------------");
            System.out.println();

        }
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
        System.out.println("8: Search");
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
                case 8:
                    System.out.println("Enter String");
                    String search=scan.next();
                    search(search);
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
        for (MyBankBean transactionCheck : list) {
            if (transactionCheck.getAccountNo() == accountNo) {
                System.out.println("TRANSACTIONDETAILS");
                System.out.println(transactionCheck.getTransaction());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Invalid Account no");
        }
    }

    public void allTransactions() {
        for (MyBankBean allTransactions : list) {
            System.out.println("TRANSACTION HISTORY FOR USER " + allTransactions.getName());
            System.out.println(allTransactions.getTransaction());
            System.out.println("==================================");
        }
    }

    public void search(String input) {
        boolean flag=false;
        for (MyBankBean searched : list) {
            if (searched.getName().contains(input)) {
                System.out.println(searched.getName());
                flag=true;
            }
        }
        if(!flag)System.out.println("No Match Found");
        menu();

    }

}
