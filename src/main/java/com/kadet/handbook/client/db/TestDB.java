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
                createChapter("title1", "text1", 1));
        chapters.add(
                createChapter("title2", "text2", 2));
        chapters.add(
                createChapter("title3", "text3", 3));
        chapters.add(
                createChapter("title4", "text4", 4));
    }

    private Chapter createChapter (String title, String text, Integer id) {
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

    
    public boolean delete(Integer id) {
        chapters.remove(id);
        return true;
    }

    
    public Chapter findById(Integer id) {
        for (Chapter chapter : chapters) {
            if (chapter.getId() == id) {
                return chapter;
            }
        }
        return null;
    }
    
}
