package com.dakshay.CommonUtility;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dakshay on 11/21/2018.
 */
public class ClassToMap<T> implements IClassToMap<T>{

    @Override
    public Map<String, String> getClassToMap(T t) {
        Map map = new HashMap<String,String>();
        try {
            Field[] fields = t.getClass().getDeclaredFields();
            for (Field f : fields) {
                String fName = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                Method getter = t.getClass().getMethod("get" + fName);
                Object value = getter.invoke(t);
                map.put(fName,String.valueOf(value));
            }
        }catch (Exception e){

        }
        return map;
    }
}
