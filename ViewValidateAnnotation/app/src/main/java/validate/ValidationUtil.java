package validate;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import factory.ContentMatchFactory;
import factory.IValidationFactory;
import factory.TextRequiredFactory;
import factory.TextLengthFactory;

public class ValidationUtil {
    private final String tag = "ValidationUtil";
    private ValidationCallbackListener listener;
    private Class<?>[] factoryArray = {TextRequiredFactory.class, TextLengthFactory.class, ContentMatchFactory.class};

    public ValidationUtil(ValidationCallbackListener listener){
        this.listener = listener;
    }

    public void setListener(ValidationCallbackListener listener){
        this.listener = listener;
    }

    public void doValidate(){
        if(listener == null){
            throw new NullPointerException("ValidationCallbackListener can't be null.");
        }

        Class<?> objClass = listener.getClass();
        Field[] viewFields = objClass.getDeclaredFields();

        /*依次进行各种种类的校验*/
        for(Class<?> classItem:factoryArray){
            try{
                Constructor<?> cons = classItem.getConstructor(ValidationCallbackListener.class);
                IValidationFactory factory = (IValidationFactory)cons.newInstance(listener);
                boolean isValid = factory.analyseAnnotation(viewFields);
                /*只要有一种类型的校验失败，则不再继续往下执行校验*/
                if(isValid == false)
                    return;
            }
            catch (Exception ex){
                listener.failed(ValidationType.InitialAnalyse,"初始化解析错误",null);
                return;
            }

        }

        listener.success(); //验证成功
    }
}
