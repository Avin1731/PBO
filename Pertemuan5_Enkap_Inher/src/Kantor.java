import java.util.ArrayList;

public class Kantor {
    private ArrayList<Pegawai> daftarPegawai = new ArrayList<>();
    private ArrayList<String> daftarKebijakan = new ArrayList<>();

    public void tambahPegawai(Pegawai pegawai) {
        daftarPegawai.add(pegawai);
    }

    public void removePegawai(String nama) {
        daftarPegawai.removeIf(pegawai -> pegawai.getNama().equalsIgnoreCase(nama));
    }

    public void tampilkanPegawai() {
        System.out.println("📌 Daftar Pegawai:");
        for (Pegawai pegawai : daftarPegawai) {
            System.out.println(pegawai.getInfo());
        }
    }

    public double hitungRataRataGaji() {
        if (daftarPegawai.isEmpty()) return 0;
        double totalGaji = 0;
        for (Pegawai pegawai : daftarPegawai) {
            totalGaji += pegawai.hitungSlipGaji();
        }
        return totalGaji / daftarPegawai.size();
    }

    public void tampilkanKebijakan() {
        System.out.println("\n📌 Daftar Kebijakan Kantor:");
        for (String kebijakan : daftarKebijakan) {
            System.out.println("- " + kebijakan);
        }
    }

    public int getJumlahPegawai() {
        return daftarPegawai.size();
    }

    public void tambahKebijakan(String kebijakan) {
        daftarKebijakan.add(kebijakan);
    }

}

//Hilarius Christiano Avin PAliling
//TRPL24 UGM Semester 2
//542159