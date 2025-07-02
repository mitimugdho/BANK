
public class Deposit extends Account{
    private static int creditCount=0;
    public  Deposit(){

    }
    public Deposit(String id,String name,double balance,String accType){
        super(id,id,balance,accType);
    }
    @Override
    public double credit(double amount){
        balance=interest(balance);
        balance+=amount;
        creditCount++;
        return balance;
    }
    @Override
    public double debit(double amount){
        if(creditCount<5) {
            System.out.println("Withdrawal not permitted");
            return balance;
        }
        else{
            balance-=amount;
            return balance;
        }
    }
    @Override
    public double interest(double balance){
        return balance*1.07;
    }
}

