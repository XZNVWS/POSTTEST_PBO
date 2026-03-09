public class Detailing {
    String merk;
    String paket;
    int harga;

    public Detailing(String merk, String paket, int harga) {
        this.merk = merk;
        this.paket = paket;
        this.harga = harga;
    }

    void tampilkanBaris(int no) {
        System.out.printf("| %-3d | %-20s | %-30s | Rp %-10d |\n",
                no, this.merk, this.paket, this.harga);
    }
}