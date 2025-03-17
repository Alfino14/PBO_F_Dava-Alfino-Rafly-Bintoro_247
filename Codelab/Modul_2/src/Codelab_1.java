class Hewan{
    //atribute hewan masseh
    String nama;
    String jenis;
    String suara;

    //ini bagian konstraktor massehh
    public Hewan(String nama, String jenis, String suara) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
    }

    //ini baru metodd ;)
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Suara: " + suara + '\n');
    }
}
public class Codelab_1 {
    public static void main(String[] args){

        //ini deklarasi object
    Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Nyann~~");
    Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-woof!!");

    //implementasi metod dan object
    hewan1.tampilkanInfo();
    hewan2.tampilkanInfo();
    }
}