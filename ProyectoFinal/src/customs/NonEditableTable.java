package customs;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/*
 * JTable con single selection, sin reordenamiento y no-editable
 */
public class NonEditableTable extends JTable{
	public NonEditableTable() {
		super();
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
