#  LAPORAN POSTTEST 5 - Detailing Kendaraan

## 1. Identitas 
* **Nama**        : Devon Falen Pasae
* **NIM**         : 2409106055
* **Sistem**      : Sistem Manajemen Detailing Kendaraan

---

## 2. Detail Program
Program ini telah ditingkatkan dengan mengimplementasikan prinsip Abstraction menggunakan Abstract Class dan Interface. Abstraction merupakan proses untuk menyembunyikan detail implementasi yang kompleks dan hanya menampilkan fungsi esensial kepada pengguna. Fokus utamanya adalah pada apa yang dilakukan sebuah objek, bukan bagaimana objek tersebut melakukannya.
---

## 3. Fitur Program
1. **Tambah Data / Create**: Menambahkan data transaksi.
2. **Daftar Data / Read**: Menampilkan data transaksi dengan format tabel.
3. **Edit Data / Update**: Mengubah detail transaksi.
4. **Hapus Data / Delete**: Menghapus data transaksi individual.
5. **Sistem Diskon** **(Interface Implementation)**: Menggunakan interface untuk memisahkan logika pemberian diskon member secara formal.
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

2. **Diskonable.java (Interface)**: Berfungsi sebagai kontrak yang mengharuskan kelas yang mengimplementasikannya untuk memiliki metode pengaturan diskon.

3. **Detailing.java (Abstract Superclass)**: Kelas induk abstrak yang mendefinisikan struktur umum dan metode abstrak

4. **MotorMatic.java & MotorSport.java (Subclasses)**: Kelas turunan yang wajib mengimplementasikan seluruh abstract method dari induknya dan menerapkan interface diskon.

## 5. Dokumentasi Kode

**a. Implementasi Interface**
```java
public interface Diskonable {
    void terapkanDiskon(double persentase);
    void hapusDiskon(int hargaAsal);
}
```

**b. Implementasi Abstract Class & Method**
```java
public abstract class Detailing {
    // ... atribut ...
    
    // Abstract method: tidak memiliki body [cite: 16]
    public abstract void tampilkanBaris(int no);
}
```

**c. Implementasi pada Subclass**
```java
public class MotorMatic extends Detailing implements Diskonable {
    @Override
    public void tampilkanBaris(int no) {
        // Implementasi detail penampilan data
    }

    @Override
    public void terapkanDiskon(double persentase) {
        this.harga = (int) (this.harga * (1 - persentase));
    }
}
```

**d. Penggunaan Polymorphism & Casting**
```java
Detailing motorBaru; // Variabel bertipe abstract class 
// ... instansiasi ke subclass ...

if (isMember.equalsIgnoreCase("y")) {
    ((Diskonable) motorBaru).terapkanDiskon(0.1); 
}
```

