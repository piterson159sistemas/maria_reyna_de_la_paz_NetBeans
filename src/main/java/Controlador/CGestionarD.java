//asssdas
package Controlador;

import DAO.GestionarDocente;
import Modelo.Usuario;
import Vista.gestionar_cuenta_docente_directivo_1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class CGestionarD implements ActionListener {
    Usuario us;
    gestionar_cuenta_docente_directivo_1 gcdd1;
    GestionarDocente GD = new GestionarDocente();

    public CGestionarD(gestionar_cuenta_docente_directivo_1 gcdd) {
        gcdd1 = gcdd;
        gcdd1.jbtnActualizarGDG.addActionListener(this);
        gcdd1.jbtnBorrarGD.addActionListener(this);
        gcdd1.setTitle("Gestionar Docentes");
        gcdd1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gcdd1.jbtnActualizarGDG) {
            // Lógica para el botón de actualizar
            JOptionPane.showMessageDialog(null, "Acción del botón Actualizar");
        } else if (e.getSource() == gcdd1.jbtnBorrarGD) {
            // Lógica para el botón de borrar
            JOptionPane.showMessageDialog(null, "Acción del botón Borrar");
        }
    }
}