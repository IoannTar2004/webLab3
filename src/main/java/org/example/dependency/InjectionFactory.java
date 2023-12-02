package org.example.dependency;

import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.lang.reflect.Field;

public class InjectionFactory {
    public static void inject(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field: fields) {
            Class<?> fieldType = field.getType();
            if(!fieldType.isAnnotationPresent(Named.class))
                continue;
            String beanName = fieldType.getAnnotation(Named.class).value();
            if (beanName.equals("")) {
                String className = fieldType.getSimpleName();
                beanName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
            }

            FacesContext context = FacesContext.getCurrentInstance();
            try {
                field.setAccessible(true);
                Object o = context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", fieldType);

                field.set(object, o);

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
