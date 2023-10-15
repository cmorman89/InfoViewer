import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoFrame extends JFrame{


    private final int WINDOW_WIDTH  = 400;
    private final int WINDOW_HEIGHT = 600;

    /* GUI Objects (Indented = Nested/Grouped/Contains) */
    private JPanel          displayPanel;
        private JLabel          displayTitleLabel;
        private JLabel          displayNameLabel;
        private JLabel          displayMajorLabel;
        private JLabel          displayMaritalStatusLabel;

    private JPanel          inputPanel;
        private JPanel          nameInputPanel;
            private JLabel          nameInputLabel;
            private JTextField      nameInputTextField;
        private JPanel          majorInputPanel;
            private JComboBox       majorInputComboBox;
        private JPanel          maritalStatusInputPanel;
            private ButtonGroup     maritalStatusInputRadioGroup;
                private JRadioButton    singleMaritalInputRadio;
                private JRadioButton    marriedMaritalInputRadio;
                private JRadioButton    separatedMaritalInputRadio;


    private ActionListener onChange;

    /**
     *  Construct Info Viewer Window
    */

    public InfoFrame() {
        /* Set Parameters */
            setTitle("User Information Viewer");
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        /* Info Frame Contents */
            add(displayPanel(), BorderLayout.CENTER);
            add(inputPanel(), BorderLayout.SOUTH);
        /* Make Visible */
            setVisible(true);
    }
    /**
     * Construct Display Panel
     * @return JPanel to display selected information
    */
    public JPanel displayPanel() {
        displayPanel = new JPanel(new GridLayout(4,1));
        /* Display Panel Contents */




        return displayPanel;
    }

    public JPanel inputPanel() {
        inputPanel = new JPanel(new GridLayout(3,1));

        /* Input Panel Contents */
        inputPanel.add(nameInputPanel());
        inputPanel.add(majorInputPanel());
        inputPanel.add(maritalStatusInputPanel());

        return inputPanel;
    }
    public JPanel nameInputPanel() {
        nameInputPanel = new JPanel();
        nameInputPanel.setBorder(new TitledBorder(new EtchedBorder(), "Name"));
        /* Name Input Panel Contents */




        return nameInputPanel;
    }
    public JPanel majorInputPanel() {
        majorInputPanel = new JPanel();
        majorInputPanel.setBorder(new TitledBorder(new EtchedBorder(), "Major"));
        /* Major Input Panel Contents */



        return majorInputPanel;
    }
    public JPanel maritalStatusInputPanel() {
        maritalStatusInputPanel = new JPanel();
        maritalStatusInputPanel.setBorder(new TitledBorder(new EtchedBorder(), "Marital Status"));
        /* Marital Status Input Panel Contents */



        return majorInputPanel;
    }
}
