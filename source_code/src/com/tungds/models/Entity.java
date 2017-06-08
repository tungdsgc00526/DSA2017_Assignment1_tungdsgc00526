package com.tungds.models;

import java.util.ArrayList;

import java.io.Serializable;

/**
 *
 * @author TungDS
 */
public class Entity implements Serializable {

    public ArrayList<Customer> customers;
    public ArrayList<Product> products;
    public ArrayList<Ordering> orderings;

}
