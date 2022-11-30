package task15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The class serves to execute task 15:
 * creating simple top-level window for a Java application
 * with possibility to redrawing and recolor rectangle with rounding border
 * @author Arina Kholodnytska
 * @version 1.0
 */
public class task15 extends JFrame {
    /**
     * The constant jFrame - main window.
     */
    public static JFrame jFrame;

    /**
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        initJFrame();
        GridBagConstraints constraints = new GridBagConstraints();

        RoundRectanglePanel roundRectangle = new RoundRectanglePanel();
        addElementToJFrame(jFrame, roundRectangle, constraints, 1, 0);

        JPanel paramPanel = new JPanel();
        paramPanel.setLayout(new GridBagLayout());
        constraints.insets = new Insets(5, 0, 5, 10);

        JLabel labelColor = new JLabel("Color");
        addElementToJFrame(paramPanel, labelColor, constraints, 0, 0);

        String[] colors = {"Black", "Red", "Green", "Blue"};
        SpinnerModel spinnerListColors = new SpinnerListModel(colors);
        JSpinner spinner = new JSpinner(spinnerListColors);
        addElementToJFrame(paramPanel, spinner, constraints, 1, 0);

        JLabel roundingWidthLabel = new JLabel("Rounding width");
        addElementToJFrame(paramPanel, roundingWidthLabel, constraints, 0, 1);

        JTextField roundingWidth = new JTextField("Please, enter a value");
        addElementToJFrame(paramPanel, roundingWidth, constraints, 1, 1);

        JLabel roundingHeightLabel = new JLabel("Rounding height");
        addElementToJFrame(paramPanel, roundingHeightLabel, constraints, 0, 2);

        JTextField roundingHeight = new JTextField("Please, enter a value");
        addElementToJFrame(paramPanel, roundingHeight, constraints, 1, 2);

        constraints.insets = new Insets(10, 0, 10, 0);
        addElementToJFrame(jFrame, paramPanel, constraints, 1, 3);

        JLabel label = new JLabel();
        constraints.insets = new Insets(10, 0, 0, 0);
        addElementToJFrame(jFrame, label, constraints, 1, 5);

        ActionListener actionListener = e -> {
            int roundingHeightValue = 0, roundingWidthValue = 0;
            String color = "";
            try {
                roundingHeightValue = Integer.parseInt(roundingHeight.getText());
                roundingWidthValue = Integer.parseInt(roundingWidth.getText());
                color = spinner.getValue().toString();
            } catch (NumberFormatException ex) {
                label.setText("Invalid field value!");
            }

            if (roundingHeightValue >= 0 && roundingWidthValue >= 0 && !color.equals("")) {
                label.setText("");
                roundRectangle.repaint(color, roundingWidthValue, roundingHeightValue);
            } else {
                label.setText("Please, check data or empty fields!");
            }
            jFrame.repaint();
        };

        JButton buttonChangeRect = new JButton("Change Rectangle");
        buttonChangeRect.addActionListener(actionListener);
        constraints.insets = new Insets(10, 0, 10, 0);
        addElementToJFrame(jFrame, buttonChangeRect, constraints, 1, 4);

        jFrame.setVisible(true);
    }

    /**
     * Init JFrame. It initializes main window with title that is initially invisible.
     */
    public static void initJFrame() {
        jFrame = new JFrame("Draw Round Rectangle");
        jFrame.setLayout(new GridBagLayout());
        jFrame.setSize(400,500);
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
