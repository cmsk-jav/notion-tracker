package dev.sk.notionclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.joda.time.LocalDateTime;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class NotionPages {

    @JsonProperty("results")
    List<Notion> notionList;

    public void sort(){
        //notionList.sort((a,b)-> -compare(a.getLastAccess(),b.getLastAccess()) );
    }
    public int compare(LocalDateTime a, LocalDateTime b){
        if ( a==null ) return -1;
        else if (b==null) return 1;
        else return a.compareTo(b);
    }

    public List<Notion> sortAndbuild() {
        return notionList.stream()
                 // .peek(e-> e.setLastAccess(e.getLastEditedTime()))
                  .sorted((a,b)-> -compare(a.getLastAccess(),b.getLastAccess())).collect(Collectors.toList());
    }
}
