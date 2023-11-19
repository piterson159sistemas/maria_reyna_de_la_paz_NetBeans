package Controlador;

import DAO.GestionarDocente;
import Modelo.Usuario;
import Vista.gestionar_cuenta_docente_directivo_1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CGestionarD implements ActionListener {
    Usuario us;
    gestionar_cuenta_docente_directivo_1 gcdd1;
    GestionarDocente gd;
    DefaultTableModel modelo = new DefaultTableModel();

    public CGestionarD(gestionar_cuenta_docente_directivo_1 gcdd) {
        gcdd1 = gcdd;
        gd = new GestionarDocente();

        gcdd1.JbtnListarDocentes.addActionListener(this);
        gcdd1.jbtnActualizarD.addActionListener(this);
        gcdd1.jbtnBorrarGD.addActionListener(this);
        gcdd1.jbtnActualizarD.addActionListener(this);
        gcdd1.jbtnEditar.addActionListener(this);
        gcdd1.setTitle("Gestionar Docentes");
        gcdd1.setVisible(true);
    }

public void Actualizar() {
    // Obtén los valores de los campos de texto
    String nombre = gcdd1.jtxtNombre.getText();
    String apellidoP = gcdd1.jtxtAP.getText();
    String apellidoM = gcdd1.jtxtAM.getText();
    String codigo = gcdd1.jtxtCod.getText();
    int numDocumento = Integer.parseInt(gcdd1.jtxtNDocumento.getText());
    String contrasena = gcdd1.jtxtContrass.getText();
    String pregunta1 = gcdd1.jtxtPregunta1.getText();
    String respuesta1 = gcdd1.jtxtRespuesta1.getText();
    String pregunta2 = gcdd1.jtxtPregunta2.getText();
    String respuesta2 = gcdd1.jtxtRespuesta2.getText();
    String pregunta3 = gcdd1.jtxtPregunta3.getText();
    String respuesta3 = gcdd1.jtxtRespuesta3.getText();

    // Crear un objeto Usuario con los valores obtenidos
    Usuario docenteActualizado = new Usuario();
    docenteActualizado.setNombre(nombre);
    docenteActualizado.setApellidoP(apellidoP);
    docenteActualizado.setApellidoM(apellidoM);
    docenteActualizado.setCodigo(codigo);
    docenteActualizado.setNumDocumento(numDocumento);
    docenteActualizado.setClave(contrasena);
    docenteActualizado.setPreg(new String[]{pregunta1, pregunta2, pregunta3});
    docenteActualizado.setResp(new String[]{respuesta1, respuesta2, respuesta3});

    // Llama al método de actualización en el DAO
    boolean actualizacionExitosa = gd.actualizarDocenteCompleto(docenteActualizado);

    // Verifica si la actualización fue exitosa y muestra un mensaje
    if (actualizacionExitosa) {
        JOptionPane.showMessageDialog(gcdd1, "Actualización exitosa");
        // Limpiamos el modelo antes de listar los nuevos datos
        modelo.setRowCount(0);
        // Actualiza la tabla después de la edición
        Listar(gcdd1.tbl_GD);
    } else {
        JOptionPane.showMessageDialog(gcdd1, "Error al actualizar los datos");
    }
}
    public void Listar(JTable tabla) {
    modelo = (DefaultTableModel) tabla.getModel();
    modelo.setRowCount(0); // Limpia todas las filas existentes en el modelo

    List<Usuario> lista = gd.obtenerDatosDocentes();

    for (int i = 0; i < lista.size(); i++) {
        Usuario usuario = lista.get(i);

        // Verificar si los campos importantes no son nulos o vacíos antes de agregar la fila
        if (isUsuarioValido(usuario)) {
            Object[] row = new Object[]{
                    usuario.getNombre(),
                    usuario.getApellidoP(),
                    usuario.getApellidoM(),
                    usuario.getCodigo(),
                    usuario.getNumDocumento(),
                    usuario.getClave(),
                    usuario.getPreg()[0],
                    usuario.getResp()[0],
                    usuario.getPreg()[1],
                    usuario.getResp()[1],
                    usuario.getPreg()[2],
                    usuario.getResp()[2]
            };

            modelo.addRow(row);
        }
    }

    // Notifica a la vista de la tabla que los datos han cambiado
    modelo.fireTableDataChanged();
}

    private boolean isUsuarioValido(Usuario usuario) {
        return usuario.getNombre() != null &&
                usuario.getApellidoP() != null &&
                usuario.getCodigo() != null &&
                !usuario.getNombre().isEmpty() &&
                !usuario.getApellidoP().isEmpty() &&
                !usuario.getCodigo().isEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gcdd1.JbtnListarDocentes) {
            Listar(gcdd1.tbl_GD);
        }
     if (e.getSource() == gcdd1.jbtnBorrarGD) {
    int fila = gcdd1.tbl_GD.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(gcdd1, "Selecciona una fila>:v");
    } else {
        String codigoUsuario = (String) gcdd1.tbl_GD.getValueAt(fila, 3);

        boolean borradoExitoso = gd.borrarDocente(codigoUsuario);

        if (borradoExitoso) {
            JOptionPane.showMessageDialog(gcdd1, "Docente eliminado exitosamente");
            // Limpiamos el modelo antes de listar los nuevos datos
            modelo.setRowCount(0);
            // Actualiza la tabla después de la eliminación
            Listar(gcdd1.tbl_GD);
        } else {
            JOptionPane.showMessageDialog(gcdd1, "Error al eliminar el docente");
        }
    }
}



if (e.getSource() == gcdd1.jbtnActualizarD) {
           Actualizar();
        }
        if (e.getSource() == gcdd1.jbtnEditar) {
            int fila = gcdd1.tbl_GD.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(gcdd1, "Debe Seleccionar una Fila");
            } else {
                // Autocompletar los campos de texto con los valores de la fila seleccionada
                gcdd1.jtxtNombre.setText((String) gcdd1.tbl_GD.getValueAt(fila, 0));
                gcdd1.jtxtAP.setText((String) gcdd1.tbl_GD.getValueAt(fila, 1));
                gcdd1.jtxtAM.setText((String) gcdd1.tbl_GD.getValueAt(fila, 2));
                gcdd1.jtxtCod.setText((String) gcdd1.tbl_GD.getValueAt(fila, 3));
                gcdd1.jtxtNDocumento.setText(String.valueOf(gcdd1.tbl_GD.getValueAt(fila, 4)));
                gcdd1.jtxtContrass.setText((String) gcdd1.tbl_GD.getValueAt(fila, 5));
                gcdd1.jtxtPregunta1.setText((String) gcdd1.tbl_GD.getValueAt(fila, 6));
                gcdd1.jtxtRespuesta1.setText((String) gcdd1.tbl_GD.getValueAt(fila, 7));
                gcdd1.jtxtPregunta2.setText((String) gcdd1.tbl_GD.getValueAt(fila, 8));
                gcdd1.jtxtRespuesta2.setText((String) gcdd1.tbl_GD.getValueAt(fila, 9));
                gcdd1.jtxtPregunta3.setText((String) gcdd1.tbl_GD.getValueAt(fila, 10));
                gcdd1.jtxtRespuesta3.setText((String) gcdd1.tbl_GD.getValueAt(fila, 11));
            }
        }

    }
}
