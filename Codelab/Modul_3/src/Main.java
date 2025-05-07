// Superclass KarakterGame
class KarakterGame {
    private String nama;
    private int kesehatan;

    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public void serang(KarakterGame target) {
        System.out.println(nama + " menyerang " + target.getNama() + "!");
    }
}

// Subclass Pahlawan
class Pahlawan extends KarakterGame {
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!"); //lari cui ada ultii
        target.setKesehatan(target.getKesehatan() - 20);
        System.out.println("Kesehatan agent " + target.getNama() + " sekarang adalah " + target.getKesehatan());
    }
}

// Subclass Musuh
class Musuh extends KarakterGame {
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite!");
        target.setKesehatan(target.getKesehatan() - 15);
        System.out.println("Kesehatan agent " + target.getNama() + " sekarang adalah " + target.getKesehatan());
    }
}

// Kelas Main
public class Main {
    public static void main(String[] args) {
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);

        // ini status kesehatan pertama
        System.out.println("Status Awal:");
        System.out.println(brimstone.getNama() + " memiliki Kesehatan: " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki Kesehatan: " + viper.getKesehatan());
        System.out.println();

        // Simulasi Pertarungan
        brimstone.serang(viper);
        viper.serang(brimstone);
    }
}
