package com.itview.office_management_system.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itview.office_management_system.entity.Status;

@Repository
public interface StatusRepo extends JpaRepository<Status, Integer>{

	@Query(value="Select * from status_table",nativeQuery = true)
	List<Status> getAll();

}
