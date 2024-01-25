package example.reqres.dto;

public class GetUserResponse {
    Data DataObject;
    Support SupportObject;

    // Getter Methods

    public Data getData() {
        return DataObject;
    }

    public Support getSupport() {
        return SupportObject;
    }

    // Setter Methods

    public void setData(Data dataObject) {
        this.DataObject = dataObject;
    }

    public void setSupport(Support supportObject) {
        this.SupportObject = supportObject;
    }
}
class Support {
    private String url;
    private String text;


    // Getter Methods

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

    // Setter Methods

    public void setUrl(String url) {
        this.url = url;
    }

    public void setText(String text) {
        this.text = text;
    }
}
