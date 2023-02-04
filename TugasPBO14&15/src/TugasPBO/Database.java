package TugasPBO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Database {
    static final String jdbc = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/perpus";
    static final String username = "root";
    static final String password = "";
    
    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;
    static Statement state;
    
    public static String getPassword(String id_admin) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "SELECT pw FROM admin WHERE id_admin = (?)";
        ps = con.prepareStatement(query);
        ps.setString(1, id_admin);
        rs = ps.executeQuery();
        
        if(!rs.next()){
            return null;
        }
        else{
            return rs.getString(1).toString();
        }
    }
    
    public static void insertAkun(String id_admin, String nama_admin, String jenis_kelamin, String pw) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "INSERT INTO admin VALUES (?,?,?,?)";
        ps = con.prepareStatement(query);
        
        ps.setString(1, id_admin);
        ps.setString(2, nama_admin);
        ps.setString(3, jenis_kelamin);
        ps.setString(4, pw);
        
        if(ps.executeUpdate() > 0){
            System.out.println();
            System.out.println("Akun berhasil didaftarkan");
        }
        else{
            System.out.println("Akun gagal didaftarkan");
        }
    }
    
    public static void DataPeminjaman(String id_peminjaman, String nama, String judul_buku, String jenis_kelamin, String id_admin) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "INSERT INTO peminjaman VALUES (?,?,?,?,?)";
        ps = con.prepareStatement(query);
        
        ps.setString(1, id_peminjaman);
        ps.setString(2, nama);
        ps.setString(3, judul_buku);
        ps.setString(4, jenis_kelamin);
        ps.setString(5, id_admin);
        
        if(ps.executeUpdate() > 0){
            InputDataBuku.InputData();
        }
        else{
            System.out.println("Data Gagal Diinput");
        }
    }
    
    public static void DataBuku(String id_buku, String judul_buku, String pengarang, String id_peminjaman) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "INSERT INTO buku VALUES (?,?,?,?)";
        ps = con.prepareStatement(query);
        
        ps.setString(1, id_buku);
        ps.setString(2, judul_buku);
        ps.setString(3, pengarang);
        ps.setString(4, id_peminjaman);
        
        if(ps.executeUpdate() > 0){
            System.out.println();
            System.out.println("Data Berhasil Diinput");
        }
        else{
            System.out.println("Data Gagal Diinput");
        }
    }
    
    public static void ShowDataPeminjaman() throws Exception{
        int no = 0;
        try{
            Class.forName(jdbc);
            con = DriverManager.getConnection(url, username, password);
            state = con.createStatement();
            String query = "SELECT peminjaman.*, buku.* FROM peminjaman INNER JOIN buku ON peminjaman.id_peminjaman=buku.id_peminjaman";
            rs = state.executeQuery(query);
            
            while(rs.next()){
                no++;
                System.out.println("No."+ no);
                System.out.println("ID Peminjaman      : " + rs.getString("id_peminjaman"));
                System.out.println("Nama               : " + rs.getString("nama"));
                System.out.println("Jenis Kelamin      : " + rs.getString("jenis_kelamin"));
                System.out.println("ID Admin           : " + rs.getString("id_admin"));
                System.out.println("ID Buku            : " + rs.getString("id_buku"));
                System.out.println("Judul Buku         : " + rs.getString("judul_buku"));
                System.out.println("Pengarang          : " + rs.getString("pengarang"));
                System.out.println("-------------------------------------------------------");
            } 
        }
        catch(Exception ex){
            ex.printStackTrace();
        } 
    }

    
}
