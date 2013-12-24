package com.kadet.handbook.client.bussinessDelegate;

import com.kadet.handbook.client.service.RestService;
import com.kadet.handbook.client.service.impl.RestServiceImpl;

/**
 * Date: 15.12.13
 * Time: 16:14
 *
 * @author Кадет
 */
public class LookUpService {

    public RestService lookupService (ServiceType serviceType) {

        switch (serviceType) {
            case REST_SERVICE: {
                return new RestServiceImpl();
            }
        }
        return null;
    }

}
