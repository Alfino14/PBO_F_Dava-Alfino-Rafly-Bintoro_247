import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class manajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Menu Manajemen Stok =====");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1 -> tambahBarang(scanner, daftarBarang);
                case 2 -> tampilkanBarang(daftarBarang);
                case 3 -> kurangiStok(scanner, daftarBarang);
                case 0 -> {
                    running = false;
                    System.out.println("Terima kasih! Program berakhir.");
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }

    private static void tambahBarang(Scanner scanner, ArrayList<Barang> daftarBarang) {
        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan stok awal: ");
        try {
            int stok = scanner.nextInt();
            scanner.nextLine();
            if (stok < 0) {
                System.out.println("Stok tidak boleh negatif!");
                return;
            }
            daftarBarang.add(new Barang(nama, stok));
            System.out.println("Barang '" + nama + "' berhasil ditambahkan.");
        } catch (InputMismatchException e) {
            System.out.println("Input stok harus berupa angka!");
            scanner.nextLine();
        }
    }

    private static void tampilkanBarang(ArrayList<Barang> daftarBarang) {
        System.out.println("\n--- Daftar Barang ---");
        if (daftarBarang.isEmpty()) {
            System.out.println("Stok barang kosong.");
        } else {
            for (int i = 0; i < daftarBarang.size(); i++) {
                Barang barang = daftarBarang.get(i);
                System.out.println(i + ". Nama: " + barang.getNama() + ", Stok: " + barang.getStok());
            }
        }
    }

    private static void kurangiStok(Scanner scanner, ArrayList<Barang> daftarBarang) {
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada barang untuk dikurangi stoknya.");
            return;
        }

        System.out.println("\n--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = daftarBarang.get(i);
            System.out.println(i + ". " + barang.getNama() + " (Stok: " + barang.getStok() + ")");
        }

        try {
            System.out.print("Masukkan nomor indeks barang: ");
            int indeks = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Masukkan jumlah stok yang akan diambil: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();

            if (indeks < 0 || indeks >= daftarBarang.size()) {
                throw new IndexOutOfBoundsException();
            }
            if (jumlah <= 0) {
                System.out.println("Jumlah harus lebih dari 0.");
                return;
            }

            Barang barang = daftarBarang.get(indeks);
            if (jumlah > barang.getStok()) {
                throw new stokTidakCukupException("Stok untuk '" + barang.getNama() + "' hanya tersisa " + barang.getStok());
            }

            barang.setStok(barang.getStok() - jumlah);
            System.out.println("Stok barang '" + barang.getNama() + "' berhasil dikurangi. Sisa stok: " + barang.getStok());

        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeks yang dimasukkan tidak valid!");
        } catch (stokTidakCukupException e) {
            System.out.println(e.getMessage());
        }
    }
}
