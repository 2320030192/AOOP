import java.util.HashMap;
import java.util.Map;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Invalid withdraw amount");
        }
    }
}

class Bank {
    private Map<String, BankAccount> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(BankAccount account) {
        if (account != null && !accounts.containsKey(account.getAccountNumber())) {
            accounts.put(account.getAccountNumber(), account);
        } else {
            throw new IllegalArgumentException("Account already exists or invalid account");
        }
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        BankAccount fromAccount = getAccount(fromAccountNumber);
        BankAccount toAccount = getAccount(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Invalid account number");
        }

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}

// JUnit5 Test Class
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        bank.addAccount(new BankAccount("001", "Alice", 1000.0));
        bank.addAccount(new BankAccount("002", "Bob", 500.0));
    }

    @Test
    void testCreateMultipleAccounts() {
        assertEquals(1000.0, bank.getAccount("001").getBalance());
        assertEquals(500.0, bank.getAccount("002").getBalance());
    }

    @Test
    void testDepositAndWithdraw() {
        BankAccount aliceAccount = bank.getAccount("001");
        aliceAccount.deposit(200.0);
        assertEquals(1200.0, aliceAccount.getBalance());

        aliceAccount.withdraw(300.0);
        assertEquals(900.0, aliceAccount.getBalance());
    }

    @Test
    void testTransferMoneyBetweenAccounts() {
        bank.transfer("001", "002", 200.0);

        assertEquals(800.0, bank.getAccount("001").getBalance());
        assertEquals(700.0, bank.getAccount("002").getBalance());
    }

    @Test
    void testInvalidTransfer() {
        assertThrows(IllegalArgumentException.class, () -> {
            bank.transfer("001", "003", 200.0); // Non-existent account
        });

        assertThrows(IllegalArgumentException.class, () -> {
            bank.transfer("001", "002", 1200.0); // Insufficient funds
        });
    }
}
