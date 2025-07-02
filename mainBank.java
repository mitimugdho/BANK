import java.util.*;
public class mainBank {
    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        Account[] account=new Account[50];
        Deposit deposit=new Deposit();
        Savings savings=new Savings();
        int count=0;

        account[count++]=new Account("001","miti",10000,"current");
        account[count++]=new Account("002","diab",50000,"savings");
        account[count++]=new Account("003","munni",1000000,"deposit");

        while (true) {
            System.out.println("\n1. New Account");
            System.out.println("2. Credit/ 3. Debit/ 4. Transfer");
            System.out.println("5. View Account");
            System.out.println("6. Exit");

            System.out.print("Choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.println("Account type:(current/savings/deposit)");
                    String accType= scanner.nextLine().trim().toLowerCase();
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Do you want to create the account with an initial balance? (y/n): ");
                    String choice = scanner.nextLine().trim().toLowerCase();

                    if (choice.equals("y")) {
                        System.out.print("Enter initial balance: ");
                        double varBalance = scanner.nextDouble();
                        scanner.nextLine();
                        account[count++] = new Account(id, name, varBalance,accType);
                    } else {
                        account[count++] = new Account(id, name,accType);
                    }

                    System.out.println("Account created.");
                }
                case 2,3-> {
                    System.out.print("Account ID: ");
                    String id = scanner.nextLine();

                    Account acc = null;
                    for (int i = 0; i < count; i++) {
                        if (account[i].id.equals(id)) {
                            acc = account[i];
                            break;
                        }
                    }
                    if (acc != null) {
                        System.out.print("Amount: ");
                        double amt = scanner.nextDouble();
                        scanner.nextLine();

                        if (ch == 2){
                            if(acc.accType.equals("deposit")){
                                deposit.credit(amt);
                            }
                            else {
                                acc.credit(amt);
                            }
                        }
                        else{
                            if(acc.accType.equals("savings")){
                                savings.debit(amt);
                            }
                            if(acc.accType.equals("deposit")){
                                deposit.debit(amt);
                            }
                            else acc.debit(amt);
                        }
                    }
                    else {
                        System.out.println("Account does not exist.");
                    }
                }
                case 4-> {
                    System.out.print("From ID: ");
                    String fromID = scanner.nextLine();
                    System.out.print("To ID: ");
                    String toID = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amt = scanner.nextDouble();
                    scanner.nextLine();

                    Account from = null, to = null;
                    for (int i = 0; i < count; i++)
                    {
                        if (account[i].id.equals(fromID)) from = account[i];
                        if (account[i].id.equals(toID)) to = account[i];
                    }
                    if (from != null && to != null) {
                        if (from.accType.equals("savings")) {
                            savings.transferTo(amt, to);
                        } else if (from.accType.equals("deposit")) {
                            System.out.println("Transfer is not possible from Deposit Premium account.");
                        } else {
                            from.transferTo(amt, to);

                        }
                    }
                    else {
                        System.out.println("Account(s) not found.");
                    }
                }
                case 5-> {
                    System.out.print("Enter Account ID: ");
                    String idName= scanner.nextLine();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (account[i].id.equals(idName)) {
                            System.out.println(account[i].toString());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                }
                case 6->{
                    System.out.println("Program exit.");
                    System.exit(0);
                }
                default ->   System.out.println("Invalid choice.");
            }
        }
    }
}