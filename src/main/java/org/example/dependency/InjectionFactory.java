package org.example.dependency;

import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.lang.reflect.Field;

public class InjectionFactory {
    public static void inject(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field: fields) {
            Class<?> fieldType = field.getType();
            if(!fieldType.isAnnotationPresent(Named.class))     //если поле - не bean, то просто пропускаю это поле
                continue;
            String beanName = fieldType.getAnnotation(Named.class).value();
            if (beanName.equals("")) {      //если я не указывал значение Named, то меняю первую букву класса на ту же букву в нижнем регистре
                String className = fieldType.getSimpleName();
                beanName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
            }

            FacesContext context = FacesContext.getCurrentInstance();
            try {
                field.setAccessible(true);
                Object o = context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", fieldType);
                //из контекста faces получаю созданный jsf'ом объект бина и устанавливаю его в поле переданного в метод объекта, таким образом инициализирую поле
                field.set(object, o);

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
