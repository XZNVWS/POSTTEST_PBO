#  LAPORAN POSTTEST 2 - Detailing Kendaraan

## 1. Identitas 
* **Nama**        : Devon Falen Pasae
* **NIM**         : 2409106055
* **Sistem**      : Sistem Manajemen Detailing Kendaraan

---

## 2. Detail Program
Sistem ini dikembangkan sebagai program berbasis Java yang dibuat untuk mengelola operasional pada usaha jasa perawatan/detailing kendaraan. Fokus pembuatan difokuskan pada penerapan siklus data **CRUD (Create, Read, Update, dan Delete)** secara interaktif melalui input pengguna.

Secara teknis, program ini mengadopsi prinsip Pemrograman Berorientasi Objek (OOP), di mana setiap aktivitas detailing diproses sebagai entitas mandiri melalui class Detailing. Untuk menjaga fleksibilitas penyimpanan, digunakan struktur __ArrayList__ yang memungkinkan basis data berkembang sesuai dengan jumlah transaksi yang diinput oleh pengguna.

---

## 3. Fitur Program
1. **Tambah Data / Create**: Menambahkan data transaksi.
2. **Daftar Data / Read**: Menampilkan data transaksi dengan format tabel.
3. **Edit Data / Update**: Mengubah detail transaksi.
4. **Hapus Data / Delete**: Menghapus data transaksi individual.

---

## 4. Output Program

- **Menu Utama**
<img src="POSTTEST_1/img_1.png" width="500">

- **Menu Tambah Data**
<img src="POSTTEST_1/img_2.png" width="500">

- **Menu Daftar Data**
<img src="POSTTEST_1/img_3.png" width="500">

- **Menu Edit Data**
<img src="POSTTEST_1/img_4.png" width="500">

- **Menu Hapus Data**
<img src="POSTTEST_1/img_5.png" width="500">

- **Opsi Keluar Program**
<img src="POSTTEST_1/img_6.png" width="500">

---

## 5. Dokumentasi Kode

**a. Deklarasi Variabel (Menjadi Private):**
```java
private String merk;
private String paket;
private int harga;
```

**b. Penambahan Metode Getter dan Setter**
```java
public String getMerk() {
    return merk;
}

public void setMerk(String merk) {
    this.merk = merk;
}

public String getPaket() {
    return paket;
}

public void setPaket(String paket) {
    this.paket = paket;
}

public int getHarga() {
    return harga;
}

public void setHarga(int harga) {
    if (harga < 0) {
        System.out.println("Harga tidak boleh negatif.");
        this.harga = 0;
    } else {
        this.harga = harga;
    }
}
```

**c. Main Program & Looping**
```java
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
```


**d. pilihPaket**
```java
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
```


**e. Switch-Case (Case 3 menggunakan Setter)**
```java
switch (menu) {
                case 1:
                    System.out.print("Masukkan Merk Kendaraan: ");
                    String merkBaru = scan.nextLine();
                    String[] infoPaket = new String[2];
                    pilihPaket(scan, infoPaket);

                    listData.add(new Detailing(merkBaru, infoPaket[0], Integer.parseInt(infoPaket[1])));
                    System.out.println("=> Data berhasil ditambahkan!");
                    break;

                case 2:
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

                case 3:
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

                            // Mengubah data melalui metode Setter (Encapsulation)
                            Detailing dataEdit = listData.get(idU);
                            dataEdit.setMerk(nMerk);
                            dataEdit.setPaket(nInfo[0]);
                            dataEdit.setHarga(Integer.parseInt(nInfo[1]));
                            
                            System.out.println("=> Data berhasil diperbarui!");
                        } else {
                            System.out.println("[!] Nomor urut tidak ditemukan.");
                        }
                    }
                    break;

                case 4:
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
```


## **6. Class**
Terdapat 2 Class pada program ini, yaitu:

a. **Main.class**
- Berisi logika utama program, pengelolaan menu melalui looping, dan implementasi CRUD menggunakan metode dari class Detailing.

b. **Detailing.java (+ Penerapan Encapsulation)**
- Berisi data detailing dengan atribut yang diisolasi menggunakan access modifier private dan diakses melalui metode Getter serta Setter.
```java
public class Detailing {
    private String merk;
    private String paket;
    private int harga;

    public Detailing(String merk, String paket, int harga) {
        this.merk = merk;
        this.paket = paket;
        this.harga = harga;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        if (harga < 0) {
            System.out.println("Harga tidak boleh negatif.");
            this.harga = 0;
        } else {
            this.harga = harga;
        }
    }

    public void tampilkanBaris(int no) {
        System.out.printf("| %-3d | %-20s | %-30s | Rp %-10d |\n",
                no, this.merk, this.paket, this.harga);
    }
}
```


