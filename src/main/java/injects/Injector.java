package injects;

import org.reflections.Reflections;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Set;

@Configuration(packages = {"verification", "util"})
public class Injector {
    private Config config = new Config();
    private Reflections scanner;
    public void inject(Class object) throws MyException {
        for (Field f : object.getDeclaredFields()) {
            if (f.isAnnotationPresent(AutoInjectable.class)) {
                if (f.getType().isInterface()) {
                    if (!Collection.class.isAssignableFrom(f.getType())) {
                        f.setAccessible(true);
                        try {
                            f.set(object, config.getImpClass(f.getType()));
                        } catch (IllegalAccessException e) {
                            throw new MyException(e);
                        }
                    }
                    else {
                        f.setAccessible(true);
                        Type sType = f.getGenericType();
                        ParameterizedType aType = (ParameterizedType) sType;
                        Type[] fieldArg = aType.getActualTypeArguments();
                        sType = fieldArg[0];
                        Class<?> clazz = (Class<?>) sType;
                        System.out.println(clazz);
                        try {
                            f.set(object, config.getImpClasses(clazz));
                        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
                            throw new MyException(e);
                        }
                    }
                }
                else
                    throw new RuntimeException("type not interface");
            }
        }
    }
}
