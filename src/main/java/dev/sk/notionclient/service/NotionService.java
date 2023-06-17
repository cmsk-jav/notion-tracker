package dev.sk.notionclient.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.sk.notionclient.model.Notion;
import dev.sk.notionclient.model.NotionPages;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotionService {

    @Value("${database_id}")
    String db_id ;

    @Value("${api_key}")
    String API_KEY ;

    BufferedWriter writer ;
    ObjectMapper objectMapper = new ObjectMapper();

    public NotionService() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public File getBooksAsFile()throws Exception{
        /*File jsonResult = new File("response.json");
        List<Notion> ls = objectMapper.readValue(jsonResult,NotionPages.class).sortAndbuild();*/

        List<Notion> ls = objectMapper.readValue(callNotionAPI(),NotionPages.class).sortAndbuild();
        File output = new File("notion-books.txt");
        writer = new BufferedWriter( new FileWriter(output));

        for ( Notion notion : ls){
            writer.write("Book Name::" + notion.getBookName());
            writer.newLine();
            writer.write("Author::" + notion.getAuthorName() );
            writer.newLine();
            writer.write("Last Access::" + notion.getLastAccess() );
            writer.newLine();
            writer.write("Total::"+ notion.getTotalPages());
            writer.newLine();
            writer.write("Start::"+ notion.getStartPage());
            writer.newLine();
            writer.write("Page URL::"+ notion.getCover().getBannerURL());
            writer.newLine();
            writer.write("=====================");
            writer.newLine();
        }

        writer.flush();
        writer.close();
        return output;

    }

    public List<Notion> getNotionList(){
        try{
//            List<Notion> ls = objectMapper.readValue(jsonResult,NotionPages.class).sortAndbuild();
            return  objectMapper.readValue(callNotionAPI(),NotionPages.class).sortAndbuild();
        }catch (Exception ex){
            return List.of();
        }
    }

    public String callNotionAPI()throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(new URI(String.format("https://api.notion.com/v1/databases/%s/query",db_id)))
                                         .header("Notion-Version", "2022-06-28")
                                         .header("Authorization",String.format("Bearer %s",API_KEY))
                                         .POST(HttpRequest.BodyPublishers.noBody())
                                         .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
