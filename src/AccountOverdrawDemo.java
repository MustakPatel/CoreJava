import java.util.Scanner;

class Account {     //keep information about Acount balance and withdraw amount

    private int balance;

    Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isSufficentBalance(int withdrawalAmount) {

        return balance >= withdrawalAmount;     //return true if balance is greater or equal then withdraw amount
    }

    synchronized void safeWithdraw() {        //it's being allowed only one thread to access the shared resource

        if (isSufficentBalance(1000)) {

            System.out.println("Balance Before " + Thread.currentThread().getName() + "'s withdrawal :" + getBalance());
            balance = getBalance() - 1000;
            System.out.println("withdraw amount :"+ 1000);
            System.out.println("Current balance :"+balance);

        } else {
            System.out.println("Not Sufficient Amount for :" + Thread.currentThread().getName());
        }

    }

    public void unsafeWithdraw(int withdrawAmount) {        //threads can interfere with one another while sharing data

        if (isSufficentBalance(1000)) {

            System.out.println("Balance Before " + Thread.currentThread().getName() + "'s withdrawal :" + getBalance());
            balance = getBalance() - withdrawAmount;
            System.out.println("withdraw amount :"+withdrawAmount);
            System.out.println("Current balance :"+balance);

        } else {
            System.out.println("Not Sufficient Amount for :" + Thread.currentThread().getName());
        }

    }
}

class UnsafeThread implements Runnable {
    Account account = new Account(1000);

    public void run() {
        account.unsafeWithdraw(1000);
        if (account.getBalance() < 0) {
            System.out.println("Account Empty");
        }
    }
}

class AccountOverdrawSafeDemo implements Runnable {
    Account account = new Account(1000);

    public void run() {
        account.safeWithdraw();
        if (account.getBalance() < 0) {     //if account balance is negative then print this message
            System.out.println("Account Empty");
        }
    }
}

public class AccountOverdrawDemo {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Thread Safe Mode Demo");
            System.out.println("2. Thread Unsafe Mode Demo");
            System.out.println("3. Exit");

            try {

                UnsafeThread unsafeThread = new UnsafeThread();     //object is being created for UnsafeThread class
                Thread thread1 = new Thread(unsafeThread, "Faiz Patel");        //pass object and string in Thread constructor
                Thread thread2 = new Thread(unsafeThread, "Harsh sony");        //pass object and string in Thread constructor

                AccountOverdrawSafeDemo safeThread = new  AccountOverdrawSafeDemo();        //object is being created for safeThread class
                Thread thread3 = new Thread(safeThread, "Faiz Patel");       //pass object and string in Thread constructor
                Thread thread4 = new Thread(safeThread, "Harsh Sony");       //pass object and string in Thread constructor

                System.out.print("Enter your choice ");
                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:{

                        thread3.start();
                        thread4.start();
                        break;
                    }

                    case 2:{

                        thread1.start();
                        thread2.start();
                        break;
                    }

                    case 3:{
                        System.out.println("All done!");
                        return;
                    }

                    default:{
                        System.out.println("Please choose right option");
                    }

                }       //end of the switch block

                Thread.sleep(4000);     //hold for 4 seconds

            } catch (Exception e) {
                System.out.println(e);
            }

        }while (true);
    }       //end of the main method
}      //end o the class