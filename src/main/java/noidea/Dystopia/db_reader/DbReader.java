package noidea.Dystopia.db_reader;

import java.sql.*;

public class DbReader {

    private void go() {

        String dbUrl = "${postgres_url}";
        String query = "SELECT text, FROM dystopia_message ORDER by DATA";
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "12345";


    public String getMSG() {

        String SQL = "SELECT id, message FROM dystopia_message ORDER BY id DESC LIMIT 1";
//        String SQL = "SELECT message FROM dystopia_message LIMIT 1";

        String x = "";


        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            // display actor information
//            displayMSG(rs);


            x = displayMSG(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return x;

    }

    private String displayMSG(ResultSet rs) throws SQLException {
        StringBuilder sb = new StringBuilder();
        while (rs.next()) {
            sb.append(rs.getString("id")).append("\t").append(rs.getString("message")).append("\t");
//            System.out.println(rs.getString("id") + "\t"
//                    + rs.getString("message") + "\t");

        }
        return sb.toString();
    }

}



