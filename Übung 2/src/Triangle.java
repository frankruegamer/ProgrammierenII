public class Triangle implements Polygon {

    private Point p1, p2, p3;

    public Triangle (Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point[] allVertexes() {
        return new Point[] {p1, p2, p3};
    }

    public double perimeter() {
        double distance = p1.distance(p2);
        distance += p2.distance(p3);
        distance += p3.distance(p1);
        return distance;
    }

    public double area() {
        double[] a = new double[] {p1.getX(), p1.getY()};
        double[] b = new double[] {p2.getX(), p2.getY()};
        double[] c = new double[] {p3.getX(), p3.getY()};
        double area = a[0]*(b[1]-c[1]);
        area += b[0]*(c[1]-a[1]);
        area += c[0]*(a[1]-b[1]);
        return Math.abs(area/2);
    }

    public void move(double dx, double dy) {
        p1 = p1.moved(dx, dy);
        p2 = p2.moved(dx, dy);
        p3 = p3.moved(dx, dy);
    }

    public static void main(String[] args) {
        Triangle t1 = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0,1));
        System.out.println("Start des Tests...");

        double perimeter = t1.perimeter();
        if (Math.abs(perimeter - 3.414213562373095) > 10E-8)
            System.out.println("Umfangsberechnung fehlerhaft");

        double area = t1.area();
        if (Math.abs(area - 0.5) > 0.1)
            System.out.println("Flächenberechnung fehlerhaft");

        t1.move(2, -2);
        Point p1 = t1.allVertexes()[0];
        Point p2 = t1.allVertexes()[1];
        Point p3 = t1.allVertexes()[2];
        boolean b1 = p1.getX() == 2 && p1.getY() == -2;
        boolean b2 = p2.getX() == 3 && p2.getY() == -2;
        boolean b3 = p3.getX() == 2 && p3.getY() == -1;
        if (!(b1 && b2 && b3))
            System.out.println("Verschiebungsberechnung fehlerhaft");

        System.out.println("Testende");
    }
}
