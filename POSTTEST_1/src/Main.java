import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void pilihPaket(Scanner input, String[] hasil) {
        String[] daftarPaket = {
                "Basic Wash",
                "Premium Wash",
                "Basic Wash + Basic Detailing",
                "Full Detailing"
        };
        int[] daftarHarga = {25000, 50000, 75000, 100000};

        System.out.println("\n--- DAFTAR PAKET LAYANAN ---");
        for (int i = 0; i < daftarPaket.length; i++) {
            System.out.println((i + 1) + ". " + daftarPaket[i] + " | Rp" + daftarHarga[i]);
        }

        while (true) {
            System.out.print("Pilih nomor paket (1-4): ");
            int pil = input.nextInt();
            input.nextLine(); // clear buffer

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
            System.out.println("\n==========================================");
            System.out.println("    SISTEM MANAJEMEN DETAILING MOBIL      ");
            System.out.println("==========================================");
            System.out.println("1. Tambah Data");
            System.out.println("2. Daftar Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar Program");
            System.out.print("Pilih Menu: ");
            menu = scan.nextInt();
            scan.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan Merk Kendaraan: ");
                    String merkBaru = scan.nextLine();

                    String[] infoPaket = new String[2];
                    pilihPaket(scan, infoPaket);

                    listData.add(new Detailing(merkBaru, infoPaket[0], Integer.parseInt(infoPaket[1])));
                    System.out.println("=> Data berhasil ditambahkan!");
                    break;

                case 2: // READ
                    if (listData.isEmpty()) {
                        System.out.println("\n[!] Data masih kosong.");
                    } else {
                        System.out.println("\n" + "=".repeat(75));
                        System.out.printf("| %-3s | %-20s | %-30s | %-13s |\n", "No", "Merk Kendaraan", "Paket Layanan", "Harga");
                        System.out.println("-".repeat(75));
                        for (int i = 0; i < listData.size(); i++) {
                            listData.get(i).tampilkanBaris(i + 1);
                        }
                        System.out.println("=".repeat(75));
                    }
                    break;

                case 3: // UPDATE
                    if (listData.isEmpty()) {
                        System.out.println("\n[!] Tidak ada data untuk diubah.");
                    } else {
                        System.out.print("Masukkan nomor urut data yang diubah: ");
                        int idU = scan.nextInt() - 1;
                        scan.nextLine();

                        if (idU >= 0 && idU < listData.size()) {
                            System.out.print("Merk Kendaraan Baru: ");
                            String nMerk = scan.nextLine();
                            String[] nInfo = new String[2];
                            pilihPaket(scan, nInfo);

                            listData.set(idU, new Detailing(nMerk, nInfo[0], Integer.parseInt(nInfo[1])));
                            System.out.println("=> Data berhasil diperbarui!");
                        } else {
                            System.out.println("[!] Nomor urut tidak ditemukan.");
                        }
                    }
                    break;

                case 4: // DELETE
                    if (listData.isEmpty()) {
                        System.out.println("\n[!] Tidak ada data untuk dihapus.");
                    } else {
                        System.out.print("Masukkan nomor urut yang akan dihapus: ");
                        int idH = scan.nextInt() - 1;
                        if (idH >= 0 && idH < listData.size()) {
                            listData.remove(idH);
                            System.out.println("=> Data berhasil dihapus!");
                        } else {
                            System.out.println("[!] Nomor urut tidak valid.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("[!] Pilihan menu salah.");
            }
        } while (menu != 5);
    }
}