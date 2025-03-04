package com.communication.project_backend.Dao;
import com.communication.project_backend.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ItemDao extends JpaRepository<Item,Integer> {

}


