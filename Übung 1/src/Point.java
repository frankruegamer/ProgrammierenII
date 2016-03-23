// Die nachfolgende Klasse soll einen Punkt in einem zweidimensionalen
// Koordinatensystem repraesentieren.

public class Point {

	private double x;
	private double y;

	// Konstruktor mit Uebergabe der x und y - Koordinate
	Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	// Auslesen der x-Koordinate
	double getX()
	{
		return x;
	}
	
	// Auslesen der y-Koordinate
	double getY()
	{
		return y;
	}
	
	// Abstand zu einem anderen Punkt
	double distance(Point other)
	{
		return Math.sqrt(Math.pow(other.getX() - this.x, 2) + Math.pow(other.getY() - this.y, 2));
	}
	
	// Erzeugung eines neuen Punktes, der zum Ausgangspunkt verschoben ist
	Point moved(double deltaX, double deltaY)
	{
		double newX = this.x + deltaX;
		double newY = this.y + deltaY;
		return new Point(newX, newY);
	}

	
	// **********************************************************
	// In der nachfolgenden Main-Methode werden einige Tests
	// ausgefuehrt, die bei korrekter Loesung keinen Fehler 
	// liefern sollten.
	
	public static void main(String[] args)
	{
		Point p1 = new Point(2, 3);
		
		System.out.println("Start der Tests...");
		
		if (Math.abs(p1.getX() - 2) > 0.1 )
			System.out.println ("x-Koordinate P1 fehlerhaft.");
		
		if (Math.abs(p1.getY() - 3) > 0.1 )
			System.out.println ("y-Koordinate P1 fehlerhaft.");
		
		Point p2 = p1.moved(-1, 2);
				
		if (Math.abs(p2.getX() - 1) > 0.1 )
			System.out.println ("x-Koordinate P2 fehlerhaft.");
				
		if (Math.abs(p2.getY() - 5) > 0.1 )
			System.out.println ("y-Koordinate P2 fehlerhaft.");

		double d = p1.distance(p2);
		
		if (Math.abs(d- Math.sqrt(5)) > 0.1)
			System.out.println ("Abstandsberechnung fehlerhaft.");

		if (Math.abs(p1.distance(p2) - p2.distance(p1)) > 0.1)
			System.out.println ("Abstandsberechnung fehlerhaft.");		

		System.out.println("Testende");
		
	}

}
