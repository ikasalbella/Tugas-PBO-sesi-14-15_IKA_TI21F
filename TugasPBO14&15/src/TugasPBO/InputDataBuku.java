package TugasPBO;

import java.util.Scanner;


public class InputDataBuku {
    public static void InputData(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             INPUT DATA BUKU            ");
        System.out.println("==========================================");
        
        System.out.print("ID Buku : ");
        String id_buku = sc.nextLine();
        System.out.print("Judul Buku : ");
        String judul_buku = sc.nextLine();
        System.out.print("Pengarang : ");
        String pengarang = sc.nextLine();
        System.out.print("ID Peminjaman : ");
        String id_peminjaman = sc.nextLine();
        
        try{
            Database.DataBuku(id_buku, judul_buku, pengarang, id_peminjaman);
        }
        catch(Exception e){
            System.out.println("Error: " +e.getMessage());
            e.printStackTrace();
        }
    }
}
