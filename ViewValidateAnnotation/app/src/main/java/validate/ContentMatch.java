package validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ContentMatch {
    int compare_target_id() default -1;    /*将使用此注解的控件的值与目标compare_target_id对应的id的控件值进行比较,一个典型的例子就是表单验证中密码与确认密码要一致*/
    String text_regex() default "null"; /*对指定的控件值进行正则表达式匹配,这里之所以默认值不设置为空字符串(例如default "")是因为会导致报错，暂未找到报错原因和解决办法*/
    String compare_error_text() default "";
    String match_error_text() default "";
}
