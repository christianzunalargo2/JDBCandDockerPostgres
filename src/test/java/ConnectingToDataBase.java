import org.testng.annotations.*;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Properties;

public class ConnectingToDataBase {


    private Connection conn;

    // in docker we have a db running after the following code:
    // docker run --name postgres-db -e POSTGRES_PASSWORD=docker -p 5432:5432 -d postgres

//    @BeforeMethod
    @Test
    public void setUp() throws SQLException {
        String url = "jdbc:postgresql://localhost/postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","docker");
        conn = DriverManager.getConnection(url, props);
    }

    @Test
    public void testQuery() throws SQLException {
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * from ;");
//        while (rs.next()) {
//            System.out.println(rs.getString(2));
//        }
//        st.close();
//        rs.close();
    }
}
