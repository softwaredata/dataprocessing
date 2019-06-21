package net.skhu.util.auth;

import java.lang.annotation.*;

/**
 * Created by bomi on 2019-06-20.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Auth {
}
