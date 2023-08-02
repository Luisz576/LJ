package com.luisz.lj.utils.acessor;

import com.sun.istack.internal.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Acessor {
    private final Class<?> clazz;

    public final Class<?> getClazz() {
        return this.clazz;
    }

    public Acessor(@NotNull Object object) {
        this.clazz = object.getClass();
    }

    public Acessor(@NotNull Class<?> clazz) {
        this.clazz = clazz;
    }

    public Field getDeclaredField(String declaredField) throws NoSuchFieldException {
        return this.clazz.getDeclaredField(declaredField);
    }

    public Field[] getDeclaredFields() {
        return this.clazz.getDeclaredFields();
    }

    public Field[] getFields() {
        return this.clazz.getFields();
    }

    public Method[] getDeclaredMethods() {
        return this.clazz.getDeclaredMethods();
    }

    public Method[] getMethods() {
        return this.clazz.getMethods();
    }

    public Annotation[] getAnnotations() {
        return this.clazz.getAnnotations();
    }

    public Annotation[] getDeclaredAnnotations() {
        return this.clazz.getDeclaredAnnotations();
    }

    public Constructor<?>[] getConstructors() {
        return this.clazz.getConstructors();
    }

    public Constructor<?>[] getDeclaredConstructors() {
        return this.clazz.getDeclaredConstructors();
    }

    public Class<?>[] getClasses() {
        return this.clazz.getClasses();
    }

    public Class<?>[] getDeclaredClasses() {
        return this.clazz.getDeclaredClasses();
    }

    public <T extends Annotation> List<Field> getDeclaredFiledsWithAnnotation(Class<T> annotation) {
        List<Field> fields = new ArrayList<>();
        for (Field field : getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getAnnotation(annotation) != null)
                fields.add(field);
        }
        return fields;
    }

    public <T extends Annotation> Field getFirstDeclaredFiledWithAnnotation(Class<T> annotation) {
        for (Field field : getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getAnnotation(annotation) != null)
                return field;
        }
        return null;
    }

    public <T extends Annotation> List<Method> getDeclaredMethodsWithAnnotation(Class<T> annotation) {
        List<Method> methods = new ArrayList<>();
        for (Method method : getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getAnnotation(annotation) != null)
                methods.add(method);
        }
        return methods;
    }

    public <T extends Annotation> Method getDeclaredMethodWithAnnotation(Class<T> annotation) {
        for (Method method : getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getAnnotation(annotation) != null)
                return method;
        }
        return null;
    }

    public static void set(Field field, Object obj, Object value) {
        try {
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setByte(Field field, Object obj, byte value) {
        try {
            field.setByte(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setBoolean(Field field, Object obj, boolean value) {
        try {
            field.setBoolean(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setChar(Field field, Object obj, char value) {
        try {
            field.setChar(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setDouble(Field field, Object obj, double value) {
        try {
            field.setDouble(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFloat(Field field, Object obj, float value) {
        try {
            field.setFloat(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setInt(Field field, Object obj, int value) {
        try {
            field.setInt(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setLong(Field field, Object obj, long value) {
        try {
            field.setLong(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}