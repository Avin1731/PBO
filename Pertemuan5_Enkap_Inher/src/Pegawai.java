import java.text.NumberFormat;
import java.util.Locale;

public class Pegawai {
    private final String nama;
    private final int umur;
    private final int lamaKerja;
    private double gaji; // Private gaji
    private final String jabatan; // Jabatan ditambahkan

    public Pegawai(String nama, int umur, int lamaKerja, String jabatan) {
        this.nama = nama;
        this.umur = umur;
        this.lamaKerja = lamaKerja;
        this.jabatan = jabatan;
        this.gaji = 0; // Default 0, bisa diubah oleh Manager
    }

    // Setter gaji
    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    // Menghitung total gaji dengan lama kerja
    public double hitungSlipGaji() {
        return gaji * lamaKerja;
    }

    // Format angka ke Rupiah
    private String formatRupiah(double angka) {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return formatRupiah.format(angka);
    }

    public String getInfo() {
        return "Nama: " + nama + ", Jabatan: " + jabatan + ", Umur: " + umur +
                ", Lama Kerja: " + lamaKerja + " tahun, Gaji: " + formatRupiah(hitungSlipGaji());
    }

    public String getNama() {
        return this.nama;
    }

}

//Hilarius Christiano Avin PAliling
//TRPL24 UGM Semester 2
//542159