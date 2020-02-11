package factory;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;

import java.lang.reflect.Field;

import validate.ContentMatch;
import validate.ValidationCallbackListener;
import validate.ValidationType;

public class ContentMatchFactory implements IValidationFactory {

    private ValidationCallbackListener listener;
    public ContentMatchFactory(ValidationCallbackListener listener){
        this.listener = listener;
    }

    @Override
    public boolean analyseAnnotation(Field[] fields) {
        for(Field viewField:fields){
            ContentMatch contentMatchAnnotation = viewField.getDeclaredAnnotation(ContentMatch.class);
            if(contentMatchAnnotation!=null){
                int id = contentMatchAnnotation.compare_target_id();
                TextView view = null;
                try{
                    view = (TextView)viewField.get(listener);    //获取当前使用ContentMatch注解的控件对象；
                }
                catch (Exception ex){
                    listener.failed(ValidationType.InitialAnalyse,ex.getMessage(),null);
                }

                if(id!=-1){
                    if(listener instanceof Activity){
                        Activity activityInstance = (Activity)listener;
                        TextView targetView = activityInstance.findViewById(id);  //获取要比较内容的目标控件实例

                        /*判断当前控件值与目标控件值是否一致*/
                        if(view.getText().toString().equals(targetView.getText().toString())==false){
                            listener.failed(ValidationType.ContentMatch,contentMatchAnnotation.compare_error_text(),view);
                            return false;
                        }

                    }
                    else{
                        throw new IllegalArgumentException("The ValidationCallbackListener interface instance to be processed does not inherit Activity!");
                    }
                }
                else if(contentMatchAnnotation.text_regex().equals("null") == false){
                    String content = view.getText().toString();
                    /*校验控件内容是否与指定的正则表达式匹配*/
                    if(!content.matches(contentMatchAnnotation.text_regex())){
                        listener.failed(ValidationType.ContentMatch,contentMatchAnnotation.match_error_text(),view);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
