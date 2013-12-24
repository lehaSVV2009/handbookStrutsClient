package com.kadet.handbook.client.bussinessDelegate;

import com.kadet.handbook.client.service.RestService;
import com.kadet.handbook.entity.Chapter;

import java.util.List;

/**
 * Date: 15.12.13
 * Time: 16:14
 *
 * @author Кадет
 */
public class BusinessDelegate {

    private final static BusinessDelegate instance = new BusinessDelegate();

    public final static BusinessDelegate getInstance() {
        return instance;
    }

    private LookUpService lookUpService;

    private RestService service;

    public BusinessDelegate() {
        this.lookUpService = new LookUpService();
        setService(ServiceType.REST_SERVICE);
    }

    private void setService (ServiceType serviceType) {
        service = lookUpService.lookupService(serviceType);
    }

    public void save (Chapter chapter) {
        service.save(chapter);
    }

    public void update (Chapter chapter) {
        service.update(chapter);
    }

    public List<Chapter> findAll () {
        return service.findAll();
    }

    public boolean delete (Integer id) {
        return service.delete(id);
    }

    public Chapter findById (Integer id) {
        return service.findById(id);
    }


}
