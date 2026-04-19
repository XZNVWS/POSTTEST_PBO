public class MotorSport extends Detailing implements Diskonable {
    private int kapasitasMesin;

    public MotorSport(String merk, String paket, int harga, int kapasitasMesin) {
        super(merk, paket, harga);
        this.kapasitasMesin = kapasitasMesin;
    }

    @Override
    public void terapkanDiskon(double persentase) {
        this.harga = (int) (this.harga * (1 - persentase));
    }

    @Override
    public void hapusDiskon(int hargaAsal) {
        this.harga = hargaAsal;
    }

    @Override
    public void tampilkanBaris(int no) {
        System.out.printf("| %-3d | %-15s | %-20s | Rp %-10d | Sport (Mesin: %dcc) |\n",
                no, merk, paket, harga, kapasitasMesin);
    }
}