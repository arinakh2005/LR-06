package task18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The class serves to execute task 18:
 * creating simple top-level window for a Java application
 * with possibility to drawing arc
 * @author Arina Kholodnytska
 * @version 1.0
 */
public class task18 extends JFrame {
    /**
     * The constant jFrame - main window
     */
    public static JFrame jFrame;

    public static void main(String[] args) {
        GridBagConstraints constraints = new GridBagConstraints();
        initJFrame();

        DrawingArcPanel drawingArc = new DrawingArcPanel();
        addElementToJFrame(jFrame, drawingArc, constraints, 1, 0);

        JPanel paramPanel = new JPanel();
        paramPanel.setLayout(new GridBagLayout());
        constraints.insets = new Insets(5, 0, 5, 10);

        JLabel labelX = new JLabel("Coordinate x");
        addElementToJFrame(paramPanel, labelX, constraints, 1, 1);

        JTextField coordX = new JTextField("Please, enter a number");
        addElementToJFrame(paramPanel, coordX, constraints, 2, 1);

        JLabel labelY = new JLabel("Coordinate y");
        addElementToJFrame(paramPanel, labelY, constraints, 1, 2);

        JTextField coordY = new JTextField("Please, enter a number");
        addElementToJFrame(paramPanel, coordY, constraints, 2, 2);

        JLabel labelWidth = new JLabel("Width");
        addElementToJFrame(paramPanel, labelWidth, constraints, 1, 3);

        JTextField width = new JTextField("Please, enter a number");
        addElementToJFrame(paramPanel, width, constraints, 2, 3);

        JLabel labelHeight = new JLabel("Height");
        addElementToJFrame(paramPanel, labelHeight, constraints, 1, 4);

        JTextField height = new JTextField("Please, enter a number");
        addElementToJFrame(paramPanel, height, constraints, 2, 4);

        JLabel labelStartAngle = new JLabel("Start angle");
        constraints.insets = new Insets(20, 0, 5, 0);
        addElementToJFrame(paramPanel, labelStartAngle, constraints, 0, 5);

        JRadioButton rbPlusStartAngle = new JRadioButton("Plus");
        JRadioButton rbMinusStartAngle = new JRadioButton("Minus");
        ButtonGroup buttonGroupStartAngle = new ButtonGroup();
        buttonGroupStartAngle.add(rbPlusStartAngle);
        buttonGroupStartAngle.add(rbMinusStartAngle);
        addElementToJFrame(paramPanel, rbPlusStartAngle, constraints, 1, 5);
        addElementToJFrame(paramPanel, rbMinusStartAngle, constraints, 2, 5);

        JSpinner spinnerStartAngle = new JSpinner(new SpinnerNumberModel(0, 0, 360, 45));
        addElementToJFrame(paramPanel, spinnerStartAngle, constraints, 3, 5);

        JLabel labelArcAngle = new JLabel("Arc angle");
        addElementToJFrame(paramPanel, labelArcAngle, constraints, 0, 6);

        JRadioButton rbPlusArcAngle = new JRadioButton("Plus");
        JRadioButton rbMinusArcAngle = new JRadioButton("Minus");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbPlusArcAngle);
        buttonGroup.add(rbMinusArcAngle);
        addElementToJFrame(paramPanel, rbPlusArcAngle, constraints, 1, 6);
        addElementToJFrame(paramPanel, rbMinusArcAngle, constraints, 2, 6);

        JSpinner spinnerArcAngle = new JSpinner(new SpinnerNumberModel(0, 0, 360, 45));
        addElementToJFrame(paramPanel, spinnerArcAngle, constraints, 3, 6);

        addElementToJFrame(jFrame, paramPanel, constraints, 1, 3);

        JLabel label = new JLabel();
        constraints.insets = new Insets(10, 0, 0, 0);
        addElementToJFrame(jFrame, label, constraints, 1, 5);

        ActionListener actionListener = e -> {
            try {
                int x_value = Integer.parseInt(coordX.getText());
                int y_value = Integer.parseInt(coordY.getText());
                int width_value = Integer.parseInt(width.getText());
                int height_value = Integer.parseInt(height.getText());

                int startAngle_value = -1;
                if (rbPlusStartAngle.isSelected()) {
                    startAngle_value = Integer.parseInt(spinnerStartAngle.getValue().toString());
                } else if (rbMinusStartAngle.isSelected()) {
                    startAngle_value = -Integer.parseInt(spinnerStartAngle.getValue().toString());
                }

                int arcAngle_value = -1;
                if (rbPlusArcAngle.isSelected()) {
                    arcAngle_value = Integer.parseInt(spinnerArcAngle.getValue().toString());
                } else if (rbMinusArcAngle.isSelected()) {
                    arcAngle_value = -Integer.parseInt(spinnerArcAngle.getValue().toString());
                }

                if (width_value < 0 || height_value < 0 || arcAngle_value == -1 || startAngle_value == -1) {
                    throw new Exception();
                }

                drawingArc.redraw(x_value, y_value, width_value, height_value, startAngle_value, arcAngle_value);
                label.setText("");
            } catch (Exception ex) {
                label.setText("Please, check data or empty fields!");
            }
            jFrame.repaint();
        };

        JButton buttonChangeRect = new JButton("Draw Arc");
        buttonChangeRect.addActionListener(actionListener);
        constraints.insets = new Insets(10, 0, 10, 0);
        addElementToJFrame(jFrame, buttonChangeRect, constraints, 1, 4);

        jFrame.setVisible(true);
    }

    /**
     * Init JFrame. It initializes main window with title that is initially invisible
     */
    public static void initJFrame() {
        jFrame = new JFrame("Draw Arc");
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
