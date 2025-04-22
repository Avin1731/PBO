public class Main {
    public static void main(String[] args) {
        Pegawai pegawai1=new Pegawai("Diza","HRD",'P');
        pegawai1.setGaji(1000000);
        pegawai1.setCuti(10);
        pegawai1.setNip(1);
        pegawai1.displayInfo();

        Pegawai pegawai2=new Pegawai("Raihan","Product",'L');
        pegawai2.setGaji(1500000);
        pegawai2.setCuti("pernikahan");
        pegawai2.setNip(2);
        pegawai2.displayInfo();

        Manager manager1=new Manager("Nayla","Operational",'P');
        manager1.setGaji(2000000);
        manager1.setCuti("persalinan");
        manager1.setNip(3);
        manager1.displayInfo();

        Salesman salesman1=new Salesman("Fauzan","Marketing",'L');
        salesman1.setGaji(2500000);
        salesman1.setTarget(100);
        salesman1.setPenjualan(120);
        salesman1.setCuti("persalinan");
        salesman1.setNip(4);
        salesman1.displayInfo();
    }
}