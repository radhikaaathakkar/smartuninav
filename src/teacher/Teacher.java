package teacher;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teacher {
    private final StringProperty teacherName;
    private final StringProperty blockAssigned;
    private final StringProperty contact;
    private final StringProperty email;
    private final StringProperty subject;
    private final StringProperty period1;
    private final StringProperty period2;
    private final StringProperty period3;
    private final StringProperty period4;

    public Teacher(String teacherName, String blockAssigned, String contact, String email, String subject, String period1, String period2, String period3, String period4) {
        this.teacherName = new SimpleStringProperty(teacherName);
        this.blockAssigned = new SimpleStringProperty(blockAssigned);
        this.contact = new SimpleStringProperty(contact);
        this.email = new SimpleStringProperty(email);
        this.subject = new SimpleStringProperty(subject);
        this.period1 = new SimpleStringProperty(period1);
        this.period2 = new SimpleStringProperty(period2);
        this.period3 = new SimpleStringProperty(period3);
        this.period4 = new SimpleStringProperty(period4);
    }

    // Getters for all properties
    public String getTeacherName() {
        return teacherName.get();
    }

    public String getBlockAssigned() {
        return blockAssigned.get();
    }

    public String getContact() {
        return contact.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getSubject() {
        return subject.get();
    }

    public String getPeriod1() {
        return period1.get();
    }

    public String getPeriod2() {
        return period2.get();
    }

    public String getPeriod3() {
        return period3.get();
    }

    public String getPeriod4() {
        return period4.get();
    }

    // Property getters
    public StringProperty teacherNameProperty() {
        return teacherName;
    }

    public StringProperty blockAssignedProperty() {
        return blockAssigned;
    }

    public StringProperty contactProperty() {
        return contact;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty subjectProperty() {
        return subject;
    }

    public StringProperty period1Property() {
        return period1;
    }

    public StringProperty period2Property() {
        return period2;
    }

    public StringProperty period3Property() {
        return period3;
    }

    public StringProperty period4Property() {
        return period4;
    }
}
