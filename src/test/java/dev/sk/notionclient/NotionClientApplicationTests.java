package dev.sk.notionclient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.sk.notionclient.model.Notion;
import dev.sk.notionclient.model.NotionPages;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.util.List;


@RunWith(JUnit4.class)
class NotionClientApplicationTests {

    @Test
    void contextLoads() throws Exception{
        /*
        File jsonResult = new File("response.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        NotionPages ls = objectMapper.readValue(jsonResult,NotionPages.class);
        List<Notion> sortedList=  ls.sortAndbuild();
        for ( Notion notion : sortedList){
             var properties = notion.getProperties();

            System.out.println("Book Name::" + notion.getBookName() );
            System.out.println("Author::" + notion.getAuthorName() );
            System.out.println("Last Access::" + notion.getLastAccess() );
            System.out.println("Total::"+ notion.getTotalPages());
            System.out.println("Start::"+ notion.getStartPage());
            System.out.println("Page URL::"+ notion.getCover().getBannerURL());
            System.out.println("=====================");
        }
        */
    }

    @Test
    void test(){
    }

}
