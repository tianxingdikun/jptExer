package work.compareTable;

import java.util.HashMap;

public class Table {

    public String tableName;
    public HashMap columns = new HashMap();

    public Table(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public HashMap getColumns() {
        return columns;
    }

    public void setColumns(HashMap columns) {
        this.columns = columns;
    }
}
