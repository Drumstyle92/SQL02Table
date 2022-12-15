import java.sql.*;

/**
 * @author Drumstyle92
 * Class that contains the entire code.
 */
public class Start {
    /**
     *
     * @param args Main parameter.
     * Main method that contains the connection with the database,
     * the creation of a table and the insertion of data in it.
     */
    public static void main(String[] args){

        Connection conn = null;

        try {

            // db parameters
            String url       ="jdbc:mysql://localhost:3306/newdb";
            String user      = "root";
            String password  = "Confusione1992";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);

            // table creation
            PreparedStatement createTable = conn.prepareStatement("CREATE TABLE IF NOT EXISTS students " +
                    "(student_id int(10) NOT NULL AUTO_INCREMENT," +
                    "last_name varchar(30)," +
                    "first_name varchar(30)," +
                    "CONSTRAINT students_pk PRIMARY KEY(student_id))");
            createTable.executeUpdate();
            System.out.println("-Create table-");

            // table data entry
            PreparedStatement insertTable = conn.prepareStatement("INSERT INTO students (last_name, first_name)" +
                    "VALUES ('Petrucci', 'Dino'),('Black', 'Joe'),('Galass', 'Ghigo'),('Ledfratangel', 'Matt')");
            insertTable.executeUpdate();
            System.out.println("-Table data entry-");

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(conn != null){
                conn.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
