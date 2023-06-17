package dev.sk.notionclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.List;
import java.util.Map;

@Data
public class Notion {
    @JsonProperty("object")
    String objectType;
    @JsonProperty("id")
    String objectID;
    String created_time;
//    String last_edited_time;
    CoverProperty cover;
    Map<String,Map<Object, Object>> properties;

    @JsonProperty("last_edited_time")
    LocalDateTime lastAccess;
    final static String EMPTY = "Not-Specified";

    DateTimeFormatter iso = ISODateTimeFormat.dateTime();

    public String getAuthorName(){
        try{
            return ( (List<Map<String,Object>>)(properties.get("Author").get("rich_text"))).get(0).get("plain_text").toString();
        }catch (Exception exception){
            System.err.println("Author Name Not Found");
        }
        return EMPTY;
    }

    public String getBookName(){
        try {
            return ( (List<Map<String,Object>>)(properties.get("Name").get("title"))).get(0).get("plain_text").toString();
        }catch (Exception ex){
            System.err.println("Book-Name Not Found");
        }
        return EMPTY;
    }

    public String getTotalPages(){
        try {
            return properties.get("TotalPages").get("number").toString();
        }catch (Exception ex){
            System.err.println("Total Pages Not Found");
        }
        return "0";
    }

    public String getStartPage(){
        try {
            return properties.get("Page-To-Start").get("number").toString();
        }catch (Exception ex){
            System.err.println("Start Page Not Found");
        }
        return "0";
    }

   /* public LocalDateTime getLast_edited_time(){
        try{
            return LocalDateTime.parse(properties.get("Last Access").get("last_edited_time").toString(), iso);
        }catch (Exception ex){
            System.err.println("Lass-Access Not Found");
        }
        return null;
    }

    public void setLast_edited_time(String last_edited_time){
        try{
            this.lastAccess =  LocalDateTime.parse(last_edited_time, iso);
        }catch (Exception ex){
            this.lastAccess =  null;
            System.err.println("Lass-Access Not Found");
        }
    }*/
    public LocalDateTime getLastAccess(){
        return lastAccess;
    }

    public void setLastAccess(String lastAccess){
        try{
            this.lastAccess =  LocalDateTime.parse(lastAccess, iso);
        }catch (Exception ex){
            this.lastAccess =  null;
            System.err.println("Lass-Access Not Found");
        }
    }



}
