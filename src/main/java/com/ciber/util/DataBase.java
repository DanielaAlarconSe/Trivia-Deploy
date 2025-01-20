package com.ciber.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    // Variables para la conexión (pueden configurarse desde Spring o variables de entorno)
    private static final String DB_URL = System.getenv("DB_URL");
    private static final String DB_USERNAME = System.getenv("DB_USERNAME");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    /**
     * Obtiene una conexión directa a la base de datos utilizando DriverManager.
     */
    public Connection getConexion() {
        Connection conexion = null;
        try {
            // Registrar el driver de PostgreSQL (opcional desde Java 6+ si está en el classpath)
            Class.forName("org.postgresql.Driver");

            // Crear la conexión utilizando las variables de entorno
            conexion = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (Exception e) {
            StringWriter stack = new StringWriter();
            e.printStackTrace(new PrintWriter(stack));
        }
        return conexion;
    }

    /**
     * Cierra la conexión de la base de datos.
     */
    public void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                StringWriter stack = new StringWriter();
                e.printStackTrace(new PrintWriter(stack));
            }
        }
    }

    /**
     * Cierra un PreparedStatement.
     */
    public void cerrarConexion(PreparedStatement sentencia) {
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException e) {
                StringWriter stack = new StringWriter();
                e.printStackTrace(new PrintWriter(stack));
            }
        }
    }

    /**
     * Cierra un Statement.
     */
    public void cerrarConexion(Statement sentencia) {
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException e) {
                StringWriter stack = new StringWriter();
                e.printStackTrace(new PrintWriter(stack));
            }
        }
    }

    /**
     * Cierra un ResultSet.
     */
    public void cerrarConexion(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                StringWriter stack = new StringWriter();
                e.printStackTrace(new PrintWriter(stack));
            }
        }
    }
}
