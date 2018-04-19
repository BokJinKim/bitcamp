package step24.ex5;

public class Account {
    String accountId;
    long balance;
    
    public Account(String accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
    
    public long withdraw(long money) {
        long b = this.balance;
        b -= money;
        if (b < 0)
            return 0;
        this.balance = b;
        return money;
    }

}
