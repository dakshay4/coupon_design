package com.dakshay.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dakshay on 1/10/2019.
 */
public class Dakshay implements Comparator<Dakshay>{
    int id;
    String name;

    public Dakshay() {
    }

    public Dakshay(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compare(Dakshay o1, Dakshay o2) {
        return o1.getId() - o2.getId();
    }

    public static void main(String[] args) {
        List<Dakshay> dakshay = new ArrayList<>();
        dakshay.add(new Dakshay(1,"ABCD"));
        dakshay.add(new Dakshay(5,"AAAA"));
        dakshay.add(new Dakshay(8,"ABCCCD"));

        Collections.sort(dakshay,new Dakshay());
        dakshay.forEach(n -> System.out.println(n.getId() + " " + n.getName()));
    }
}
