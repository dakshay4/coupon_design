package com.dakshay.service;


import com.dakshay.Exception.DException;

import java.util.List;

/**
 * Created by Dakshay on 10/19/2018.
 */
public interface ISmsTemplateService<T> {
    List<T> findAll();
    void save(T t);
    String findSmsTemplateByType(String type) throws DException;
}
