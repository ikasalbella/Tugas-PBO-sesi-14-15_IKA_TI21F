package TugasPBO;

import java.util.Scanner;


public class DaftarAdmin {
    public static void DaftarAdmin(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             DAFTAR AKUN ADMIN             ");
        System.out.println("=============================================");
        
        System.out.print("Username : ");
        String id_admin = sc.nextLine();
        System.out.print("Password : ");
        String pw = sc.nextLine();
        System.out.print("Nama Admin : ");
        String nama_admin = sc.nextLine();
        System.out.print("Jenis Kelamin (L/P) : ");
        String jenis_kelamin = sc.nextLine();
        
        try{
            Database.insertAkun(id_admin, nama_admin, jenis_kelamin, pw);
            System.out.println("Tolong ingat username anda");
            System.out.println("Username anda " + id_admin);
        }
        catch(Exception e){
            System.out.println("Error: " +e.getMessage());
            e.printStackTrace();
        }
    }
}
