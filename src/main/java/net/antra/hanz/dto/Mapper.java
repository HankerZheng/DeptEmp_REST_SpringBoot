package net.antra.hanz.dto;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by hanzheng on 8/8/17.
 */
@Component
public class Mapper {


    public Object map(Object d){
        Object res = null;
        try {
            res = _map(d);
        } catch (Exception e ){
            e.printStackTrace();
        }
        return res;
    }

    public Object _map(Object d) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException{

        Class<?> clazz = d.getClass();
        Class<?> retClazz = Class.forName("net.antra.hanz.dto." + clazz.getSimpleName() + "DTO");
        Object dtoObj = retClazz.newInstance();

        Method[] methods = clazz.getDeclaredMethods();
        for(Method getter: methods) {
            // Only deal with the getter of the object
            if (getter.getName().startsWith("get")){
                Object res = getter.invoke(d);
                Class objClazz = res.getClass();
                if (res instanceof Collection) {
                    List<String> components = new ArrayList<>();
                    for (Object component: (Collection) res) {
                        components.add(component.toString());
                    }
                    retClazz.getMethod("set" + getter.getName().substring(3), List.class).invoke(dtoObj, components);
                } else if (objClazz.getName().startsWith("java")){
                    retClazz.getMethod("set" + getter.getName().substring(3), res.getClass()).invoke(dtoObj, res);
                } else {
                    retClazz.getMethod("set" + getter.getName().substring(3), String.class).invoke(dtoObj, res.toString());
                }
            }
        }
        return dtoObj;
    }
}
