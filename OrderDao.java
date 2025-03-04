package com.communication.project_backend.Dao;

import com.communication.project_backend.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderDao extends JpaRepository<Order,Integer> {

}
