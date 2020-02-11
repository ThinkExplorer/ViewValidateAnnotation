package validate;

import android.view.View;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;

public interface ValidationCallbackListener {
    void success();
    void failed(ValidationType type,String text,View target);
}
