package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.ViewUsersList;

/** @author Muhamad Sholihin **/

@Repository
public interface ViewUsersListRepository extends JpaRepository<ViewUsersList, Integer>{

	public ViewUsersList findByMail(@Param("mail") String mail);
}
