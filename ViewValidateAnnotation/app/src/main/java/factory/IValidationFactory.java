package factory;

import java.lang.reflect.Field;

/**
 * 工厂接口(工厂模式)
 */
public interface IValidationFactory {
    boolean analyseAnnotation(Field[] fields);
}
