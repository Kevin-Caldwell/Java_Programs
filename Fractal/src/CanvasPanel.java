import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CanvasPanel extends JPanel {

    public CanvasPanel() {
    }

    @Override
    public void paintComponent(Graphics g) {

    }

    public void clearCanvas() {
        getGraphics().clearRect(0, 0, getWidth(), getHeight());
    }

    public void drawLines(ArrayList<Line> linesList) {
        Graphics g = getGraphics();
        for (Line line : linesList) {
            g.drawLine((int) line.point1.x, (int) line.point1.y, (int) line.point2.x, (int) line.point2.y);
        }
    }
}
