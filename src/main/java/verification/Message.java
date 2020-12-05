package verification;

public class Message {
    Status status;
    String info, fields;
    public Message(String info, Status status, String fields){
        this.info = info;
        this.status = status;
        this.fields = fields;
    }
    public Message(Status status){
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info += " " + info;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields += fields;
    }
}

