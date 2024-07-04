package com.itview.office_management_system.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itview.office_management_system.entity.Status;

@Repository
public interface StatusRepo extends JpaRepository<Status, Integer>{

}
