package com.solvd.fitness.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectionPool {

    private static final String URL = "jdbc:mysql://localhost:3306/fc";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static final int INITIAL_POOL_SIZE = 1;
    private static final int MAX_POOL_SIZE = 1;

    private static final ConnectionPool INSTANCE = new ConnectionPool();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to register the driver", e);
        }
    }

    private final Queue<Connection> connectionPool = new LinkedList<>();
    private final List<Connection> usedConnections = new ArrayList<>();

    private ConnectionPool() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            connectionPool.add(createConnection());
        }
    }

    public static ConnectionPool get() {
        return INSTANCE;
    }

    private static Connection createConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create a connection", e);
        }
    }

    public synchronized Connection getConnection() {

        if (connectionPool.isEmpty()) {
            if (usedConnections.size() < MAX_POOL_SIZE) {
                connectionPool.add(createConnection());
            } else {
                throw new RuntimeException("No more connections allowed");
            }
        }

        Connection connection = connectionPool.poll();
        usedConnections.add(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        connectionPool.add(connection);
        usedConnections.remove(connection);
    }
}
