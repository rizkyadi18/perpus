
package perpustakaan;
import java.util.*;
import javax.swing.*;



public class Perpustakaan {

    public static void main(String[] args) {
        
        gui g = new gui(500, 300);
        g.setVisible(true);

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

        try{
            while(exit) {
                showNavigation();

                int pilih = input.nextInt();
                input.nextLine();

                switch(Integer.valueOf(pilih)){
                    case 1 ->{ 
                        System.out.println("Tambah data Buku : ");
                        String tambah = input.nextLine();
                        buku.tambahBuku(tambah);
                        break;
                    }

                    case 2 -> {
                        System.out.println("Buku Yang Mau di Edit : ");
                        String bukuLama = input.nextLine();
                        System.out.println("Di ubah menjadi :");
                        String bukuBaru = input.nextLine();
                        buku.editBuku(bukuLama, bukuBaru);
                        break;
                    }


                    case  3 ->{ 
                        System.out.println("Hapus Data Buku");
                        String hapus = input.nextLine();
                        buku.hapusBuku(hapus);
                        break;
                    }

                    case  4 ->{ 
                        System.out.println("Tampilkan data Buku");
                        buku.tampilDataBuku();
                        break;
                    }

                    case  5 ->{ 
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
        }catch(InputMismatchException e){
            System.out.println("Error Format Input Angka 1 sampai 6");
        }
   }
}

class Buku extends Pustakawan {
    ArrayList<String> objBuku = new ArrayList<>();
    public Object buku;
    
    public ArrayList<String> all(){
        return objBuku;
    }
    public Buku()
    {
      objBuku.add("Matematika");
      objBuku.add("Pancasila");
      objBuku.add("Kimia");
    }
    
    public String tambahBuku(String buku)
    {
        objBuku.add(buku);
        return "Berhasil Menambahkan Buku "+buku ;
    }
    
    public String hapusBuku(String buku)
    {
        objBuku.remove(buku);
        return "Berhasil Menghapus"+buku;
    }
    
    public String editBuku(String bukuLama , String bukuEdit)
    {
        objBuku.remove(bukuLama);
        objBuku.add(bukuEdit);
        
        return "Edit Buku"+bukuLama+"Menjadi"+bukuEdit;
    }
    
    public String tampilDataBuku()
    {
        String data = "<html>";
        for(String buku : objBuku){
            data = data + buku+ "<br/>";
        }
        data = data + "</html>";
        
        return data;
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