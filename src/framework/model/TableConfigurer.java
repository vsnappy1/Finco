package framework.model;

import javax.swing.table.DefaultTableModel;

public interface TableConfigurer<T extends Account> {
	DefaultTableModel getModel();
	String[] mapToRow(T t);
}
