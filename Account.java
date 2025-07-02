public class Account{
        public String id;
        private String name;
        public double balance;
        public String accType;
        public Account(){

        }
        public Account(String id,String name){
                this(id,name,0);
        }
        public Account(String id,String name,double balance){
                this.id=id;
                this.name=name;
                this.balance=balance;
        }
        public Account(String id,String name,String accType){
                this.id=id;
                this.name=name;
                this.accType=accType;
        }
        public Account(String id,String name,double balance,String accType){
                this.id=id;
                this.name=name;
                this.balance=balance;
                this.accType=accType;
        }
        public double credit(double amount){
                balance+=amount;
                return balance;
        }
        public double debit(double amount){
                if(amount<balance){
                        balance-=amount;
                }
                else{
                        System.out.println("Amount exceeded balance");
                }
                return balance;
        }
        public double transferTo(double amount,Account another){
                if(amount<=balance){
                        balance -= amount;
                        another.credit(amount);
                }
                else{
                        System.out.println("Amount exceeded balance");
                }
                return balance;
        }
        public double interest(double balance){
                return balance;
        }
        public String toString(){
                return "Account id:" +id+". Account type:"+accType+". Name:"+name+", Balance:"+balance;
        }
}
