package com.kadet.handbook.client.service;

import com.kadet.handbook.entity.Chapter;

import java.util.List;

/**
 * Date: 10.12.13
 * Time: 2:05
 *
 * @author Кадет
 */
public interface RestService {

    public void save (Chapter chapter);
    public void update (Chapter chapter);
    public List<Chapter> findAll ();
    public boolean delete (Integer id);
    public Chapter findById (Integer id);


}
