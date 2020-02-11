package factory;

import android.widget.TextView;

import java.lang.reflect.Field;

import validate.TextLength;
import validate.ValidationCallbackListener;
import validate.ValidationType;

public class TextLengthFactory implements IValidationFactory {

    private ValidationCallbackListener listener;
    public TextLengthFactory(ValidationCallbackListener listener){
        this.listener = listener;
    }

    @Override
    public boolean analyseAnnotation(Field[] fields) {
        for (Field viewField:fields){
            TextLength textLengthAnnotation = viewField.getDeclaredAnnotation(TextLength.class);
            if(textLengthAnnotation!=null){
                try{
                    TextView targetView = (TextView)viewField.get(listener);
                    if(targetView!=null){
                        /*如果min_length值不是-1，代表用户设置了min_length的值*/
                        if(textLengthAnnotation.min_length()!=-1){
                            if(targetView.getText().toString().length()<textLengthAnnotation.min_length()){
                                listener.failed(ValidationType.TextLength,textLengthAnnotation.error_text(),targetView);
                                return false;
                            }
                        }
                        else if(textLengthAnnotation.max_length()!=-1){
                            if(targetView.getText().toString().length()>textLengthAnnotation.max_length()){
                                listener.failed(ValidationType.TextLength,textLengthAnnotation.error_text(),targetView);
                                return false;
                            }
                        }
                    }
                    else{
                        listener.failed(ValidationType.InitialAnalyse,textLengthAnnotation.error_text(),targetView);
                        return false;
                    }
                }
                catch (Exception ex){
                    return false;
                }
            }
        }

        return true;
    }
}
