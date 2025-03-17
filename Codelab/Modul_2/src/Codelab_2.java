class RekeningBank {
    String nomorRekening;
    String namaPemilik;
    Double saldo;

    public RekeningBank(String nomorRekening, String namaPemilik, Double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: " + saldo + "\n");
    }

    public void setorUang(double jumlah) {
        if (jumlah > 0){
            saldo += jumlah;
            System.out.println(namaPemilik + " menyetor Rp" + jumlah + "saldo sekarang: Rp" + saldo);
        } else {
            System.out.println("Duitmu minus kangg");
        }
    }

    public void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) saldo sekarang: Rp" + saldo + "\n");
        } else if (jumlah > saldo) {
            System.out.println("\n" + namaPemilik + " menarik Rp" + jumlah + ". (Gagal, saldo mu kurang kang) saldo saat inoi: Rp" + saldo);
        } else {
            System.out.println("Jumlah penarikan harus lebih dari nol jii");
        }
    }
}

public class Codelab_2 {
    public static void main (String[] args) {
        RekeningBank rekening1 = new RekeningBank("202410370110247", "Alpin Tampan", 20000.0 );
        RekeningBank rekening2 = new RekeningBank("202410370110235", "Surya Gacorr kang ah", 2500000.0 );

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        rekening1.setorUang(200000.0);
        rekening2.setorUang(500000.0);

        rekening1.tarikUang(500000.0);
        rekening2.tarikUang(1000000.0);

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}