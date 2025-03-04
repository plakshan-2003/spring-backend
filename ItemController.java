package com.communication.project_backend.Controller;
import com.communication.project_backend.Dao.ItemDao;
import com.communication.project_backend.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(path = "/api/item")

public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @GetMapping("/getItems")
    public List<Item> getItems(Item item) {
        List<Item> items = itemDao.findAll();
        return items;

    }

    @PostMapping("/saveItem")
    public String saveUser(@RequestBody Item item) {
        int id = item.getId();
        if (itemDao.existsById(id)) {
            return "exsisting Item";
        } else {
            itemDao.save(item);
            return "Item save successfully";
        }
    }

    @PutMapping("/updateItem")
    public String updateUser(@RequestBody Item item) {

        int id = item.getId();
        if (itemDao.existsById(id)) {
            itemDao.save(item);
            return "Item Updated successfully";
        } else {
            return "can not updated this Item";
        }
    }

    @DeleteMapping("/deleteItem/{id}")
    public String delete(@PathVariable Integer id) {
        
        if (itemDao.existsById(id)) {
          Item item =itemDao.findById(id).orElseThrow(() -> new RuntimeException("Item Not found"));
         
            itemDao.delete(item);
            return "Item was delete sucsessfully";
        } else {
            return "could not delete this Item correctly";
        }
    }
}