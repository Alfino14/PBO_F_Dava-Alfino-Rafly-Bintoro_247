import java.util.Scanner;

class LoginSystem {
    public static void main(String[] args) {
        Scanner inputanji = new Scanner(System.in);
        Admin admin = new Admin("Alpin", "202410370110247", "Admin247", "Password247");
        Mahasiswa mahasiswa = new Mahasiswa("Alpin", "247");

        while (true) {
            System.out.println("Pilih menu login: ");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Exit");
            System.out.print("Masukkan pilihan: ");

            int pilihan = inputanji.nextInt();
            inputanji.nextLine(); // Consume newline

            if (pilihan == 3) {
                System.out.println("Exiting the system.");
                break;
            }

            if (pilihan != 1 && pilihan != 2) {
                System.out.println("Pilihan tidak valid mas, dicobi maleh. \n");
                continue;
            }

            if (pilihan == 1) {
                System.out.print("Username: ");
                String inputUsername = inputanji.nextLine();
                System.out.print("Password: ");
                String inputPassword = inputanji.nextLine();

                if (admin.login(inputUsername, inputPassword)) {
                    admin.displayInfo();
                } else {
                    System.out.println("Login gagal. Silakan coba lagi.");
                }
            } else if (pilihan == 2) {
                System.out.print("Nama: ");
                String inputNama = inputanji.nextLine();
                System.out.print("NIM: ");
                String inputNim = inputanji.nextLine();

                if (mahasiswa.login(inputNama, inputNim)) {
                    mahasiswa.displayInfo();
                } else {
                    System.out.println("Login gagal mas. Silakan coba lagi.");
                }
            }
        }
        inputanji.close();
    }
}