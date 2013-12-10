package com.kadet.handbook.client.service.impl;

import com.kadet.handbook.client.db.TestDB;
import com.kadet.handbook.client.service.RestService;
import com.kadet.handbook.entity.Chapter;

import java.util.List;

/**
 * Date: 10.12.13
 * Time: 2:05
 *
 * @author Кадет
 */
public class RestServiceImpl implements RestService {

    private TestDB testDB = TestDB.getInstance();

    @Override
    public void saveOrUpdate(Chapter chapter) {
        testDB.saveOrUpdate(chapter);
    }

    @Override
    public List<Chapter> findAll() {
        return testDB.findAll();
    }

    @Override
    public boolean delete(Long id) {
        return testDB.delete(id);
    }

    @Override
    public Chapter findById(Long id) {
        return testDB.findById(id);
    }
}
