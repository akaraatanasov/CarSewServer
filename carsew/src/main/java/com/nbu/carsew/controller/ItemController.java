package com.nbu.carsew.controller;

import com.nbu.carsew.dataobject.ItemAddParameters;
import com.nbu.carsew.dataobject.ItemCreateParameters;
import com.nbu.carsew.dataobject.SuccessResponse;
import com.nbu.carsew.entity.Items.Item;
import com.nbu.carsew.service.EmployeeService;
import com.nbu.carsew.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/item/list";
    }

    @RequestMapping({"/item/list", "/item"})
    public List<Item> listItems(){
        return itemService.listAll();
    }

    @RequestMapping("/item/create")
    public ItemCreateParameters getItemCreateParamteters() {
        return new ItemCreateParameters(itemService.listColors(), itemService.listItemTypes(), employeeService.listAll());
    }

    @RequestMapping("/item/produce/{id}")
    public SuccessResponse produceItem(@PathVariable("id") long id) {
        return new SuccessResponse(itemService.produceItem(id));
    }

    @RequestMapping("/item/sell/{id}")
    public SuccessResponse sellItem(@PathVariable("id") long id) {
        return new SuccessResponse(itemService.sellItem(id));
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/employee/create")
//    void addItem(@RequestBody Employee employee) {
//        employeeService.addEmployee(employee);
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/item/create")
    void addItem(@RequestBody ItemAddParameters itemParameters) {
        itemService.addItemFromParameters(itemParameters);
    }

}
