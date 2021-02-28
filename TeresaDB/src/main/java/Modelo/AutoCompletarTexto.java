package Modelo;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class AutoCompletarTexto implements DocumentListener {

    private static enum Mode {
        INSERT,
        COMPLETION
    };

    private JTextField textField;
    private final List<String> keywords;
    private Mode mode = Mode.INSERT;

    public AutoCompletarTexto(JTextField textField, List<String> keywords) {
        this.textField = textField;
        this.keywords = keywords;
        Collections.sort(keywords);
    }

    @Override
    public void changedUpdate(DocumentEvent ev) {
    }

    @Override
    public void removeUpdate(DocumentEvent ev) {
    }

    @Override
    public void insertUpdate(DocumentEvent ev) {
        if (ev.getLength() != 1) {
            return;
        }

        int pos = ev.getOffset();
        String content = null;
        try {
            content = textField.getText(0, pos + 1);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Find where the word starts
        int w;
        for (w = pos; w >= 0; w--) {
            if (!Character.isLetter(content.charAt(w))) {
                break;
            }
        }

        // Too few chars
        if (pos - w < 2) {
            return;
        }

        String prefix = content.substring(w + 1).toLowerCase();
        int n = Collections.binarySearch(keywords, prefix);
        if (n < 0 && -n <= keywords.size()) {
            String match = keywords.get(-n - 1);
            if (match.startsWith(prefix)) {
                // A completion is found
                String completion = match.substring(pos - w);
                // We cannot modify Document from within notification,
                // so we submit a task that does the change later
                SwingUtilities.invokeLater(new CompletionTask(completion, pos + 1));
            }
        } else {
            // Nothing found
            mode = Mode.INSERT;
        }
    }

    public class CommitAction extends AbstractAction {

        /**
         *
         */
        private static final long serialVersionUID = 5794543109646743416L;

        @Override
        public void actionPerformed(ActionEvent ev) {
            if (mode == Mode.COMPLETION) {
                int pos = textField.getSelectionEnd();
                StringBuffer sb = new StringBuffer(textField.getText());
                sb.insert(pos, " ");
                textField.setText(sb.toString());
                textField.setCaretPosition(pos + 1);
                mode = Mode.INSERT;
            } else {
                textField.replaceSelection("\t");
            }
        }
    }

    private class CompletionTask implements Runnable {

        private String completion;
        private int position;

        CompletionTask(String completion, int position) {
            this.completion = completion;
            this.position = position;
        }

        public void run() {
            StringBuffer sb = new StringBuffer(textField.getText());
            sb.insert(position, completion);
            textField.setText(sb.toString());
            textField.setCaretPosition(position + completion.length());
            textField.moveCaretPosition(position);
            mode = Mode.COMPLETION;
        }
    }
    /**
     * 
     * @param textFieldName 
     */
    public boolean pluginTextField (javax.swing.JTextField textFieldName){
        boolean ok = false;
        // Our words to complete
        ArrayList<String> keywords = new ArrayList<String>();
        //TODAS LAS PROVINCIAS DE ESPA�A
        keywords.add("a coruna");
        keywords.add("alava");
        keywords.add("albacete");
        keywords.add("alicante");
        keywords.add("almeria");
        keywords.add("asturias");
        keywords.add("avila");
        keywords.add("badajoz");
        keywords.add("baleares");
        keywords.add("barcelona");
        keywords.add("burgos");
        keywords.add("caceres");
        keywords.add("cadiz");
        keywords.add("cantabria");
        keywords.add("castellon");
        keywords.add("ceuta");
        keywords.add("ciudad real");
        keywords.add("cordoba");
        keywords.add("cuenca");
        keywords.add("girona");
        keywords.add("granada");
        keywords.add("guadalajara");
        keywords.add("guipuzcoa");
        keywords.add("huelva");
        keywords.add("huesca");
        keywords.add("jaen");
        keywords.add("la rioja");
        keywords.add("las palmas");
        keywords.add("leon");
        keywords.add("lleida");
        keywords.add("lugo");
        keywords.add("madrid");
        keywords.add("malaga");
        keywords.add("melilla");
        keywords.add("murcia");
        keywords.add("navarra");
        keywords.add("ourense");
        keywords.add("palencia");
        keywords.add("pontevedra");
        keywords.add("salamanca");
        keywords.add("tenerife");
        keywords.add("segovia");
        keywords.add("sevilla");
        keywords.add("soria");
        keywords.add("tarragona");
        keywords.add("teruel");
        keywords.add("toledo");
        keywords.add("valencia");
        keywords.add("valladolid");
        keywords.add("vizcaya");
        keywords.add("zamora");
        keywords.add("zaragoza");

        //TODAS LAS COMUNIDADES DE ESPA�A
        keywords.add("Andaluc�a");
        keywords.add("Arag�n");
        keywords.add("Asturias");
        keywords.add("Baleares");
        keywords.add("Canarias");
        keywords.add("Cantabria");
        keywords.add("Castilla-La Mancha");
        keywords.add("Castilla y Le�n");
        keywords.add("Catalu�a");
        keywords.add("Comunidad Valenciana");
        keywords.add("Extremadura");
        keywords.add("Galicia");
        keywords.add("Madrid");
        keywords.add("Murcia");
        keywords.add("Navarra ");
        keywords.add("Pa�s Vasco");
        keywords.add("La Rioja");

        textFieldName.setFocusTraversalKeysEnabled(false);
        AutoCompletarTexto autoComplete = new AutoCompletarTexto(textFieldName, keywords);
        textFieldName.getDocument().addDocumentListener(autoComplete);
        textFieldName.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "commit");
        textFieldName.getActionMap().put("commit", autoComplete.new CommitAction());
        ok = true;
        return ok;
    }
}
/*
keywords.add("A coruna");
        keywords.add("Alava");
        keywords.add("Albacete");
        keywords.add("Alicante");
        keywords.add("Almeria");
        keywords.add("Asturias");
        keywords.add("Avila");
        keywords.add("Badajoz");
        keywords.add("Baleares");
        keywords.add("Barcelona");
        keywords.add("Burgos");
        keywords.add("Caceres");
        keywords.add("Cadiz");
        keywords.add("Cantabria");
        keywords.add("Castellon");
        keywords.add("Ceuta");
        keywords.add("Ciudad real");
        keywords.add("Cordoba");
        keywords.add("Cuenca");
        keywords.add("Girona");
        keywords.add("Granada");
        keywords.add("Guadalajara");
        keywords.add("Guipuzcoa");
        keywords.add("Huelva");
        keywords.add("Huesca");
        keywords.add("Jaen");
        keywords.add("La rioja");
        keywords.add("Las palmas");
        keywords.add("Leon");
        keywords.add("Lleida");
        keywords.add("Lugo");
        keywords.add("Madrid");
        keywords.add("Malaga");
        keywords.add("Melilla");
        keywords.add("Murcia");
        keywords.add("Navarra");
        keywords.add("Ourense");
        keywords.add("Palencia");
        keywords.add("Pontevedra");
        keywords.add("Salamanca");
        keywords.add("Tenerife");
        keywords.add("Segovia");
        keywords.add("Sevilla");
        keywords.add("Soria");
        keywords.add("Tarragona");
        keywords.add("Teruel");
        keywords.add("Toledo");
        keywords.add("Valencia");
        keywords.add("Valladolid");
        keywords.add("Vizcaya");
        keywords.add("Zamora");
        keywords.add("Zaragoza");
        /*
        keywords.add("a coruna");
        keywords.add("alava");
        keywords.add("albacete");
        keywords.add("alicante");
        keywords.add("almeria");
        keywords.add("asturias");
        keywords.add("avila");
        keywords.add("badajoz");
        keywords.add("baleares");
        keywords.add("barcelona");
        keywords.add("burgos");
        keywords.add("caceres");
        keywords.add("cadiz");
        keywords.add("cantabria");
        keywords.add("castellon");
        keywords.add("ceuta");
        keywords.add("ciudad real");
        keywords.add("cordoba");
        keywords.add("cuenca");
        keywords.add("girona");
        keywords.add("granada");
        keywords.add("guadalajara");
        keywords.add("guipuzcoa");
        keywords.add("huelva");
        keywords.add("huesca");
        keywords.add("jaen");
        keywords.add("la rioja");
        keywords.add("las palmas");
        keywords.add("leon");
        keywords.add("lleida");
        keywords.add("lugo");
        keywords.add("madrid");
        keywords.add("malaga");
        keywords.add("melilla");
        keywords.add("murcia");
        keywords.add("navarra");
        keywords.add("ourense");
        keywords.add("palencia");
        keywords.add("pontevedra");
        keywords.add("salamanca");
        keywords.add("tenerife");
        keywords.add("segovia");
        keywords.add("sevilla");
        keywords.add("soria");
        keywords.add("tarragona");
        keywords.add("teruel");
        keywords.add("toledo");
        keywords.add("valencia");
        keywords.add("valladolid");
        keywords.add("vizcaya");
        keywords.add("zamora");
        keywords.add("zaragoza");
       
        
        //TODAS LAS COMUNIDADES DE ESPAÑA
        keywords.add("Andalucía");
        keywords.add("Aragón");
        keywords.add("Asturias");
        keywords.add("Baleares");
        keywords.add("Canarias");
        keywords.add("Cantabria");
        keywords.add("Castilla-La Mancha");
        keywords.add("Castilla y León");
        keywords.add("Cataluña");
        keywords.add("Comunidad Valenciana");
        keywords.add("Extremadura");
        keywords.add("Galicia");
        keywords.add("Madrid");
        keywords.add("Murcia");
        keywords.add("Navarra ");
        keywords.add("País Vasco");
        keywords.add("La Rioja");
        /*
         keywords.add("andalucía");
        keywords.add("aragón");
        keywords.add("asturias");
        keywords.add("baleares");
        keywords.add("canarias");
        keywords.add("cantabria");
        keywords.add("Ccastilla-La Mancha");
        keywords.add("castilla y León");
        keywords.add("cataluña");
        keywords.add("comunidad Valenciana");
        keywords.add("extremadura");
        keywords.add("galicia");
        keywords.add("madrid");
        keywords.add("murcia");
        keywords.add("navarra ");
        keywords.add("país Vasco");
        keywords.add("la Rioja");
        */
