package com.tungds.models;

import com.tungds.commons.ManagerMenu;

/**
 *
 * @author TungDS
 */
public class Product implements Comparable {

    public String pcode;
    public String pname;
    public int quantity;
    public int saled;
    public double price;

    public Product() {
    }

    public Product(String pcode) {
        this.pcode = pcode;
    }

    @Override
    public int compareTo(Object other) {
        return ManagerMenu.compareString(this.pcode, ((Product) other).pcode);
    }

}
