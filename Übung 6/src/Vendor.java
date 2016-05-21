public class Vendor extends Partner implements GoodsSource {

    public Vendor(String name, String city) {
        super(name, city);
    }

    @Override
    public boolean deliver(int count) {
        return true;
    }

    @Override
    public String toString() {
        return "Lieferant: " + super.toString();
    }
}
