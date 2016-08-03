package com.example.henri_000.fechaaconta.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by henri_000 on 21/08/2015.
 */

@DatabaseTable(tableName = "item")
public class Item {

    public void set_id(Long _id) {
        this._id = _id;
    }

    public Long get_id() {

        return _id;
    }

    @DatabaseField(generatedId = true)
    private Long _id;


    @DatabaseField
    private String _name;
    @DatabaseField
    private float _price;

    public Item(){}

    public Item(String name, float price) {
        _name = name;
        _price = price;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_price(float _price) {
        this._price = _price;
    }

    public String get_name() {
        return _name;
    }

    public float get_price() {
        return _price;
    }
}
