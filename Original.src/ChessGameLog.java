import javax.swing.*;
import java.util.Date;
// -------------------------------------------------------------------------
/**
 * Un textArea desplazable que representa el registro del juego. (es decir, los movimientos realizados
 * por cada jugador)
 * 
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class ChessGameLog
    extends JScrollPane{
    private JTextArea textArea;
    // ----------------------------------------------------------
    /**
     * Crea un nuevo objeto de la clase ChessGameLog
     */
    public ChessGameLog(){
        super(
            new JTextArea( "", 5, 30 ),
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
        textArea = ( (JTextArea)this.getViewport().getView() );
    }
    // ----------------------------------------------------------
    /**
     * Añade una nueva línea de texto al registro.
     *
     * @param s
     *            la línea de texto a añadir
     */
    public void addToLog(String s) {
        String logText = new Date() + " - " + s;
        if (textArea.getText().length() > 0) {
            textArea.setText(textArea.getText() + "\n" + logText);
        } else {
            textArea.setText(logText);
        }
    }

    /**
     * Borra el registro.
     */
    public void clearLog(){
        textArea.setText( "" );
    }
    // ----------------------------------------------------------
    /**
     * Obtiene la declaración más reciente agregada al registro.
     *
     * @return Cadena La declaración de registro más reciente
     */
    public String getLastLog() {
        String log = textArea.getText();
        int indexOfLastNewLine = log.lastIndexOf("\n");
        if (indexOfLastNewLine < 0) {
            return log;
        }
        return log.substring(indexOfLastNewLine + 1);
    }
}
