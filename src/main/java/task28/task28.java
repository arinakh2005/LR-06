package task28;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The class serves to execute task 18:
 * creating simple top-level window for a Java application
 * with possibility to drawing polygon
 * @author Arina Kholodnytska
 * @version 1.0
 */
public class task28 extends JFrame {
    /**
     * The constant jFrame - main window
     */
    public static JFrame jFrame;

    public static void main(String[] args) {
        initJFrame();

        DrawingTrianglePanel drawingPolygon = new DrawingTrianglePanel();
        GridBagConstraints constraints = new GridBagConstraints();

        JPanel paramPanel = new JPanel();
        paramPanel.setLayout(new GridBagLayout());
        constraints.insets = new Insets(5, 0, 5, 10);

        JLabel labelX1 = new JLabel("Coordinate x1");
        addElementToJFrame(paramPanel, labelX1, constraints, 1, 0);
        JSpinner spinnerX1 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        addElementToJFrame(paramPanel, spinnerX1, constraints, 2, 0);

        JLabel labelX2 = new JLabel("Coordinate x2");
        addElementToJFrame(paramPanel, labelX2, constraints, 1, 1);
        JSpinner spinnerX2 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        addElementToJFrame(paramPanel, spinnerX2, constraints, 2, 1);

        JLabel labelX3 = new JLabel("Coordinate x3");
        addElementToJFrame(paramPanel, labelX3, constraints, 1, 2);
        JSpinner spinnerX3 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        addElementToJFrame(paramPanel, spinnerX3, constraints, 2, 2);

        JLabel labelY1 = new JLabel("Coordinate y1");
        addElementToJFrame(paramPanel, labelY1, constraints, 1, 3);
        JSpinner spinnerY1 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        addElementToJFrame(paramPanel, spinnerY1, constraints, 2, 3);

        JLabel labelY2 = new JLabel("Coordinate y2");
        addElementToJFrame(paramPanel, labelY2, constraints, 1, 4);
        JSpinner spinnerY2 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        addElementToJFrame(paramPanel, spinnerY2, constraints, 2, 4);

        JLabel labelY3 = new JLabel("Coordinate y3");
        addElementToJFrame(paramPanel, labelY3, constraints, 1, 5);
        JSpinner spinnerY3 = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        addElementToJFrame(paramPanel, spinnerY3, constraints, 2, 5);

        JLabel label = new JLabel();
        constraints.insets = new Insets(10, 0, 0, 0);
        addElementToJFrame(jFrame, label, constraints, 2, 2);

        ActionListener actionListener = e -> {
            try {
                int x_1 = Integer.parseInt(spinnerX1.getValue().toString());
                int x_2 = Integer.parseInt(spinnerX2.getValue().toString());
                int x_3 = Integer.parseInt(spinnerX3.getValue().toString());
                int y_1 = Integer.parseInt(spinnerY1.getValue().toString());
                int y_2 = Integer.parseInt(spinnerY2.getValue().toString());
                int y_3 = Integer.parseInt(spinnerY3.getValue().toString());

                int [] x_arr = {x_1, x_2, x_3};
                int [] y_arr = {y_1, y_2, y_3};

                drawingPolygon.redraw(x_arr, y_arr);
                label.setText("");
            } catch (NumberFormatException ex) {
                label.setText("Please, check data or empty fields!");
            }
            jFrame.repaint();
        };

        addElementToJFrame(jFrame, paramPanel, constraints, 0, 2);

        JButton buttonDrawPolygon = new JButton("Draw Triangle");
        buttonDrawPolygon.addActionListener(actionListener);
        constraints.insets = new Insets(10, 0, 10, 0);
        addElementToJFrame(jFrame, buttonDrawPolygon, constraints, 0, 3);

        constraints.gridx = 0;
        constraints.gridy = 4;
        jFrame.add(drawingPolygon, constraints);
        addElementToJFrame(jFrame, drawingPolygon, constraints, 0, 4);

        jFrame.setVisible(true);
    }

    /**
     * Init JFrame. It initializes main window with title that is initially invisible
     */
    public static void initJFrame() {
        jFrame = new JFrame("Draw Triangle");
        jFrame.setLayout(new GridBagLayout());
        jFrame.setSize(550,550);
    }

    /**
     * Add element to jFrame
     *
     * @param frame       the frame
     * @param element     the element(component) for adding
     * @param constraints the constraints for element
     * @param gridX       the grid x
     * @param gridY       the grid y
     *
     * @return the boolean value about successful adding element
     */
    public static boolean addElementToJFrame(Container frame, Component element, GridBagConstraints constraints, int gridX, int gridY) {
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        try {
            frame.add(element, constraints);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
