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