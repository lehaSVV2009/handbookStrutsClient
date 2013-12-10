package com.kadet.handbook.client.db;

import com.kadet.handbook.entity.Chapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 10.12.13
 * Time: 2:45
 *
 * @author Кадет
 */
public class TestDB {

    private static final TestDB instance = new TestDB();

    public static TestDB getInstance () {
        return instance;
    }

    private List<Chapter> chapters;

    public TestDB() {
        this.chapters = new ArrayList<Chapter>();
        generateChapters();
    }

    private void generateChapters () {
        chapters.add(
                createChapter("title1", "text1", 1L));
        chapters.add(
                createChapter("title2", "text2", 2L));
        chapters.add(
                createChapter("title3", "text3", 3L));
        chapters.add(
                createChapter("title4", "text4", 4L));
    }

    private Chapter createChapter (String title, String text, Long id) {
        Chapter chapter
                = new Chapter(title, text);
        chapter.setId(id);
        return chapter;
    }

    
    public void saveOrUpdate(Chapter chapter) {
        chapters.add(chapter);
    }

    
    public List<Chapter> findAll() {
        return chapters;
    }

    
    public boolean delete(Long id) {
        return chapters.remove(id - 1);
    }

    
    public Chapter findById(Long id) {
        return chapters.get((int)(id - 1));
    }
    
}
