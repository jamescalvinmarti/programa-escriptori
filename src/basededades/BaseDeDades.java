package basededades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class BaseDeDades {

    public static void main(String[] args) {
        
        try {
            
            Scanner sc = new Scanner(System.in);
            Helper helper = new Helper();
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BaseDeDades.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String user = "root";
            String psw = "admin";
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/immobiliaria?useSSL=false&serverTimezone=UTC", user, psw);
            

            boolean sortir = false;
            do{
                System.out.println("1- Imprimir totes les propietats.");
                System.out.println("2- Buscar propietat.");
                System.out.println("3- Sortir");
                
                int menu = Integer.parseInt(sc.nextLine());
                
                switch(menu){
                    case 1:
                        helper.imprimirBaseDeDades(con);
                        break;
                    case 2:
                        System.out.println("Escriu un nom: ");
                        String nom = sc.nextLine();
                        
                        helper.BuscarPropietat(nom, con);
                        break;
                    case 3:
                        sortir = true;
                        con.close();
                        break;
                    default:
                        sortir = true;
                        con.close();
                        break;
                }
            }while(!sortir);
            
        } catch (SQLException ex) {
            System.out.println("No s'ha pogut connectar a la base de dades.");
            System.out.println(ex);

        }
    }
    
}
