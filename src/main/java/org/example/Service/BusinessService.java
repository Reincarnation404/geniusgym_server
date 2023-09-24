package org.example.Service;



import org.example.bean.Business;

import java.util.List;

public interface BusinessService {

	List<Business> findAll();

	boolean register(Business business);

	boolean editBusiness(Business business);

	boolean editSuspend(Business business);

}
