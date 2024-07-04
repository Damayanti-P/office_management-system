package com.itview.office_management_system.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itview.office_management_system.DAO.StatusRepo;
import com.itview.office_management_system.entity.Status;

@Service
public class StatusService {
	
	@Autowired
	StatusRepo sRepo;
	
	public Status saveStatus(Status statusData) 
	{
		Status  status=sRepo.save(statusData);
		return status;
	}

}
