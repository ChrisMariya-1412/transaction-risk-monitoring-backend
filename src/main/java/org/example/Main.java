package org.example;
import java.util.List;

import io.javalin.Javalin;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        // Test PostgreSQL connection
        try (Connection connection = DatabaseConnection.getConnection()) {

            System.out.println("Database connected successfully!");

        } catch (Exception e) {

            System.out.println("Database connection failed!");
            e.printStackTrace();
        }

        // Get all accounts from PostgreSQL
        AccountRepository accountRepository = new AccountRepository();

        TransactionRepository transactionRepository = new TransactionRepository();

        // Start Javalin server
        Javalin app = Javalin.create();

        app.get("/hello", ctx -> {
            ctx.result("Hello from Transaction Risk Monitoring!");
        });

        app.get("/accounts", ctx -> {

            List<Account> accounts = accountRepository.getAllAccounts();

            ctx.json(accounts);
        });

        app.get("/transactions", ctx -> {

            List<Transaction> transactions =
                    transactionRepository.getAllTransactions();

            ctx.json(transactions);
        });
        app.start(7070);
    }
}