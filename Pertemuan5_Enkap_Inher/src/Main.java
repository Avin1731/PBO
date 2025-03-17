public class Main {
    public static void main(String[] args) {
        Kantor kantor = new Kantor();

        // Menambahkan beberapa pegawai
        Directer direktur1 = new Directer("Andi", 45, 5, kantor);
        direktur1.tambahKebijakan("Efisiensi Biaya");
        direktur1.tambahKebijakan("Transformasi Digital");

        Directer direktur2 = new Directer("Rina", 50, 7, kantor);
        direktur2.tambahKebijakan("Digitalisasi");
        direktur2.tambahKebijakan("Peningkatan Kinerja");

        Manager manager1 = new Manager("Siti", 35, 3, 10);
        Manager manager2 = new Manager("Doni", 38, 4, 15);

        Supervisor supervisor1 = new Supervisor("Rama", 32, 4, 6);
        Supervisor supervisor2 = new Supervisor("Fina", 30, 3, 8);

        Operasional op1 = new Operasional("Budi", 28, 2);
        Operasional op2 = new Operasional("Wati", 30, 3);
        Operasional op3 = new Operasional("Rudi", 27, 1);
        Operasional op4 = new Operasional("Tini", 25, 2);

        kantor.tambahPegawai(direktur1);
        kantor.tambahPegawai(direktur2);
        kantor.tambahPegawai(manager1);
        kantor.tambahPegawai(manager2);
        kantor.tambahPegawai(supervisor1);
        kantor.tambahPegawai(supervisor2);
        kantor.tambahPegawai(op1);
        kantor.tambahPegawai(op2);
        kantor.tambahPegawai(op3);
        kantor.tambahPegawai(op4);

        // Menampilkan daftar pegawai sebelum dihapus
        kantor.tampilkanPegawai();

        // Menampilkan rata-rata gaji
        System.out.printf("\n💰 Rata-rata Gaji: Rp%,.2f\n", kantor.hitungRataRataGaji());

        // Menghapus pegawai berdasarkan nama
        System.out.println("\n🗑️ Menghapus pegawai: Budi");
        kantor.removePegawai("Budi");

        // Menampilkan daftar pegawai setelah penghapusan
        kantor.tampilkanPegawai();

        // Menampilkan rata-rata gaji setelah penghapusan
        System.out.printf("\n💰 Rata-rata Gaji Setelah Penghapusan: Rp%,.2f\n", kantor.hitungRataRataGaji());

        // Menampilkan daftar kebijakan kantor
        kantor.tampilkanKebijakan();
    }
}

//Hilarius Christiano Avin PAliling
//TRPL24 UGM Semester 2
//542159