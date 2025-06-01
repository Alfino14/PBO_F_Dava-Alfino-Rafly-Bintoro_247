package com.example.modul_6;

import com.example.modul_6.PermainanTebakAngka;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class MainApp extends Application {

    private PermainanTebakAngka permainan;
    private TextField input;
    private Label umpanBalik;
    private Label infoPercobaan;
    private Button tombol;

    @Override
    public void start(Stage panggung) {
        permainan = new PermainanTebakAngka();

        Label judul = new Label("Tebak Angka 1–100");
        judul.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        input = new TextField();
        input.setPromptText("Masukkan angka di sini");
        input.setMaxWidth(180);

        tombol = new Button("Coba Tebak!");
        tombol.setOnAction(e -> aksiTombol());

        umpanBalik = new Label("Masukkan tebakannya!");
        infoPercobaan = new Label("Jumlah percobaan: 0");

        HBox barisInput = new HBox(10, input, tombol);
        barisInput.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, judul, umpanBalik, barisInput, infoPercobaan);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new javafx.geometry.Insets(20));

        Scene scene = new Scene(root, 320, 220);
        panggung.setScene(scene);
        panggung.setTitle("Tebak Angka");
        panggung.show();
    }

    private void aksiTombol() {
        if (tombol.getText().equals("Main Lagi")) {
            permainan.mulaiBaru();
            input.setDisable(false);
            input.clear();
            tombol.setText("Coba Tebak!");
            umpanBalik.setText("Masukkan tebakannya!");
            infoPercobaan.setText("Jumlah percobaan: 0");
            return;
        }

        int tebakan;
        try {
            tebakan = Integer.parseInt(input.getText());
            if (tebakan < 1 || tebakan > 100) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            umpanBalik.setText("Masukkan angka valid 1–100!");
            return;
        }

        PermainanTebakAngka.HasilTebakan hasil = permainan.cek(tebakan);
        infoPercobaan.setText("Jumlah percobaan: " + permainan.getJumlahPercobaan());

        switch (hasil) {
            case TERLALU_KECIL -> umpanBalik.setText("▼ Terlalu kecil!");
            case TERLALU_BESAR -> umpanBalik.setText("▲ Terlalu besar!");
            case BENAR -> {
                umpanBalik.setText("✔ Tebakan benar!");
                tombol.setText("Main Lagi");
                input.setDisable(true);
            }
        }

        input.clear();
        input.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
