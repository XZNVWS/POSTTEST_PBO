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