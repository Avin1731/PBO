public class Supervisor extends Pegawai {
    private final int jumlahTim;

    public Supervisor(String nama, int umur, int lamaKerja, int jumlahTim) {
        super(nama, umur, lamaKerja, "Supervisor");
        this.setGaji(8000000);
        this.jumlahTim = jumlahTim;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Mengawasi: " + jumlahTim + " pegawai";
    }
}

//Hilarius Christiano Avin PAliling
//TRPL24 UGM Semester 2
//542159