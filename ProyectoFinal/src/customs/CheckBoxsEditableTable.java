package customs;

import javax.swing.table.DefaultTableModel;

public class CheckBoxsEditableTable extends NonEditableTable {
	private int columnCheckboxes;

	public CheckBoxsEditableTable(DefaultTableModel model, int columnCheckboxes) {
		super();
		super.setModel(model);
		this.columnCheckboxes = columnCheckboxes;
	}

	// La primera columna es de los chec
	@Override
	public boolean isCellEditable(int row, int column) {
		if(column == columnCheckboxes)
			return true;

		return super.isCellEditable(row, column);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Class getColumnClass(int column) {
		if(column == columnCheckboxes)
			return Boolean.class;

		return String.class;
	}
}
