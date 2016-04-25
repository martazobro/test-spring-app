package screenSaver;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public @interface TimeScope {
    @AliasFor("scopeName")
    String value() default "timeScope";

    @AliasFor("value")
    String scopeName() default "timeScope";



    int seconds();
}
