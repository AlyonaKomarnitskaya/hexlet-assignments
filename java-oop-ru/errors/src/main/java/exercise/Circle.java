package exercise;

// BEGIN
public class Circle {

    private Point point;
    private int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        double A = Math.PI * (radius * radius);
        if (radius < 0) {
            throw new NegativeRadiusException("Radius should be more than zero.");
        } else {
            return A;
        }
    }
}
// END
