package com.tungds.models;

import com.tungds.commons.ManagerMenu;

/**
 *
 * @author TungDS
 */
public class Ordering implements Comparable<Object> {

    public String pcode;
    public String ccode;
    public int quantity;
    public String pro_image_url;

    public Ordering() {

    }

    public String getCombineCode() {
        return pcode + ccode;
    }

    @Override
    public int compareTo(Object other) {
        Ordering orderOther = (Ordering) other;
        return ManagerMenu.compareString(this.getCombineCode(), orderOther.getCombineCode());
    }

}
