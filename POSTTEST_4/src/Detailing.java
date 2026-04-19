public abstract class Detailing {
    protected String merk;
    protected String paket;
    protected int harga;

    public Detailing(String merk, String paket, int harga) {
        this.merk = merk;
        this.paket = paket;
        this.harga = harga;
    }

    public void setHarga(int harga) {
        this.harga = Math.max(harga, 0);
    }

    public String getMerk() { return merk; }
    public void setMerk(String merk) { this.merk = merk; }
    public String getPaket() { return paket; }
    public void setPaket(String paket) { this.paket = paket; }
    public int getHarga() { return harga; }

    public abstract void tampilkanBaris(int no);
}