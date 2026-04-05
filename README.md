#  LAPORAN POSTTEST 3 - Detailing Kendaraan

## 1. Identitas 
* **Nama**        : Devon Falen Pasae
* **NIM**         : 2409106055
* **Sistem**      : Sistem Manajemen Detailing Kendaraan

---

## 2. Detail Program
Sistem ini dikembangkan sebagai program berbasis Java untuk mengelola operasional jasa detailing yang kini difokuskan khusus pada kendaraan Motor. Program ini menerapkan siklus data CRUD (Create, Read, Update, dan Delete) dengan mengadopsi prinsip Pemrograman Berorientasi Objek (OOP) tingkat lanjut, yaitu Inheritance (Pewarisan).

Secara teknis, program menggunakan tipe Hierarchical Inheritance, di mana satu superclass (Detailing) diwarisi oleh dua subclass (MotorMatic dan MotorSport). Hal ini memungkinkan program untuk menyimpan atribut umum sekaligus atribut spesifik untuk setiap jenis motor. Penyimpanan data tetap menggunakan ArrayList untuk manajemen memori yang dinamis.

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

## 5. Struktur Class Baru

1. **Main.class**: Mengatur alur logika program dan interaksi pengguna (Looping & Switch-Case).

2. **Detailing.java (Superclass)**: Dasar dari semua objek detailing yang menyimpan data umum kendaraan motor.

3. **MotorMatic.java (Subclass)**: Spesialisasi untuk motor matic dengan tambahan atribut kapasitas bagasi.

4. **MotorSport.java (Subclass)**: Spesialisasi untuk motor sport dengan tambahan atribut kapasitas mesin (CC).

## 6. Dokumentasi Kode

**a. Main Program**
```java
System.out.println("1. Tambah Data Motor");
// ... menu lainnya ...
case 1:
    System.out.println("\nPilih Jenis Motor: 1. Matic | 2. Sport");
    int jenisMotor = scan.nextInt();
    scan.nextLine();

    System.out.print("Masukkan Merk Motor: ");
    String merkBaru = scan.nextLine();
    // ... pilih paket ...

    if (jenisMotor == 1) {
        System.out.print("Kapasitas Bagasi (Liter): ");
        int bagasi = scan.nextInt();
        listData.add(new MotorMatic(merkBaru, info[0], harga, bagasi));
    } else if (jenisMotor == 2) {
        System.out.print("Kapasitas Mesin (CC): ");
        int cc = scan.nextInt();
        listData.add(new MotorSport(merkBaru, info[0], harga, cc));
    }
    break;
```

**b. Superclass: Detailing.Java**
```java
public class Detailing {
    protected String merk;
    protected String paket;
    protected int harga;

    public Detailing(String merk, String paket, int harga) {
        this.merk = merk;
        this.paket = paket;
        this.harga = harga;
    }
    
    // Getter dan Setter ...

    public void tampilkanBaris(int no) {
        System.out.printf("| %-3d | %-15s | %-20s | Rp %-10d | %-20s |\n",
                no, this.merk, this.paket, this.harga, "-");
    }
}
```


**c. Subclass: MotorMatic.java & MotorSport.java**
```java
public class MotorMatic extends Detailing {
    private int kapasitasBagasi;

    public MotorMatic(String merk, String paket, int harga, int kapasitasBagasi) {
        super(merk, paket, harga);
        this.kapasitasBagasi = kapasitasBagasi;
    }

    @Override
    public void tampilkanBaris(int no) {
        System.out.printf("| %-3d | %-15s | %-20s | Rp %-10d | Matic (Bagasi: %dL) |\n",
                no, merk, paket, harga, kapasitasBagasi);
    }
}

public class MotorSport extends Detailing {
    private int kapasitasMesin;

    public MotorSport(String merk, String paket, int harga, int kapasitasMesin) {
        super(merk, paket, harga);
        this.kapasitasMesin = kapasitasMesin;
    }

    @Override
    public void tampilkanBaris(int no) {
        System.out.printf("| %-3d | %-15s | %-20s | Rp %-10d | Sport (Mesin: %dcc) |\n",
                no, merk, paket, harga, kapasitasMesin);
    }
}
```


**d. Switch-Case (Case 3 menggunakan Setter)**
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


