package seedu.duke.schedule.lecture;

public class Lecture {

    protected String moduleName;
    protected String dateFrom;
    protected String dateTo;

    public Lecture(String moduleName, String dateFrom, String dateTo) {
        this.moduleName = moduleName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public String toSaveFileFormat() {
        return moduleName + "|" + dateFrom + "|" + dateTo;
    }

}