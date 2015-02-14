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
import java.text.*;
import java.util.*;
public class MyBankBean {

    private double amount;
    private int accountNo;
    private String name;
    private StringBuffer hist=new StringBuffer();
    private SimpleDateFormat sdf= new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    Date dt=new Date();

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public int getAccountNo() {
        return accountNo;
    }
    public void setTransaction(String s){
        hist=hist.append(sdf.format(dt) );
        hist=hist.append("  :- ");
        hist=hist.append(s);
        hist=hist.append(System.lineSeparator());
    } 
    
    public StringBuffer getTransaction(){
        return hist;
    }
}
