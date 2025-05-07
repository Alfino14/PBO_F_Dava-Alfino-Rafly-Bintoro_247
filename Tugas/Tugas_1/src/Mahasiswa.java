class Mahasiswa extends User {

    public Mahasiswa(String nama, String nim) {
        super(nama, nim); // Memanggil constructor superclass
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return getNama().equals(inputNama) && getNim().equals(inputNim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login berhasil sebagai Mahasiswa");
        super.displayInfo(); // Menampilkan informasi dari superclass
    }
}