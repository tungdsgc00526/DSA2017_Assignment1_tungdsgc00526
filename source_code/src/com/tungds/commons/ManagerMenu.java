/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tungds.commons;

import com.tungds.enums.ResultCompare;
import com.tungds.models.Customer;
import com.tungds.models.Product;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author TungDS
 */
public class ManagerMenu {

    public static <T> void quicksort(ArrayList<T> array) {
        realQuicksort(array, 0, array.size() - 1);
    }

    private static <T> void realQuicksort(ArrayList<T> array, int left, int right) {

        if (left >= right) {
            return;
        }

        T pivot = array.get((left + right) / 2);
        int index = partition(array, left, right, pivot);
        realQuicksort(array, left, index - 1);
        realQuicksort(array, index, right);
    }

    private static <T> int partition(ArrayList<T> array, int left, int right, Object pivot) {

        while (left <= right) {

            while (((Comparable) array.get(left)).compareTo(pivot) == ResultCompare.LESS) {
                left++;
            }

            while (((Comparable) array.get(right)).compareTo(pivot) == ResultCompare.GREATER) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);

                left++;
                right--;
            }
        }

        return left;
    }

    public static <T> int binarysreach(ArrayList<T> array, T fakeDataWithCode) {
        return realBinarysreach(array, fakeDataWithCode, 0, array.size());
    }

    private static <T> int realBinarysreach(ArrayList<T> array, T fakeDataWithCode, int left, int right) {

        System.out.println("size: " + array.size() + " - left: " + left + " - right: " + right);

        if (left > right) {
            return -1;
        }

        int middle = (left + right) / 2;
        System.out.println("middle: " + middle);
        int compareResult = ((Comparable) array.get(middle)).compareTo(fakeDataWithCode);

        if (compareResult == ResultCompare.EQUAL) {
            return middle;
        } else if (compareResult == ResultCompare.GREATER) {
            return realBinarysreach(array, fakeDataWithCode, left, middle - 1);

        } else {
            return realBinarysreach(array, fakeDataWithCode, middle + 1, right);
        }
    }

    public static <T> void shuffleArray(ArrayList<T> array) {
        int n = array.size();
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(array, i, change);
        }
    }

    private static <T> void swap(ArrayList<T> array, int i, int change) {
        T cacheData = array.get(i);
        array.set(i, array.get(change));
        array.set(change, cacheData);
    }

    public static int compareString(String a, String b) {
        int result = a.compareTo(b);
        if (result > 0) {
            return ResultCompare.GREATER;
        } else if (result < 0) {
            return ResultCompare.LESS;
        } else {
            return ResultCompare.EQUAL;
        }
    }

    public static Customer getCustomerByCode(ArrayList<Customer> customers, String code) {
        int result = ManagerMenu.binarysreach(customers, new Customer(code));

        if (result == -1) {
            return null;
        }

        return customers.get(result);

    }

    public static int getIndexCustomerByCode(ArrayList<Customer> customers, String code) {
        int result = ManagerMenu.binarysreach(customers, new Customer(code));

        return result;
    }

    public static Product getProductByCode(ArrayList<Product> products, String code) {
        int result = ManagerMenu.binarysreach(products, new Product(code));

        if (result == -1) {
            return null;
        }

        return products.get(result);

    }

    public static int getIndexProductByCode(ArrayList<Product> products, String code) {
        int result = ManagerMenu.binarysreach(products, new Product(code));

        return result;
    }
}
