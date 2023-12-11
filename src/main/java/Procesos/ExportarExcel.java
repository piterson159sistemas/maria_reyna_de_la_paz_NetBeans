
package Procesos;

/**
 *
 * @author jheremyPonte
 */

// Importaciones necesarias para el manejo de archivos, GUI y manipulación de Excel
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Clase para exportar datos de un JTable a un archivo de Excel.
 * 
 * @author JheremyPonte
 */
public class ExportarExcel {

 public void exportarExcel(JTable t) throws IOException {
        // Configuración del cuadro de diálogo para guardar el archivo
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);

        // Muestra el cuadro de diálogo y procede si el usuario selecciona un archivo para guardar
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            // Obtiene la ruta del archivo seleccionado y agrega la extensión ".xls" si no está presente
            String ruta = chooser.getSelectedFile().toString().concat(".xls");

            try {
                // Creación del archivo Excel y su hoja de trabajo
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();  // Borra el archivo existente para evitar conflictos
                }
                archivoXLS.createNewFile();  // Crea un nuevo archivo Excel
                Workbook libro = new HSSFWorkbook();  // Usa el formato antiguo de Excel (xls)
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
                hoja.setDisplayGridlines(false);  // No muestra las líneas de cuadrícula en la hoja

                // Creación de la primera fila con los nombres de las columnas
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }

                // Llenado de las filas con los datos del JTable
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        // Manejo de diferentes tipos de datos en el JTable
                        if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                        }
                    }
                }

                // Guardar el libro en el archivo y abrirlo con la aplicación predeterminada
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);

            } catch (IOException | NumberFormatException e) {
                // Manejo de excepciones
                throw e;
            }
        }
    }
}