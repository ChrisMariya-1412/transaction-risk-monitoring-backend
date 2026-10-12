package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    public List<Account> getAllAccounts() {

        List<Account> accounts = new ArrayList<>();

        String sql = "SELECT * FROM accounts";

        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String accountNumber = resultSet.getString("account_number");
                String name = resultSet.getString("name");
                double spendingLimit = resultSet.getDouble("spending_limit");

                Account account = new Account(
                        id,
                        accountNumber,
                        name,
                        spendingLimit
                );

                accounts.add(account);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return accounts;
    }
}