package br.com.fiap.clinica.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {
    private static final String URL = "oracle.fiap.com.br";
    private static final String USER = "RM98067";
    private static final String PASSWORD = "020205";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}