package com.nbu.carsew.service;

import com.nbu.carsew.dataobject.ItemAddParameters;
import com.nbu.carsew.entity.Employees.Employee;
import com.nbu.carsew.entity.Items.Color;
import com.nbu.carsew.entity.Items.Item;
import com.nbu.carsew.entity.Items.ItemType;
import com.nbu.carsew.repository.ColorRepository;
import com.nbu.carsew.repository.EmployeeRepository;
import com.nbu.carsew.repository.ItemRepository;
import com.nbu.carsew.repository.ItemTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemTypeRepository itemTypeRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Item> listAll() {
        List<Item> Items = new ArrayList();
        itemRepository.findAll().forEach(item -> {
            if (!item.getIsProduced() && !item.getIsSold()) {
                Items.add(item);
            }
        });
        return Items;
    }

    public List<Item> listAllProducedItems() {
        List<Item> Items = new ArrayList();
        itemRepository.findAll().forEach(item -> {
            if (item.getIsProduced() && !item.getIsSold()) {
                Items.add(item);
            }
        });
        return Items;
    }

    public List<Item> listAllSoldItems() {
        List<Item> Items = new ArrayList();
        itemRepository.findAll().forEach(item -> {
            if (item.getIsProduced() && item.getIsSold()) {
                Items.add(item);
            }
        });
        return Items;
    }

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public void addItemFromParameters(ItemAddParameters parameters) {
        Optional<ItemType> type = itemTypeRepository.findById(parameters.getTypeId());
        Optional<Color> color = colorRepository.findById(parameters.getColorId());
        Optional<Employee> employee = employeeRepository.findById(parameters.getEmployeeId());
        Item item = new Item(parameters.getName(), parameters.getPrice(), type.get(), color.get(), employee.get());
        addItem(item);
    }

    public Optional<Item> getById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Color> listColors() {
        List<Color> Colors = new ArrayList();
        colorRepository.findAll().forEach(color -> Colors.add(color));
        return Colors;
    }

    public List<ItemType> listItemTypes() {
        List<ItemType> ItemTypes = new ArrayList();
        itemTypeRepository.findAll().forEach(type -> ItemTypes.add(type));
        return ItemTypes;
    }

    public boolean produceItem(long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);

        if (!optionalItem.isEmpty()) {
            Item item = optionalItem.get();
            if (!item.getIsProduced() && !item.getIsSold()) {
                item.setIsProduced(true);
                itemRepository.save(item);
                return true;
            }
        }

        return false;
    }

    public boolean sellItem(long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);

        if (!optionalItem.isEmpty()) {
            Item item = optionalItem.get();
            if (item.getIsProduced() && !item.getIsSold()) {
                item.setIsSold(true);
                itemRepository.save(item);
                return true;
            }
        }

        return false;
    }

    public Item saveOrUpdate(Item Item) {
        itemRepository.save(Item);
        return Item;
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}