package freeRooms;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CollegeTourRecord {
    private final StringProperty blockName;
    private final StringProperty className;
    private final StringProperty timeAvailable;

    public CollegeTourRecord(String blockName, String className, String timeAvailable) {
        this.blockName = new SimpleStringProperty(blockName);
        this.className = new SimpleStringProperty(className);
        this.timeAvailable = new SimpleStringProperty(timeAvailable);
    }

    public String getBlockName() {
        return blockName.get();
    }

    public StringProperty blockNameProperty() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName.set(blockName);
    }

    public String getClassName() {
        return className.get();
    }

    public StringProperty classNameProperty() {
        return className;
    }

    public void setClassName(String className) {
        this.className.set(className);
    }

    public String getTimeAvailable() {
        return timeAvailable.get();
    }

    public StringProperty timeAvailableProperty() {
        return timeAvailable;
    }

    public void setTimeAvailable(String timeAvailable) {
        this.timeAvailable.set(timeAvailable);
    }
}
