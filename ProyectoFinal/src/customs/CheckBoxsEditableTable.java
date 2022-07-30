package customs;

public class CheckBoxsEditableTable extends NonEditableTable {
	public CheckBoxsEditableTable() {
		super();
	}
	
	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// La primera columna es la delos checkboxes
		if(columnIndex == 0) {
			this.dataModel.setValueAt(aValue, rowIndex, columnIndex);
		}
    }
}
