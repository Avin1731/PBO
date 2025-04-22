public class Karyawan {
    protected String nama;
    protected String departemen;
    protected char jenisKelamin;
    protected int gaji = 0;
    protected int cuti = 12;
    protected String nip;

    public Karyawan(String nama, String departemen, char jenisKelamin){
        this.nama=nama;
        this.departemen=departemen;
        this.jenisKelamin=jenisKelamin;
    }

    public void setnip(int urutan) {
        // Ditentukan di subclass
    }
    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public void setCuti(int tambahanCuti) {
        this.cuti += tambahanCuti;
    }

    public void setCuti(String alasan) {
        if (alasan.equalsIgnoreCase("pernikahan")){
            this.cuti+=2;
        } else if (alasan.equalsIgnoreCase("persalinan") && jenisKelamin == 'P') {
            this.cuti+=90;
        } else {
            this.cuti+=3;
        }
    }

    public void setNip(int urutan) {
        String huruf = "";
        if (this instanceof Pegawai) huruf = "P";
        else if (this instanceof Manager) huruf = "M";
        else if (this instanceof Salesman) huruf = "S";

        this.nip = huruf + String.format("%04d", urutan);
    }

    public void displayInfo() {
        System.out.println("Jabatan : " + this.getClass().getSimpleName());
        System.out.println("Nama : " + nama);
        System.out.println("Departemen : " + departemen);
        System.out.println("NIP : " + nip);
        System.out.println("Gaji : " + gaji);
        System.out.println("Gaji : " + (hitungTHR()));
        System.out.println("Cuti : " + cuti);
        System.out.println("=====================================");
    }

    public int hitungTHR() {
        return gaji; // default: 1x gaji
    }
}
