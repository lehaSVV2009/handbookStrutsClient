package com.kadet.handbook.client.service.impl;

import com.kadet.handbook.client.service.RestService;
import com.kadet.handbook.entity.Chapter;
import com.kadet.handbook.entity.ChapterWrapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Date: 10.12.13
 * Time: 2:05
 *
 * @author Кадет
 */
public class RestServiceImpl implements RestService {

    private final static String REST_ROOT_URL = "http://localhost:8080/handbookSpringServer-1.0.0-SNAPSHOT-D/";
    private final Client client = ClientBuilder.newClient();

    private final static String REST_SERVICE_PATH = "publisher";
    private final static String CHAPTER_PATH = "chapter";
    private final static String CHAPTERS_PATH = "chapters";


    @Override
    public void save(Chapter chapter) {
        Entity<Chapter> entity
                = Entity.entity(chapter, MediaType.APPLICATION_XML);
        Response response = client.target(REST_ROOT_URL).
                path(REST_SERVICE_PATH).
                path(CHAPTER_PATH).
                request().
                post(entity);
    }

    @Override
    public void update(Chapter chapter) {
        Entity<Chapter> entity
                = Entity.entity(chapter, MediaType.APPLICATION_XML);
        Response response = client.target(REST_ROOT_URL).
                path(REST_SERVICE_PATH).
                path(CHAPTER_PATH).
                request().
                put(entity);
    }


    @Override
    public List<Chapter> findAll() {
        Response response = client.target(REST_ROOT_URL).
                path(REST_SERVICE_PATH).
                path(CHAPTERS_PATH).
                request(MediaType.APPLICATION_XML).
                get();
        ChapterWrapper chapterWrapper = response.readEntity(ChapterWrapper.class);
        return chapterWrapper.getChapters();
    }

    @Override
    public boolean delete(Integer id) {
        Response response = client.target(REST_ROOT_URL).
                path(REST_SERVICE_PATH).
                path(CHAPTER_PATH).
                path(String.valueOf(id)).
                request()
                .delete();
        return true;
    }

    @Override
    public Chapter findById(Integer id) {
        Response response = client.target(REST_ROOT_URL).
                path(REST_SERVICE_PATH).
                path(CHAPTER_PATH).
                path(String.valueOf(id)).
                request(MediaType.APPLICATION_XML).
                get();
        Chapter chapter = response.readEntity(Chapter.class);
        return chapter;
    }
}
