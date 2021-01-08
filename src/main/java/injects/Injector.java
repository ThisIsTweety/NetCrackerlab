package injects;

import org.reflections.Reflections;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.Set;

@Configuration(packages = {"verification"})
public class Injector {
    private Reflections scanner;
    public static void inject(Class object){
        for (Field f : object.getDeclaredFields()){
            if(f.isAnnotationPresent(AutoInjectable.class)){

            }
        }
    }


}
