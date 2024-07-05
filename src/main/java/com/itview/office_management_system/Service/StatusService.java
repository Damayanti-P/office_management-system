package com.itview.office_management_system.Service;


import java.util.*;

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

	public Status getStatusById(int id) {
		Status status=sRepo.findById(id).get();
		return status;
	}
	
	public List<Status> getAll()
	{
		List<Status> allStatus=sRepo.getAll();
		return allStatus;
	}

	public void deleteStatus(int id)
	{
		sRepo.deleteById(id);
	}
	
	public void updateStatus(Status statusNew,int id)
	{
		Status status=getStatusById(id);
		statusNew.setStatusId(status.getStatusId());
		saveStatus(statusNew);
	}

	public Status saveDefaultStatus(Status statusData) {
		// TODO Auto-generated method stub
		return null;
	}
}
