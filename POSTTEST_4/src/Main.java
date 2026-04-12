import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void pilihPaket(Scanner input, String[] hasil) {
        String[] daftarPaket = {"Basic Wash", "Premium Wash", "Basic Detailing", "Full Detailing"};
        int[] daftarHarga = {25000, 50000, 75000, 100000};

        System.out.println("\n--- DAFTAR PAKET LAYANAN ---");
        for (int i = 0; i < daftarPaket.length; i++) {
            System.out.println((i + 1) + ". " + daftarPaket[i] + " | Rp" + daftarHarga[i]);
        }

        while (true) {
            System.out.print("Pilih nomor paket (1-4): ");
            int pil = input.nextInt();
            input.nextLine();

            if (pil >= 1 && pil <= 4) {
                hasil[0] = daftarPaket[pil - 1];
                hasil[1] = String.valueOf(daftarHarga[pil - 1]);
                break;
            } else {
                System.out.println("[!] Pilihan tidak valid.");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Detailing> listData = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int menu;

        do {
            System.out.println("\n=====================================================================");
            System.out.println("                SISTEM MANAJEMEN DETAILING MOTOR                     ");
            System.out.println("=====================================================================");
            System.out.println("1. Tambah Data Motor");
            System.out.println("2. Daftar Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar Program");
            System.out.print("Pilih Menu: ");
            menu = scan.nextInt();
            scan.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("\nPilih Jenis Motor:");
                    System.out.println("1. Motor Matic");
                    System.out.println("2. Motor Sport");
                    System.out.print("Pilihan: ");
                    int jenisMotor = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Masukkan Merk Motor: ");
                    String merkBaru = scan.nextLine();

                    String[] infoPaket = new String[2];
                    pilihPaket(scan, infoPaket);
                    int hargaAwal = Integer.parseInt(infoPaket[1]);

                    System.out.print("Apakah pelanggan memiliki Member? (y/n): ");
                    String isMember = scan.nextLine();

                    Detailing motorBaru;
                    if (jenisMotor == 1) {
                        System.out.print("Kapasitas Bagasi (Liter): ");
                        int bagasi = scan.nextInt(); scan.nextLine();
                        motorBaru = new MotorMatic(merkBaru, infoPaket[0], hargaAwal, bagasi);
                    } else {
                        System.out.print("Kapasitas Mesin (CC): ");
                        int cc = scan.nextInt(); scan.nextLine();
                        motorBaru = new MotorSport(merkBaru, infoPaket[0], hargaAwal, cc);
                    }

                    if (isMember.equalsIgnoreCase("y")) {
                        motorBaru.setHarga(hargaAwal, 0.1);
                        System.out.println("=> Diskon Member 10% diterapkan!");
                    } else {
                        motorBaru.setHarga(hargaAwal);
                    }

                    listData.add(motorBaru);
                    System.out.println("=> Data motor berhasil ditambahkan!");
                    break;

                case 2:
                    if (listData.isEmpty()) {
                        System.out.println("\n[!] Data masih kosong.");
                    } else {
                        System.out.println("\n" + "=".repeat(95));
                        System.out.printf("| %-3s | %-15s | %-20s | %-13s | %-25s |\n", "No", "Merk", "Paket", "Harga", "Keterangan Jenis");
                        System.out.println("-".repeat(95));
                        for (int i = 0; i < listData.size(); i++) {
                            listData.get(i).tampilkanBaris(i + 1);
                        }
                        System.out.println("=".repeat(95));
                    }
                    break;

                case 3:
                    if (listData.isEmpty()) {
                        System.out.println("\n[!] Tidak ada data.");
                    } else {
                        System.out.print("Masukkan nomor urut data: ");
                        int idU = scan.nextInt() - 1;
                        scan.nextLine();

                        if (idU >= 0 && idU < listData.size()) {
                            System.out.print("Merk Motor Baru: ");
                            String nMerk = scan.nextLine();
                            String[] nInfo = new String[2];
                            pilihPaket(scan, nInfo);

                            Detailing dataEdit = listData.get(idU);
                            dataEdit.setMerk(nMerk);
                            dataEdit.setPaket(nInfo[0]);
                            dataEdit.setHarga(Integer.parseInt(nInfo[1]));

                            System.out.println("=> Data berhasil diperbarui!");
                        } else {
                            System.out.println("[!] Nomor tidak valid.");
                        }
                    }
                    break;

                case 4:
                    if (listData.isEmpty()) {
                        System.out.println("\n[!] Tidak ada data.");
                    } else {
                        System.out.print("Masukkan nomor urut: ");
                        int idH = scan.nextInt() - 1;
                        if (idH >= 0 && idH < listData.size()) {
                            listData.remove(idH);
                            System.out.println("=> Data berhasil dihapus!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Program selesai.");
                    break;
            }
        } while (menu != 5);
    }
}