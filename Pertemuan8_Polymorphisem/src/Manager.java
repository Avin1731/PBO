public class Manager extends Karyawan {
    public Manager(String nama, String departemen, char jenisKelamin){
        super(nama, departemen, jenisKelamin);
    }
    @Override
    public int hitungTHR() {
        return gaji*2; // 2x gaji
    }
}
