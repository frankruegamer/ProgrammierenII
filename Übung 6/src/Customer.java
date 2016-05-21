public class Customer extends Partner implements GoodsSink {

    private int count;

    public Customer(String name, String city) {
        super(name, city);
        count = 0;
    }

    @Override
    public void receive(int count) {
        this.count += count;
    }

    @Override
    public String toString() {
        return "Kunde: " + super.toString();
    }

    public void sendInvoice() {
        System.out.printf("%s, bezogene Glühbirnen: %d%n", this, count);
        count = 0;
    }
}
