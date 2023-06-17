package dev.sk.notionclient.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.sk.notionclient.model.Notion;
import dev.sk.notionclient.model.NotionPages;
import dev.sk.notionclient.service.NotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    NotionService notionService;

    @RequestMapping("/download")
    public ResponseEntity<Resource> getFile()throws Exception{
        File file = notionService.getBooksAsFile();
        Resource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=notion-books.txt");

        return ResponseEntity.ok()
                             .headers(headers)
                             .contentLength(file.length())
                             .contentType(MediaType.APPLICATION_OCTET_STREAM)
                             .body(resource);
    }



}
