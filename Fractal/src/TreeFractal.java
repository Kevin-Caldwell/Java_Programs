import java.util.ArrayList;

public class TreeFractal {
    public ArrayList<Line> linesArrayList;

    public TreeFractal() {
        linesArrayList = new ArrayList<>();
        linesArrayList.add(new Line(new Point(250, 400), 75, -1.6));
    }

    public ArrayList<Line> GetFractalLines() {
        ArrayList<Line> newLineList = new ArrayList<Line>();

        for (Line line : linesArrayList) {
            line.subdivide(newLineList);
        }
        linesArrayList = newLineList;
        return linesArrayList;
    }

}
