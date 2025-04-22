public class Salesman extends Karyawan {
    private int penjualan;
    private int target;

    public Salesman(String nama, String departemen, char jenisKelamin) {
        super(nama, departemen, jenisKelamin);
    }

    public void setPenjualan(int penjualan) {
        this.penjualan = penjualan;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    @Override
    public int hitungTHR() {
        if (penjualan >= target) {
            return gaji * 2; // THR 2x gaji jika penjualan >= target
        } else {
            return gaji; // THR 1x gaji jika tidak mencapai target
        }
    }
}