package ibf2022.batch2.csf.backend.models;

import java.util.Date;
import java.util.List;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Bundle {
    
    private String bundleId;
    private Date date;
    private String title;
    private String name;
    private String comments;
    private List<String> urls;

    public String getBundleId() {
        return bundleId;
    }
    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public List<String> getUrls() {
        return urls;
    }
    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public Document toDocument(){
        JsonObject jo = Json.createObjectBuilder()
                .add("bundleId", getBundleId())
                .add("date", getDate().toString())
                .add("title", getTitle())
                .add("name", getName())
                .add("comments", getComments())
                .add("urls", getUrls().toString())
                .build();

        return Document.parse(jo.toString());
    }
    
}
