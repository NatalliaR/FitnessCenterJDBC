package com.solvd.fitness.dao;

import com.solvd.fitness.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseDao<T> {

    protected List<T> getMany(String sql, RsConsumer<T> rsConsumer) throws SQLException {

        Connection connection = ConnectionPool.get().getConnection();

        List<T> result = new ArrayList<>();

        try {
            try (PreparedStatement stm = connection.prepareStatement(sql)) {
                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        result.add(rsConsumer.accept(rs));
                    }
                }
            }
        } finally {
            ConnectionPool.get().releaseConnection(connection);
        }

        return result;
    }

    protected Optional<T> getOne(String sql, RsConsumer<T> rsConsumer) throws SQLException {

        Connection connection = ConnectionPool.get().getConnection();

        try {
            try (PreparedStatement stm = connection.prepareStatement(sql)) {
                try (ResultSet rs = stm.executeQuery()) {

                    if (rs.next()) {
                        return Optional.of(rsConsumer.accept(rs));
                    }
                }
            }
        } finally {
            ConnectionPool.get().releaseConnection(connection);
        }

        return Optional.empty();
    }

    protected interface RsConsumer<T> {

        T accept(ResultSet rs) throws SQLException;
    }
}
