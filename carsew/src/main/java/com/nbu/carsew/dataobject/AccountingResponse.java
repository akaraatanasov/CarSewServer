package com.nbu.carsew.dataobject;

import com.nbu.carsew.entity.Items.Item;

import java.util.List;

public class AccountingResponse {
    private Double overall;
    private List<Item> items;

    public AccountingResponse(Double overall, List<Item> items) {
        this.overall = overall;
        this.items = items;
    }

    public Double getOverall() {
        return overall;
    }

    public List<Item> getItems() {
        return items;
    }
}
