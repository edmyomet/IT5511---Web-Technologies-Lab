import java.util.Scanner;
import java.util.ArrayList;
import java.util.ListIterator;

public interface Accounts{
    public void deposit(double amount);
    public void withdraw(double amount);
    public void calculateInterest();
    public void viewBalance();
}
class Bank{
    int accountNumber;
    static ArrayList<Integer>accountList = new ArrayList<>();
    Bank(){
        /*
         * Default constructor;
         */
    }
    Bank(int accountNumber){
        this.accountNumber = accountNumber;
        Bank.accountList.add(accountNumber);
    }
    void addAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an account number to add");
        this.accountNumber = sc.nextInt();
        sc.nextLine();
        Bank.accountList.add(accountNumber);
        sc.close();
    }
    void display(){
        System.out.println("The accounts in the Bank db are as follows: ");
        for(int x : Bank.accountList){
            System.out.println("Account number: " + x);
        }
    }
}
class savingsAccount extends Bank implements Accounts{
    double savings;
    double interest;
    double dividend;
    savingsAccount(){
        /*
         * Default constructor;
         */
    }
    savingsAccount(double savings, double interest){
        this.savings = savings;
        this.interest = interest;
    }
    public boolean checkIf(){
        Scanner sc = new Scanner(System.in)
;       System.out.println("Enter your account number: ");
        int acctno = sc.nextInt();
        sc.nextLine();
        for(int x : Bank.accountList){
            if(x == acctno)
                return true;
        }
        sc.close();
        return false;
    }
    public void withdraw(double amount){
        if(!checkIf()){
            System.out.println("Account not available in the database, please add an account");
            return;
        }
        this.savings -= amount;
        if(this.savings < 0){
            System.out.println("Amount cannot be withdrawn, Insufficient funds");
            this.savings += amount;
            return;
        }
        else{
            System.out.println("Transaction complete");
        }
    }
    public void deposit(double amount){
        if(amount > 100000000){
            System.out.println("Amount is too large");
            return;
        }
        this.savings += amount;
    }
    public void calculateInterest(){
        this.dividend = ((this.interest / 100)*this.savings) + this.savings;
    }
    public void viewBalance(){
        System.out.println("Your Balance is: "+this.savings);
    }
}
class Main{
    public static void main(String[] args){
        
    }
}
