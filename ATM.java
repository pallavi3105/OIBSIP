
import java.sql.SQLOutput;
import java.util.*;
class bankaccount{
    static  void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\t\t---------------------------");
        System.out.println("\t\tEnter username :");
        String uname=sc.nextLine();
        System.out.println("\t\tEnter password :");
        String pwd=sc.nextLine();
        System.out.println("\t\tEnter your Account number :");
        ATM.accnumber=sc.nextLine();
        System.out.println("\t\tLOGIN SUCCESSFULL!");
        
        ATM.prompt();
        while(true){
            display(ATM.uname);
            int choice=sc.nextInt();
            if(choice == 1){
                login(uname,pwd);
                break;
            }
            else {
                if(choice == 2){
                    System.exit(0);
                }
                else{
                    System.out.println("\t\tPlease Enter valid choice!");
                }
            }
        }
    }
    static void display(String uname){}
    static void login(String uname,String pwd){}
}
class transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\t\t----------------------------");
        System.out.println("\t\tEnter amount to withdraw :");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("\t\tAmount Rs"+wcash+"/-withdraw successfully");
            System.out.println("\t\t---------------------------");
        }
        else{
            System.out.println("\t\tSorry!Insufficient balance to withdraw the cash");
            System.out.println("\t\t---------------------------");
        }
        ATM.prompt();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\t\t--------------------------------");
        System.out.print("\t\tEnter amount to deposit :");
        int dcash=sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposit");
        System.out.println("\t\tAmount Rs."+dcash+"/- deposit successful!");
        System.out.println("\t\t---------------------------------");
        ATM.prompt();
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\t\tEnter the receiving number:");
        String s=sc.nextLine();
        System.out.println("\t\tEnter the account number of the receiving number");
        int num=sc.nextInt();
        System.out.println("\t\tEnter the amount to be transferred :");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance){
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("transferred");
            System.out.println("\t\tAmount Rs."+tcash+"/- transferred successfully");
            System.out.println("\t\t--------------------------------");
        }
        else{
            System.out.println("\t\tSorry!Insufficient balance to transfer the cash");
            System.out.println("\t\t--------------------------------");
        }
    }
}
class historyy{
    static void transactionhistory(){
            System.out.println("\t\t-------------------------------");
            System.out.println("\t\tTransaction History :");
            int k=0;
            if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.println(ATM.history.get(k)+" ");
                    k++;
                }
                System.out.println("\t\t-----------------------------");
            }
            }
            else {
                System.out.println("\t\tSorry!Your account is empty");
            }
            ATM.prompt();
    }
}
public class ATM {
    public static String uname;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();
    public static int balance=10000;

    static void updatebalance(int dcash){
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void InterfaceA(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\t\t-----------------WELCOME TO ATM INTERFACE-------------------\n");
        System.out.println("\t\tselect option :");
        System.out.println("\t\t1. Login");
        System.out.println("\t\t2. Exit");
        System.out.println("\t\tEnter choice");
        int choice =sc.nextInt();
        if (choice==1){
                bankaccount.register();
        }
        else {
            if(choice==2){
                System.exit(0);
            }
            else{
                System.out.println("\t\tPlease enter valid choice from given options :");
                InterfaceA();
            }
        }
    }
    static void prompt(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\t\t---------------------------------------");
        System.out.println("\t\tWELCOME USER TO ATM SYSTEM");
        System.out.println("\t\t---------------------------------------");
        System.out.println("\t\tInitial Balance in account = 10000");
        System.out.println("\t\tSelect option : ");
        System.out.println("\t\t1. Transaction History");
        System.out.println("\t\t2. Withdraw");
        System.out.println("\t\t3. Deposit");
        System.out.println("\t\t4. Transfer");
        System.out.println("\t\t5. Quit");
        System.out.print("\t\tEnter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                historyy.transactionhistory();
                
            case 2:
                transaction.withdraw();
                
            case 3:
                transaction.deposit();
                
            case 4:
                transaction.transfer();

            case 5:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        InterfaceA();
    }
}
