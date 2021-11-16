import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CanvasFrame extends JFrame {
    private int iterations = 5;
    private int interval = 100;

    private CanvasPanel canvas;

    private JButton generateFractalButton;

    private JPanel leftPanel;
    private JPanel rightPanel;

    private JSlider iterationsSlider;
    private JSlider intervalSlider;

    public CanvasFrame() {
        leftPanel = new JPanel();
        rightPanel = new JPanel();

        canvas = new CanvasPanel();
        canvas.setPreferredSize(new Dimension(500, 500));

        generateFractalButton = new JButton("Generate New Fractal");
        generateFractalButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.clearCanvas();
                TreeFractal a = new TreeFractal();
                canvas.drawLines(a.linesArrayList);
                for (int i = 0; i < iterations; i++) {
                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    canvas.drawLines(a.GetFractalLines());
                }
                // canvas.update(getGraphics());
            }

        });

        iterationsSlider = new JSlider(0, 12, 7);
        iterationsSlider.setMajorTickSpacing(4);
        iterationsSlider.setMinorTickSpacing(1);
        iterationsSlider.setPaintTicks(true);
        iterationsSlider.setPaintTrack(true);
        iterationsSlider.setPaintLabels(true);
        iterationsSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                iterations = iterationsSlider.getValue();
            }

        });

        intervalSlider = new JSlider(0, 2000, 20);
        intervalSlider.setMajorTickSpacing(500);
        intervalSlider.setMinorTickSpacing(400);
        intervalSlider.setPaintTicks(true);
        intervalSlider.setPaintTrack(true);
        intervalSlider.setPaintLabels(true);
        intervalSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                interval = intervalSlider.getValue();
            }

        });

        leftPanel.add(canvas);

        rightPanel.add(generateFractalButton);
        rightPanel.add(new JLabel("Iterations:"));
        rightPanel.add(iterationsSlider);
        rightPanel.add(new JLabel("Construction Interval:"));
        rightPanel.add(intervalSlider);

        leftPanel.setLayout(new FlowLayout());
        rightPanel.setLayout(new GridLayout(0, 1));

        add(leftPanel);
        add(rightPanel);

        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Fractals");
        setSize(1000, 600);
        setVisible(true);
    }

}
