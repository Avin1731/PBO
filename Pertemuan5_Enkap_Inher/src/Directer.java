public class Directer extends Pegawai {
    private final Kantor kantor;

    public Directer(String name, int umur, int lamaKerja, Kantor kantor) {
        super(name, umur, lamaKerja, "Directer");
        this.kantor = kantor;
        this.setGaji(20000000);
    }

    public void tambahKebijakan(String Kebijakan) {
        kantor.tambahKebijakan(Kebijakan);
    }
}

//Hilarius Christiano Avin PAliling
//TRPL24 UGM Semester 2
//542159