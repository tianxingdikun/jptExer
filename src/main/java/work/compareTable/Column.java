package work.compareTable;

public class Column {
    public String columnName;
    public String dataType;
    public int length;

    public Column(String columnName, String dataType, int length) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.length = length;
    }
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public String getDataType() {
        return dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
}
