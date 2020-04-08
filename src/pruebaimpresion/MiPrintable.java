package pruebaimpresion;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * Fuente : http://chuwiki.chuidiang.org/index.php?title=Imprimir_desde_java
 * @author Ber&Ben
 */
public class MiPrintable implements Printable {

    @Override
    public int print(Graphics g, PageFormat f, int pageIndex) {
        if (pageIndex == 0) {
            // Imprime "Hola mundo" en la primera pagina, en la posicion 100,100
            g.drawString("Hola mundo", 100, 100);
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }

    public static void main(String[] args) {

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new MiPrintable());
        try {
            // Diálogo para elegir el formato de impresión
            PageFormat pageFormat = new PageFormat();
            pageFormat = job.pageDialog(pageFormat);

            // Diálogo para confirmar impresion.
            // Devuelve true si el usuario decide imprimir.
            if (job.printDialog()) {
                
                job.print();
                
                
            }
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}
