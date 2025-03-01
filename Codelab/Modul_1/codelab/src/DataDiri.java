import java.util.Scanner;
import java.time.LocalDate;

public class DataDiri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Jenis Kelamin (L/P): ");
        char jenisKelaminChar = scanner.next().charAt(0);

        System.out.print("Masukkan Tahun Lahir: ");
        int tahunLahir = scanner.nextInt();

        scanner.close();

        String jenisKelamin;
        if (jenisKelaminChar == 'L' || jenisKelaminChar == 'l') {
            jenisKelamin = "Laki-laki";
        } else if (jenisKelaminChar == 'P' || jenisKelaminChar == 'p') {
            jenisKelamin = "Perempuan";
        } else {
            jenisKelamin = "Tidak diketahui";
        }

        int tahunSekarang = LocalDate.now().getYear();
        int umur = tahunSekarang - tahunLahir;

        System.out.println("\nData Diri Pengguna:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Umur: " + umur + " tahun");
    }
}
