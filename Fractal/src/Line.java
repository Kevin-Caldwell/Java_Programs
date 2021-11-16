import java.util.ArrayList;
import java.util.Random;

public class Line {

    Point point1;
    Point point2;

    double length;
    double angle;

    double branchFreedomRange = 1;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        calculateLength();
    }

    public Line(Point point1, double distance, double angle) {
        this.point1 = point1;
        point2 = new Point(point1.x + distance * Math.cos(angle), point1.y + distance * Math.sin(angle));
        length = distance;
        this.angle = angle;
    }

    double getLength() {
        return length;
    }

    double calculateLength() {
        return Math.sqrt((point2.x - point1.x) * (point2.x - point1.x) + (point2.y - point1.y) * (point2.y - point1.y));
    }

    public void subdivide(ArrayList<Line> lineList) {
        Random randomGenerator = new Random();

        for (int i = 0; i < 2; i++) {
            lineList.add(
                    new Line(point2, length * 0.80, angle + randomGenerator.nextDouble(-1, 1) * branchFreedomRange));
        }
        // lineList.add(new Line(point1, point2));

    }
}
