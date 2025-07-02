public class Savings extends Account{
    public Savings(){
    }
    public Savings(String id,String name,double balance,String accType){
        super(id,id,balance,accType);
    }
    @Override
    public double debit(double amount){
        int min_balance=1000;
        if((balance-amount)>=min_balance) {
            balance -= amount;
        }
        else{
            System.out.println("Not enough balance.");
        }
        return balance;
    }
    @Override
    public double transferTo(double amount,Account another){
        if((balance-amount)>=1000){
            balance -= amount;
            another.credit(amount);
        }
        else{
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }
    @Override
    public double interest(double balance){
        return balance*1.025;
    }
}
