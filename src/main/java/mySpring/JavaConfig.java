package mySpring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeka on 02/10/2015.
 */
public class JavaConfig implements Config {

    private Map<Class, Class> ifc2Impl = new HashMap<>();

    public JavaConfig() {
        ifc2Impl.put(Speaker.class, ConsoleSpeaker.class);

    }

    public Class getImpl(Class ifc) {
        return ifc2Impl.get(ifc);
    }
}
