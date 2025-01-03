package entities;

import java.util.Set;

class UserAccountRunnable implements Runnable {
    private final Set<String> userAccounts;

    public UserAccountRunnable(Set<String> userAccounts) {
        this.userAccounts = userAccounts;
    }

    @Override
    public void run() {
        System.out.println("Processing User Accounts...");
        userAccounts.forEach(account -> System.out.println("Account: " + account));
    }
}

