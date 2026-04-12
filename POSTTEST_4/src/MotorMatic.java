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