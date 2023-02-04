package TugasPBO;

import java.util.Scanner;


public class InputDataPeminjaman {
    public static void InputData(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             INPUT DATA PEMINJAMAN             ");
        System.out.println("==============================================");
        
        System.out.print("ID Peminjaman : ");
        String id_peminjaman = sc.nextLine();
        System.out.print("Nama : ");
        String nama = sc.nextLine();
        System.out.print("Judul Buku : ");
        String judul_buku = sc.nextLine();
        System.out.print("Jenis Kelamin (L/P) : ");
        String jenis_kelamin = sc.nextLine();
        System.out.print("ID Admin : ");
        String id_admin = sc.nextLine();
        
        try{
            Database.DataPeminjaman(id_peminjaman, nama, judul_buku, jenis_kelamin, id_admin);
        }
        catch(Exception e){
            System.out.println("Error: " +e.getMessage());
            e.printStackTrace();
        }
    }
}
