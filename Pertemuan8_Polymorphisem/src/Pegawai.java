public class Pegawai extends Karyawan{

    public Pegawai(String nama, String departemen, char jenisKelamin){
        super(nama, departemen, jenisKelamin);
    }
    @Override
    public void setNip(int urutan) {
        this.nip = String.format("P%04d", urutan);
    }

    @Override
    public int hitungTHR() {
        return gaji;
    }
}