package dev.sk.notionclient.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CoverProperty {
    @JsonProperty("type")
    String objectType;

//    @JsonProperty("file")
    @JsonAlias({"file","external"})
    Map<String, String> file;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Map<String, String> getFile() {
        return file;
    }

    public void setFile(Map<String, String> files) {
        this.file = files;
//        file.computeIfAbsent("file",k->file.put(k,files.get("external")));
    }

    public String getBannerURL(){
        try{
            return this.file.get("url");
        }catch (Exception exception){
            System.err.println("Banner URL Not Specified");
        }
        return "";
    }
}
