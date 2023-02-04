package TugasPBO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class DeleteData {
    static final String jdbc = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/perpus";
    static final String username = "root";
    static final String password = "";
    
    static Connection con;
    static ResultSet rs;
    static ResultSet state;
    static PreparedStatement ps;
    
    public static void Delete() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             DELETE DATA PEMINJAMAN             ");
        System.out.println("===============================================");
        
        System.out.print("ID Peminjaman : ");
        String id_pelanggan = sc.nextLine();
        
        try{
            Class.forName(jdbc);
            con = DriverManager.getConnection(url, username, password);
            
            String query = "delete FROM peminjaman WHERE id_peminjaman=?";
            ps = con.prepareStatement(query);
            ps.setString(1, id_pelanggan);
            
            if(ps.executeUpdate() > 0){
                System.out.println("Proses Delete Berhasil");
            }
            else{
                System.out.println("Data Tidak Ditemukan");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }  
    }
}
