package com.nbu.carsew.controller;

import com.nbu.carsew.dataobject.AccountingResponse;
import com.nbu.carsew.entity.Items.Item;
import com.nbu.carsew.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    private ItemService itemService;

    @RequestMapping({"/expense/list", "/expense"})
    public AccountingResponse listExpense(){
        List<Item> producedItems = itemService.listAllProducedItems();
        Double overallExpense = 0.0;

        for (Item item: producedItems) {
            overallExpense += getItemCost(item);
        }

        return new AccountingResponse(getOverallRounded(overallExpense), producedItems);
    }

    Double getItemCost(Item item) {
        var materialsPrice = item.getType().getMaterialsPrice();
        var employeeItemsPerHour = item.getEmployee().getExperience().getItemsPerHour();
        var employeeSalary = item.getEmployee().getSalary();
        var laborCost = employeeSalary / employeeItemsPerHour;
        return materialsPrice + laborCost;
    }

    Double getOverallRounded(Double overall) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(overall));
    }
}