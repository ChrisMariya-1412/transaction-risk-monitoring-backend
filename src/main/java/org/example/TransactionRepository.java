package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    public List<Transaction> getAllTransactions() {

        List<Transaction> transactions = new ArrayList<>();

        String sql = "SELECT id, account_id, amount, merchant, transaction_time " +
                "FROM transactions";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Transaction transaction = new Transaction();

                transaction.setId(resultSet.getInt("id"));
                transaction.setAccountId(resultSet.getInt("account_id"));
                transaction.setAmount(resultSet.getBigDecimal("amount"));
                transaction.setMerchant(resultSet.getString("merchant"));

                if (resultSet.getTimestamp("transaction_time") != null) {
                    transaction.setTransactionTime(
                            resultSet.getTimestamp("transaction_time").toLocalDateTime()
                    );
                }

                transactions.add(transaction);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return transactions;
    }
}