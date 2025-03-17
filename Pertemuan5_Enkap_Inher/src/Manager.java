public class Manager extends Pegawai {
    private final int jumlahBawahan;

    public Manager(String nama, int umur, int lamaKerja, int jumlahBawahan) {
        super(nama, umur, lamaKerja, "Manager");
        this.setGaji(10000000);
        this.jumlahBawahan = jumlahBawahan;
    }

    public void setGajiPegawai(Pegawai pegawai, double gajiBaru) {
        pegawai.setGaji(gajiBaru);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Mengelola: " + jumlahBawahan + " pegawai";
    }
}

//Hilarius Christiano Avin PAliling
//TRPL24 UGM Semester 2
//542159