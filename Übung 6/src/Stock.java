public class Stock implements GoodsSink, GoodsSource {

    private int stock = 0;

    @Override
    public void receive(int count) {
        this.stock += count;
    }

    @Override
    public boolean deliver(int count) {
        boolean deliverable = false;
        if (count <= stock) {
            deliverable = true;
            stock -= count;
        }
        return deliverable;
    }

    @Override
    public String toString() {
        return String.format("Lager hat %d Glühbirnen auf Vorrat%n", stock);
    }
}
