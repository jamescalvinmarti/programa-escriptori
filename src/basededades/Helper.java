package basededades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper {

    public Helper() {

    }
    
    public void imprimirBaseDeDades(Connection con){
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM properties");
            
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                String city = result.getString("city");
                int price = result.getInt("price");
                
                System.out.println("ID: " + id + ", Nom: " + name + ", city: " + city + ", Preu: " + price);
                
            }
            
            result.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Hi ha hagut un error.");
        }
    }
 
    public void BuscarPropietat(String n, Connection con) {
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM properties WHERE name LIKE " + "'%" + n + "%'");

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String city = result.getString("city");
                int price = result.getInt("price");

                System.out.println("ID: " + id + ", Nom: " + name + ", city: " + city + ", Preu: " + price);

            }

            result.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
