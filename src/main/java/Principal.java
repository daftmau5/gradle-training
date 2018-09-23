
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		try {
			System.out.println("Iniciamos...");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "12345");
			System.out.println("OK");
			
			Statement s = con.createStatement();
			String query = "select * from tb_local;";
			s.executeQuery(query);
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println("---------------------------");
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
