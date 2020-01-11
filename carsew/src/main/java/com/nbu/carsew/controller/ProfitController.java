package com.nbu.carsew.controller;

import com.nbu.carsew.dataobject.AccountingResponse;
import com.nbu.carsew.entity.Items.Item;
import com.nbu.carsew.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.List;

@RestController
public class ProfitController {
    @Autowired
    private ItemService itemService;

    @RequestMapping({"/profit/list", "/profit"})
    public AccountingResponse listExpense(){
        List<Item> soldItems = itemService.listAllSoldItems();
        Double overallProfit = 0.0;

        for (Item item: soldItems) {
            overallProfit += getItemProfit(item);
        }

        Double incomeTax = 1 - 10/100.0;
        if (overallProfit > 0) {
            overallProfit = overallProfit * incomeTax;
        }

        return new AccountingResponse(getOverallRounded(overallProfit), soldItems);
    }

    Double getItemProfit(Item item) {
        var materialsPrice = item.getType().getMaterialsPrice();
        var employeeItemsPerHour = item.getEmployee().getExperience().getItemsPerHour();
        var employeeSalary = item.getEmployee().getSalary();
        var laborCost = employeeSalary / employeeItemsPerHour;
        var itemCost = materialsPrice + laborCost;
        var itemPrice = item.getPrice();
        return itemPrice - itemCost;
    }

    Double getOverallRounded(Double overall) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(overall));
    }
}
