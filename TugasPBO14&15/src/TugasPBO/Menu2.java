package TugasPBO;

import java.util.Scanner;


public class Menu2 {
    static void menuForm() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             MENU UTAMA ADMIN             ");
        System.out.println("==========================================");
        System.out.println("1. Input Data Peminjaman");
        System.out.println("2. Melihat Data Peminjaman");
        System.out.println("3. Update Data Peminjaman");
        System.out.println("4. Hapus Data Peminjaman");
        System.out.println("5. Keluar");
        System.out.println();
            
        System.out.print("Pilihan [1/2/3/4/5] = ");
        int pilih = sc.nextInt();
            
        if(pilih == 1){
            InputDataPeminjaman.InputData();
        }
        else if(pilih == 2){
            Database.ShowDataPeminjaman();
        }
        else if(pilih == 3){
            UpdateData.update();
        }
        else if(pilih == 4){
            DeleteData.Delete();
        }
        else if(pilih == 5){
            System.exit(0);
        }
        else{
            System.out.println("Silahkan masukkan input yang benar");
            System.out.println();
            menuForm();
        }
        
        try{
            menuForm();
        }
        catch(Exception e){
            System.out.println("Ada Sebuah Kesalahan");
            System.out.println("Error Message : " +e.getMessage());
            e.printStackTrace();
        }
    }
}