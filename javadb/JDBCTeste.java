package javadb;

import java.sql.DriverManager;

public class JDBCTeste {

    public static void main(String[] args) {

        String stringDeConexao = "jdbc:mysql://localhost/test";
        String user = "root";
        String password = "";

        try {

            //Class.forName("com.mysql.jdbc.Driver"); // precisa só em versões antigas

            DriverManager.getConnection(stringDeConexao, user, password);

            System.out.println("Conectado ao Banco de Dados");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}