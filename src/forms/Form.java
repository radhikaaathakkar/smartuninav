package forms;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Form {
    private final StringProperty sapId;
    private final StringProperty name;
    private final StringProperty email;
    private final StringProperty query;
    private final StringProperty reply;

    public Form(String sapId, String name, String email, String query, String reply) {
        this.sapId = new SimpleStringProperty(sapId);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.query = new SimpleStringProperty(query);
        this.reply = new SimpleStringProperty(reply);
    }

    public String getSapId() {
        return sapId.get();
    }

    public StringProperty sapIdProperty() {
        return sapId;
    }

    public void setSapId(String sapId) {
        this.sapId.set(sapId);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getQuery() {
        return query.get();
    }

    public StringProperty queryProperty() {
        return query;
    }

    public void setQuery(String query) {
        this.query.set(query);
    }

    public String getReply() {
        return reply.get();
    }

    public StringProperty replyProperty() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply.set(reply);
    }
}