
package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Limitar JCheckBox en Paneles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        int maxCheckBoxesPerPanel = 3; // Número máximo de JCheckBox permitidos por panel

        JPanel[] panels = new JPanel[3]; // Tres paneles
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
            panels[i].setLayout(new BoxLayout(panels[i], BoxLayout.Y_AXIS));
            frame.add(panels[i]);
        }

        for (int panelIndex = 0; panelIndex < panels.length; panelIndex++) {
            JCheckBox[] checkBoxes = new JCheckBox[5]; // Supongamos que hay 5 JCheckBox por panel
            for (int i = 0; i < checkBoxes.length; i++) {
                checkBoxes[i] = new JCheckBox("Panel " + (panelIndex + 1) + " - CheckBox " + (i + 1));
                panels[panelIndex].add(checkBoxes[i]);

                int finalPanelIndex = panelIndex; // Variable final para ActionListener
                checkBoxes[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int checkedCount = 0;
                        for (JCheckBox checkBox : checkBoxes) {
                            if (checkBox.isSelected()) {
                                checkedCount++;
                            }
                        }
                        if (checkedCount >= maxCheckBoxesPerPanel) {
                            for (JCheckBox checkBox : checkBoxes) {
                                if (!checkBox.isSelected()) {
                                    checkBox.setEnabled(false);
                                }
                            }
                        } else {
                            for (JCheckBox checkBox : checkBoxes) {
                                checkBox.setEnabled(true);
                            }
                        }
                    }
                });
            }
        }

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
    
}
