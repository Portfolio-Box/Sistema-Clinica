package ar.com.clinicamedica.swingview;

import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.border.TitledBorder.TOP;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

import ar.com.clinicamedica.model.PatientTableModel;
import ar.com.clinicamedica.values.Fonts;

public class FilterPanel extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField   filterText;
	public TableRowSorter<PatientTableModel> sorter;
    
	public FilterPanel(TableRowSorter<PatientTableModel> sorter,JTextField filterText) {
		// TODO Auto-generated constructor stub
		this.sorter=sorter;
		this.filterText=filterText;
		setLayout(new FlowLayout());
		JLabel l1 = new JLabel("INGRESAR DNI:");
        l1.setForeground(new Color(0, 122, 244));
        l1.setFont(Fonts.F);
        add(l1);
        
        this.filterText=new JTextField(10);
        this.filterText.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                        
                    }
                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                      
                    }
                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                        
                    }
                });
        l1.setLabelFor(this.filterText);
      add(this.filterText);
      setBorder(createTitledBorder(null, "BUSCAR PACIENTE POR", TitledBorder.CENTER, TOP));
	}
	private void newFilter() {
        RowFilter<PatientTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(filterText.getText(), 0);
            
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }

}
