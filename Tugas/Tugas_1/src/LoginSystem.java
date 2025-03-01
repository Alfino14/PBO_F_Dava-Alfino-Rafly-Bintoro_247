import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String username = "Admin247";
        String password = "Password247";

        String mhsUsername = "ALfin";
        String nim = "202410370110247";

        System.out.println("Pilih Login: ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");

        int choice;

        if (input.hasNextInt()) {
            choice = input.nextInt();
            input.nextLine();
        } else {
            System.out.println("Erorrrrrrr");
            input.close();
            return;
        }

        if (choice == 1){
            while (true){
                System.out.print("Masukkan username: ");
                String inputUsername = input.nextLine();
                System.out.print("Masukkan password: ");
                String inputPassword = input.nextLine();

                if (inputUsername.equals(username) && inputPassword.equals(password)){
                    System.out.println("Login Admin berhasil!");
                    break;
                } else {
                    System.out.println("Coba lagi kang");
                }
            }
        } else if(choice == 2){
            while (true){
                System.out.print("Masukkan Nama: ");
                String inputMhs = input.nextLine();
                System.out.print("Masukkan NIM: ");
                String inputNim = input.nextLine();

                if (inputMhs.equals(mhsUsername) && inputNim.equals(nim)){
                    System.out.println("Login Mahasiswa berhasil!");
                    break;
                } else {
                    System.out.println("Coba meneh kang");
                }
            }
        } else {
            System.out.println("Inputmu Salahh kangg");
        }
        input.close();
    }
}