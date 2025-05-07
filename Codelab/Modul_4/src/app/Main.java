package app;
import perpustakaan.*;

public class Main {
    public static void main(String[] args) {

        NonFiksi buku1 = new NonFiksi("Sebuah Seni untuk Bersikap Bodo Amat", "Mark Manson", "Pengembangan Diri");
        Fiksi buku2 = new Fiksi("Selena", "Tere Liye", "Drama");

        buku1.displayInfo();
        buku2.displayInfo();

        Anggota anggota1 = new Anggota("Dava Alfino", "F247");
        Anggota anggota2 = new Anggota("Hamdan", "F223");

        System.out.println("\nAnggota: " + anggota1.getNama() + " (ID: " + anggota1.getIdAnggota() + ")");
        anggota1.pinjamBuku("Selena", 1);
        anggota1.kembalikanBuku();
        anggota1.pinjamBuku("Sebuah Seni untuk Bersikap Bodo Amat");

        System.out.println("\nAnggota: " + anggota2.getNama() + " (ID: " + anggota2.getIdAnggota() + ")");
        anggota2.pinjamBuku("Selena", 3);
        anggota2.kembalikanBuku();
    }
}
