package com.fedorovigor.calculator.repository;

import com.fedorovigor.calculator.config.Datasource;
import com.fedorovigor.calculator.model.entity.ExpressionEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelativeDatabaseCalculatorDao implements CalculatorDao{

    @Override
    public ExpressionEntity save(ExpressionEntity entity) {
        String SAVE_SQL = """
                INSERT INTO expression (expression, answer) VALUES
                (?, ?)""";

        try (Connection con = Datasource.getConnection();
             PreparedStatement pst = con.prepareStatement( SAVE_SQL );
        ) {
            pst.setString(1, entity.getExpression());
            pst.setBigDecimal(2, entity.getResult());

            pst.executeUpdate();
        }
        catch (SQLException e ) {
            throw new RuntimeException("cant save entity [%s]".formatted(entity) +
                    "\n" + e);
        }

        return entity;
    }

    @Override
    public List<ExpressionEntity> getLast(int count, int skipLast) {
        String GET_LAST_SQL = """
                SELECT *
                FROM expression e
                ORDER BY e.id DESC
                LIMIT %s  OFFSET %s"""
                .formatted(count, skipLast);

        List<ExpressionEntity> result = new ArrayList<>();

        try (Connection con = Datasource.getConnection();
             PreparedStatement pst = con.prepareStatement( GET_LAST_SQL );
             ResultSet rs = pst.executeQuery();
        ) {
            ExpressionEntity expression;
            while (rs.next()) {
                expression = new ExpressionEntity();
                expression.setId(rs.getInt("id"));
                expression.setExpression(rs.getString("expression"));
                expression.setResult(rs.getBigDecimal("answer"));

                result.add(expression);
            }
        }
        catch (SQLException e ) {
            throw new RuntimeException("""
                     cant load entities
                     input values:  
                        count [%s]
                        skipLast [%s]
                    """
                    .formatted(count, skipLast) + e);
        }

        return result;
    }

    @Override
    public Integer getSize() {

        String GET_SIZE_SQL = """
               SELECT COUNT(*) 
               FROM expression e
               """;

        int result = 0;

        try (Connection con = Datasource.getConnection();
             PreparedStatement pst = con.prepareStatement( GET_SIZE_SQL );
             ResultSet rs = pst.executeQuery();
        ) {
            if (rs.next()) {
                result = rs.getInt(1);
            }
        }
        catch (SQLException e ) {
            throw new RuntimeException("cant calculate rows " +
                    "\n" + e);
        }

        return result;
    }
}
