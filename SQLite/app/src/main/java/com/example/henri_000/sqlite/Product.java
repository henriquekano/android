package com.example.henri_000.sqlite;

/**
 * Created by henri_000 on 19/08/2015.
 */
public class Product {

    private int _id;
    private String _name;

    public Product(){}

    public Product(String name) {
        _name = name;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}
