/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;
import java.util.*;
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;
public class Perpustakaan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     // menggunakan scanner dan menyimpan apa yang diketik di variabel nama
        Login login = new Login();
        login.prosesLogin();

        Dashboard dashboard = new Dashboard();
        dashboard.showDashboard();
    }
}   

interface Navigation {
    void showNavigation();
}

class Dashboard implements Navigation {
   
    @Override
    public void showNavigation() {
        System.out.println("--------MENU-------");
        System.out.println("===================");
        System.out.println("1. Tambah Data Buku");
        System.out.println("2. Edit Data Buku");
        System.out.println("3. Hapus Data Buku");
        System.out.println("4. Tampilkan Data Buku");
        System.out.println("5. Detail Data Buku");
        System.out.println("6. Exit");
        System.out.println("Ketik Angka Untuk Memilih");
    }
    public void showDashboard() {
        Buku buku = new Buku();
        boolean exit = true;

        Scanner input = new Scanner(System.in);

        while(exit) {
           showNavigation();
           String pilih = input.nextLine();

           switch(pilih){
               case "1" ->{ 
                   System.out.println("Tambah data Buku : ");
                   String tambah = input.nextLine();
                   buku.tambahBuku(tambah);
                   break;
               }

               case "2" -> {
                   System.out.println("Buku Yang Mau di Edit : ");
                   String bukuLama = input.nextLine();
                   System.out.println("Di ubah menjadi :");
                   String bukuBaru = input.nextLine();
                   buku.editBuku(bukuLama, bukuBaru);
                   break;
               }


               case  "3"->{ 
                   System.out.println("Hapus Data Buku");
                   String hapus = input.nextLine();
                   buku.hapusBuku(hapus);
                   break;
               }

               case  "4" ->{ 
                   System.out.println("Tampilkan data Buku");
                   buku.tampilDataBuku();
                   break;
               }

               case  "5" ->{ 
                   System.out.println("Detail Buku");
                   Detail detail = new Detail();
                   detail.tampilkanDetail();
                   detail.tampilkanDetail("20000");
                   break;
               }
               default -> {
                   exit = false;
               }
           }
        }
   }
}

class Buku extends Pustakawan {
    List<String> Buku = new ArrayList<>();
    public Object buku;
    
    
    public Buku()
    {
      Buku.add("Matematika");
      Buku.add("Pancasila");
      Buku.add("Kimia");
    }
    
    public void tambahBuku(String buku)
    {
        Buku.add(buku);
        System.out.println("Berhasil Menambahkan Buku "+buku );
    }
    
    public void hapusBuku(String buku)
    {
        Buku.remove(buku);
        System.out.println("Berhasil Menghapus"+buku );
    }
    
    public void editBuku(String bukuLama , String bukuEdit)
    {
        Buku.remove(bukuLama);
        Buku.add(bukuEdit);
        System.out.println("Edit Buku"+bukuLama+"Menjadi"+bukuEdit);        
    }
    
    public void tampilDataBuku()
    {
        for(String buku : Buku){
            System.out.println(buku+", ");
        }
        
    }
}
class Pustakawan {
    
    public boolean loginDB(String username, String password) {
        if(username.equals("adi")) {
            if (password.equals("123")) {
                return true;
            } else {
                System.out.println("Password salah");
            }
        } else if(username.equals("andy")) {
            if (password.equals("12345")) {
                return true;
            } else {
                System.out.println("Password salah");
            }
        } else if(username.equals("raka")) {
            if (password.equals("1111")) {
                return true;
            } else {
                System.out.println("Password salah");
            }
        } else {
            System.out.println("Username tidak terdaftar");
        }
        
        return false;
    }
    
    
    public void overTes() {
        System.out.println("tes");
    }
}


class Login extends Pustakawan {
    
    @Override
    public void overTes() {
        System.out.println("================");
    }
    public boolean prosesLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("       Login Staff      ");
        boolean notLogin = true;
        
        while (notLogin) {

            System.out.print("Enter Username : ");
            String username = input.nextLine();

            Scanner input2 = new Scanner(System.in);
            System.out.print("Enter Password : ");
            String password = input2.nextLine();

            if (this.loginDB(username, password) == true) {
                notLogin = false;
            }
           
        }
        
        return true;
 
    }
}

class Detail{
    String detil = "25000";
    public void tampilkanDetail(){
        System.out.println("Pengarang Buku Matematika: Dani");
    }
    
    public void tampilkanDetail(String detil){
        System.out.println("Harga Buku Matematika : "+detil);
    }
}