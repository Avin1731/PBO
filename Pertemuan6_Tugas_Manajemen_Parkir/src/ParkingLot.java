// ParkingLot.java
import java.util.*;

public class ParkingLot {
    private static final int MAX_WHEELS = 12;
    private static final int FLOORS = 5;
    private final Map<Integer, List<Vehicle>> parking;
    private final Map<String, Long> parkingTimes;
    private final Map<String, Integer> rates;

    public ParkingLot() {
        parking = new HashMap<>();
        parkingTimes = new HashMap<>();
        rates = new HashMap<>();
        rates.put("motor", 2000);
        rates.put("mobil", 5000);

        for (int i = 1; i <= FLOORS; i++) {
            parking.put(i, new ArrayList<>());
        }
    }

    public void displayStatus() {
        System.out.println("\nStatus Parkir:");
        for (int floor = 1; floor <= FLOORS; floor++) {
            List<Vehicle> vehicles = parking.get(floor);
            int totalWheels = vehicles.stream().mapToInt(Vehicle::getWheels).sum();
            int remainingWheels = MAX_WHEELS - totalWheels;
            System.out.println("Lantai " + floor + ": " + vehicles + " (Total roda: " + totalWheels + ", Sisa: " + remainingWheels + ")");
        }
    }

    public void addVehicle(Scanner scanner) {
        System.out.print("Masukkan tipe kendaraan (motor/mobil): ");
        String type = scanner.next().toLowerCase();
        if (!rates.containsKey(type)) {
            System.out.println("Tipe kendaraan tidak valid!");
            return;
        }
        int wheels = type.equals("motor") ? 2 : 4;
        System.out.print("Masukkan lantai parkir (1-5): ");
        int floor = scanner.nextInt();
        if (floor < 1 || floor > FLOORS) {
            System.out.println("Lantai tidak valid!");
            return;
        }

        int totalWheels = parking.get(floor).stream().mapToInt(Vehicle::getWheels).sum();
        if (totalWheels + wheels <= MAX_WHEELS) {
            System.out.print("Masukkan ID kendaraan: ");
            String id = scanner.next();
            parking.get(floor).add(new Vehicle(id, wheels));
            parkingTimes.put(id, System.currentTimeMillis());
            System.out.println("Kendaraan berhasil diparkir.");
        } else {
            System.out.println("Lantai penuh!");
        }
    }

    public void moveVehicle(Scanner scanner) {
        System.out.print("Masukkan ID kendaraan yang ingin dipindahkan: ");
        String id = scanner.next();
        System.out.print("Masukkan lantai asal: ");
        int fromFloor = scanner.nextInt();
        System.out.print("Masukkan lantai tujuan: ");
        int toFloor = scanner.nextInt();

        if (fromFloor < 1 || fromFloor > FLOORS || toFloor < 1 || toFloor > FLOORS) {
            System.out.println("Lantai tidak valid!");
            return;
        }

        List<Vehicle> fromList = parking.get(fromFloor);
        Vehicle vehicle = fromList.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
        if (vehicle == null) {
            System.out.println("Kendaraan tidak ditemukan di lantai asal!");
            return;
        }

        int totalWheels = parking.get(toFloor).stream().mapToInt(Vehicle::getWheels).sum();
        if (totalWheels + vehicle.getWheels() <= MAX_WHEELS) {
            fromList.remove(vehicle);
            parking.get(toFloor).add(vehicle);
            System.out.println("Kendaraan berhasil dipindahkan.");
        } else {
            System.out.println("Lantai tujuan penuh!");
        }
    }

    public void removeVehicle(Scanner scanner) {
        System.out.print("Masukkan ID kendaraan yang keluar: ");
        String id = scanner.next();
        System.out.print("Masukkan lantai kendaraan: ");
        int floor = scanner.nextInt();

        if (floor < 1 || floor > FLOORS) {
            System.out.println("Lantai tidak valid!");
            return;
        }

        List<Vehicle> list = parking.get(floor);
        Vehicle vehicle = list.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
        if (vehicle == null) {
            System.out.println("Kendaraan tidak ditemukan!");
            return;
        }

        list.remove(vehicle);
        Long entryTime = parkingTimes.remove(id);
        if (entryTime != null) {
            long duration = (System.currentTimeMillis() - entryTime) / (1000 * 60 * 60); // dalam jam
            int cost = (int) (duration * rates.get(vehicle.getWheels() == 2 ? "motor" : "mobil"));
            System.out.println("Biaya parkir untuk kendaraan " + id + ": Rp" + cost);
        } else {
            System.out.println("Data waktu parkir tidak ditemukan.");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan status parkir");
            System.out.println("2. Tambah kendaraan");
            System.out.println("3. Pindahkan kendaraan");
            System.out.println("4. Keluarkan kendaraan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> displayStatus();
                case 2 -> addVehicle(scanner);
                case 3 -> moveVehicle(scanner);
                case 4 -> removeVehicle(scanner);
                case 5 -> {
                    System.out.println("Program berhenti.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
