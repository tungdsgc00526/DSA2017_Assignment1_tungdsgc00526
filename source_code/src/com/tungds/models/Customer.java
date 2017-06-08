package com.tungds.models;

import com.tungds.commons.ManagerMenu;

/**
 *
 * @author TungDS
 */
public class Customer implements Comparable<Object> {

    public String ccode;
    public String cname;
    public String phone;

    public Customer(String ccode) {
        this.ccode = ccode;
    }

    public Customer() {
        
    }

    @Override
    public int compareTo(Object other) {
        return ManagerMenu.compareString(this.ccode, ((Customer) other).ccode);
    }
}
