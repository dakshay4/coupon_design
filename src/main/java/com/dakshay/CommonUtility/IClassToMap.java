package com.dakshay.CommonUtility;

import java.util.Map;

/**
 * Created by Dakshay on 11/21/2018.
 */
public interface IClassToMap<T> {
    Map<String,String> getClassToMap(T t);
}
