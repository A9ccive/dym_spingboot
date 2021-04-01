package com.ruoyi.common.utils.check;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Documented
public @interface IsItNecessary {
    boolean key() default false;
}

