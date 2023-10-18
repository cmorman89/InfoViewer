/*============================================
 * InfoFrame.java
 * Authors: Charles M., Raihana F., Joanna G.
 * Class: ACO 102 - ASU West - Fall 2023
 ============================================*/


/* Import GUI Containers */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
/* Import GUI Components */
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
/* Import GUI Borders */
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
/* Import GUI Layouts */
import java.awt.BorderLayout;
import java.awt.GridLayout;
/* Import GUI Event Listeners */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/* Info Frame */
public class InfoFrame extends JFrame{
    /* Window Dimensions */
    private final int WINDOW_WIDTH  = 370;
    private final int WINDOW_HEIGHT = 500;

    /* GUI Objects (Indented = Nested/Grouped/Contains) */
    private JPanel          infoDisplayPanel;
        private JPanel          infoDisplayInnerPanel;
            private JLabel          infoHeaderLabel;
            private JPanel          infoColumnsPanel;
                private JPanel          infoLabelColumnPanel;
                    private JLabel          nameDescLabel;
                    private JLabel          majorDescLabel;
                    private JLabel          maritalStatusDescLabel;
                private JPanel          infoDataColumnPanel;
                    private JLabel          nameDataLabel;
                    private JLabel          majorDataLabel;
                    private JLabel          maritalStatusDataLabel;
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

    /* Action Listeners */
    private ActionListener onChange;

    /* Construct Info Viewer Window */
    public InfoFrame() {
        /* Set Parameters */
            setTitle("User Information Viewer");
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        /* Action Listener */
            onChange = new InputListener();
        /* Info Frame Contents */
            add(displayPanel(), BorderLayout.CENTER);
            add(inputPanel(), BorderLayout.SOUTH);
        /* Make Visible */
            setVisible(true);
    }

