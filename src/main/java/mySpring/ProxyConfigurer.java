package mySpring;

/**
 * Created by Jeka on 02/10/2015.
 */
public interface ProxyConfigurer {
    Object wrapWithProxy(Object object, Class originalClass);
}
