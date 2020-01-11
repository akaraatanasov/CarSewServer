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
public class IncomeController {
    @Autowired
    private ItemService itemService;

    @RequestMapping({"/income/list", "/income"})
    public AccountingResponse listExpense(){
        List<Item> soldItems = itemService.listAllSoldItems();
        Double overallIncome = 0.0;

        for (Item item: soldItems) {
            overallIncome += item.getPrice();
        }

        return new AccountingResponse(getOverallRounded(overallIncome), soldItems);
    }

    Double getOverallRounded(Double overall) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(overall));
    }
}
