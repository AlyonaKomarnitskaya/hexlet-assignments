package exercise;

// BEGIN
public class Segment {
    private Point point1;
    private Point point2;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getBeginPoint() { return point1; }
    public Point getEndPoint() { return point2; }
    public Point getMidPoint() {
        int midX = (getBeginPoint().getX() + getEndPoint().getX()) / 2;
        int midY = (getBeginPoint().getY() + getEndPoint().getY()) / 2;
        return new Point(midX, midY);
    }
}
// END
