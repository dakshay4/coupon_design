package com.dakshay.service;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Dakshay on 11/2/2018.
 */
public class BaseService<T,K> {

    public K getPersistenceObject(T source) {
        K target =null;
        try {
            Field[] fields = source.getClass().getDeclaredFields();
            for (Field f : fields) {
                String fname = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                if (fname.equalsIgnoreCase("SerialVersionUID")) continue;
                else {
                    Method getter = source.getClass().getMethod("get" + fname);
                    System.out.println("set"+fname + "(" + f.getType()+" "+f.getName()+")");
                    Method setter = target.getClass().getMethod("set"+fname,f.getClass());
                    System.out.println(setter.toString());
                    Object value = getter.invoke(source);
                    System.out.println(value);
                }

            }
        }catch (Exception e){

        }
        return null;
    }
}