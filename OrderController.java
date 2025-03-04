package com.communication.project_backend.Controller;
import com.communication.project_backend.Dao.OrderDao;
import com.communication.project_backend.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/order")

public class OrderController {
    @Autowired
    private OrderDao orderDao;

    @GetMapping("/getorders")
    public List<Order> getAll(Order order){
       List<Order> ordersList = orderDao.findAll();
       return ordersList;
    }


    @PostMapping("/saveOrder")
    public String saveOrder(@RequestBody Order order) {
        int id = order.getId();
        if (orderDao.existsById(id)) {
            return "exsisting Order";
        } else {
            orderDao.save(order);
            return "Order saved successfully";
        }
    }


    @PutMapping("/updateOrder")
    public String updateOrder(@RequestBody Order order) {

        int id = order.getId();
        if (orderDao.existsById(id)) {
            orderDao.save(order);
            return "Order Updated successfully";
        } else {
            return "can not updated this Order";
        }
    }


    @DeleteMapping("/deleteOrder/{id}")
    public String delete(@PathVariable Integer id) {

        if (orderDao.existsById(id)) {
            Order order =orderDao.findById(id).orElseThrow(() -> new RuntimeException("Order Not found"));

            orderDao.delete(order);
            return "Order was delete sucsessfully";
        } else {
            return "could not delete this Order correctly";
        }
    }

}