    /* Action Listener: Update GUI Display on Change*/
    class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            /* Update Name */
            nameDataLabel.setText(nameInputTextField.getText());
            /* Update Major */
            majorDataLabel.setText(majorInputComboBox.getSelectedItem().toString());
            /* Update Marital Status */
            String maritalStatusString;
            if      (singleMaritalInputRadio.isSelected())      { maritalStatusString = "Single"; }
            else if (marriedMaritalInputRadio.isSelected())     { maritalStatusString = "Married"; }
            else if (separatedMaritalInputRadio.isSelected())   { maritalStatusString = "Separated"; }
            else                                                { maritalStatusString = " - - - "; }
            maritalStatusDataLabel.setText(maritalStatusString);
        }
    }

    /* Create Display Panel
     * @return JPanel to display selected information */
    public JPanel displayPanel() {
        /* Panel Parameters */
        final int GRID_ROWS     = 2;
        final int GRID_COLS     = 1;
        final int SUBGRID_ROWS  = 3;
        final int SUBGRID_COLS  = 1;
        final String COL_GAP    = " ".repeat(4);
        /* Create Panel and SubPanels */
        infoDisplayPanel            = new JPanel(new BorderLayout());
        infoDisplayInnerPanel       = new JPanel(new GridLayout(GRID_ROWS, GRID_COLS));
        infoColumnsPanel            = new JPanel(new BorderLayout());
        infoLabelColumnPanel        = new JPanel(new GridLayout(SUBGRID_ROWS, SUBGRID_COLS));
        infoDataColumnPanel         = new JPanel(new GridLayout(SUBGRID_ROWS,SUBGRID_COLS));
        /* Display Panel Contents */
            infoHeaderLabel         = new JLabel(COL_GAP + "User Information:");
            nameDescLabel           = new JLabel(COL_GAP + "Name:" + COL_GAP);
            nameDataLabel           = new JLabel(" - - - ");
            majorDescLabel          = new JLabel(COL_GAP + "Major:" + COL_GAP);
            majorDataLabel          = new JLabel(" - - - ");
            maritalStatusDescLabel  = new JLabel(COL_GAP + "Marital Status:" + COL_GAP);
            maritalStatusDataLabel  = new JLabel(" - - - ");
        /* Panel Layout - Note: Nested panels to keep West/Center elements from overtaking whole area */
            /* NORTH    */   infoDisplayPanel.add(infoDisplayInnerPanel, BorderLayout.NORTH);
                /* Row 1 */     infoDisplayInnerPanel.add(infoHeaderLabel);
                /* Row 2 */     infoDisplayInnerPanel.add(infoColumnsPanel);
                    /* WEST     */   infoColumnsPanel.add(infoLabelColumnPanel, BorderLayout.WEST);
                        /* Row 1 */     infoLabelColumnPanel.add(nameDescLabel);
                        /* Row 2 */     infoLabelColumnPanel.add(majorDescLabel);
                        /* Row 3 */     infoLabelColumnPanel.add(maritalStatusDescLabel);
                    /* CENTER   */   infoColumnsPanel.add(infoDataColumnPanel, BorderLayout.CENTER);
                        /* Row 1 */     infoDataColumnPanel.add(nameDataLabel);
                        /* Row 2 */     infoDataColumnPanel.add(majorDataLabel);
                        /* Row 3 */     infoDataColumnPanel.add(maritalStatusDataLabel);

        return infoDisplayPanel;
    }

    /* Create Input Panel
     * @return JPanel to hold input subpanels */
    public JPanel inputPanel() {
        /* Panel Parameters */
        final int GRID_ROWS = 3;
        final int GRID_COLS = 1;
        /* Create Panel */
        inputPanel = new JPanel(new GridLayout(GRID_ROWS, GRID_COLS));
        /* Input Panel Contents Grid */
            /* Row 1 Col 1 */   inputPanel.add(nameInputPanel());
            /* Row 2 Col 1 */   inputPanel.add(majorInputPanel());
            /* Row 3 Col 1 */   inputPanel.add(maritalStatusInputPanel());
        /* Return Panel */
        return inputPanel;
    }

    /* Create Name Input Subpanel
     * @return JPanel to hold name input objects */
    public JPanel nameInputPanel() {
        /* Panel Parameters */
        final String PANEL_TITLE = "Name";
        /* Create Panel */
        nameInputPanel = new JPanel();
        nameInputPanel.setBorder(new TitledBorder(new EtchedBorder(), PANEL_TITLE));
        /* Name Input Panel Contents */
        nameInputLabel = new JLabel("Your name: ");
            nameInputPanel.add(nameInputLabel);
        nameInputTextField = new JTextField("",20);
            nameInputTextField.addActionListener(onChange);
            nameInputPanel.add(nameInputTextField);
        /* Return Panel */
        return nameInputPanel;
    }

    /* Create Major Input Subpanel
     * @return JPanel to hold major input objects */
    public JPanel majorInputPanel() {
        /* Panel Parameters */
        final String PANEL_TITLE = "Major";
        /* Array of Majors */
        String[] majorArray = {
            " - - - ",
            "Art",
            "Biology",
            "Business",
            "Chemistry",
            "Communication",
            "Computer Science",
            "Mathematics",
            "Psychology",
            "Social Studies"
        };
        /* Create Panel */
        majorInputPanel = new JPanel();
        majorInputPanel.setBorder(new TitledBorder(new EtchedBorder(), PANEL_TITLE));
        /* Major Input Panel Contents */
        majorInputComboBox = new JComboBox<String>(majorArray);
            majorInputComboBox.addActionListener(onChange);
            majorInputPanel.add(majorInputComboBox);
        /* Return Panel */
        return majorInputPanel;
    }

    /* Create Marital Status Input Subpanel
     * @return JPanel to hold marital status input objects */
    public JPanel maritalStatusInputPanel() {
        /* Panel Parameters */
        final String    PANEL_TITLE = "Marital Status";
        final int       GRID_ROWS   = 1;
        final int       GRID_COLS   = 3;
        /* Create Panel */
        maritalStatusInputPanel = new JPanel(new GridLayout(GRID_ROWS, GRID_COLS));
        maritalStatusInputPanel.setBorder(new TitledBorder(new EtchedBorder(), PANEL_TITLE));
        /* Marital Status Input Panel Contents */
        maritalStatusInputRadioGroup    = new ButtonGroup();
            singleMaritalInputRadio     = new JRadioButton("Single");
                singleMaritalInputRadio.addActionListener(onChange);
                maritalStatusInputRadioGroup.add(singleMaritalInputRadio);
            marriedMaritalInputRadio    = new JRadioButton("Married");
                marriedMaritalInputRadio.addActionListener(onChange);
                maritalStatusInputRadioGroup.add(marriedMaritalInputRadio);
            separatedMaritalInputRadio  = new JRadioButton("Separated");
                separatedMaritalInputRadio.addActionListener(onChange);
                maritalStatusInputRadioGroup.add(separatedMaritalInputRadio);
        /* Panel Layout */
            /* Col 1 */  maritalStatusInputPanel.add(singleMaritalInputRadio);
            /* Col 2 */  maritalStatusInputPanel.add(marriedMaritalInputRadio);
            /* Col 3 */  maritalStatusInputPanel.add(separatedMaritalInputRadio);
        /* Return Panel */
        return maritalStatusInputPanel;
    }
}