public class Detailing {
    protected String merk;
    protected String paket;
    protected int harga;

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
            this.harga = 0;
        } else {
            this.harga = harga;
        }
    }

    public void tampilkanBaris(int no) {
        System.out.printf("| %-3d | %-15s | %-20s | Rp %-10d | %-20s |\n",
                no, this.merk, this.paket, this.harga, "-");
    }
}