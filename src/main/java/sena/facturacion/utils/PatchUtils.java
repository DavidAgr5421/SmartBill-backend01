package sena.facturacion.utils;

import java.lang.reflect.Field;

public class PatchUtils {

    public static <T> void copyNonNullProperties(T source, T target) {
        if (source == null || target == null) {
            return;
        }
        for (Field field : source.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(source);
                if (value != null) {
                    field.set(target, value);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error copying properties", e);
            }
        }
    }
}
