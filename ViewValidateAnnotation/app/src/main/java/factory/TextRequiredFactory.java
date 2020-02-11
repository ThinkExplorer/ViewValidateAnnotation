package factory;

import android.text.TextUtils;
import android.util.Pair;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.SortedMap;
import java.util.TreeMap;
import validate.TextRequired;
import validate.TextRequired;
import validate.ValidationCallbackListener;
import validate.ValidationType;

public class TextRequiredFactory implements IValidationFactory {

    private ValidationCallbackListener listener;
    public TextRequiredFactory(ValidationCallbackListener listener){
        this.listener = listener;
    }

    @Override
    public boolean analyseAnnotation(Field[] viewFields) {
        SortedMap<Integer,Pair<TextRequired,TextView>> viewMap = new TreeMap<>();
        for(Field viewField:viewFields){
            TextRequired notEmptyAnnotation = viewField.getDeclaredAnnotation(TextRequired.class);
            if(notEmptyAnnotation!=null){
                try{
                    /*简单起见，这里不对viewField.get()返回的值类型进行判断，默认其为TextView或其子类实例*/
                    viewField.setAccessible(true);
                    viewMap.put(notEmptyAnnotation.sequence(),new Pair<TextRequired, TextView>(notEmptyAnnotation,(TextView)viewField.get(listener)));
                }
                catch (Exception ex){
                    return false;
                }

            }
        }

        for(Integer ordinal:viewMap.keySet()){
            Pair<TextRequired,TextView> targetPair = viewMap.get(ordinal);
            if(targetPair!=null && targetPair.second!=null){
                if(TextUtils.isEmpty(targetPair.second.getText().toString())){
                    listener.failed(ValidationType.NotEmpty,targetPair.first.error_text(),targetPair.second);
                    return false;
                }
            }
            else{
                listener.failed(ValidationType.InitialAnalyse,"target view is null!",targetPair.second);
                return false;
            }
        }

        return true;

    }
}
