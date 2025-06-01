package com.example.modul_6;

import java.util.Random;

public class PermainanTebakAngka {
    private int angkaRahasia;
    private int jumlahPercobaan;
    private final Random acak = new Random();

    public PermainanTebakAngka() {
        mulaiBaru();
    }

    public void mulaiBaru() {
        angkaRahasia = acak.nextInt(100) + 1;
        jumlahPercobaan = 0;
    }

    public HasilTebakan cek(int tebakan) {
        jumlahPercobaan++;
        if (tebakan < angkaRahasia) return HasilTebakan.TERLALU_KECIL;
        if (tebakan > angkaRahasia) return HasilTebakan.TERLALU_BESAR;
        return HasilTebakan.BENAR;
    }

    public int getJumlahPercobaan() {
        return jumlahPercobaan;
    }

    public enum HasilTebakan {
        TERLALU_KECIL, TERLALU_BESAR, BENAR
    }
}
