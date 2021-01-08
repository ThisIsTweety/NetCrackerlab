package injects;

import org.reflections.Reflections;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.Set;

//@Configuration()
public class Injector {
    private Reflections scanner;
    public static void inject(Class object){
        for (Field f : object.getDeclaredFields()){
            if(f.isAnnotationPresent(AutoInjectable.class)){

            }
        }
    }
    public void config(String packageToScan){
        this.scanner = new Reflections(packageToScan);
    }
    public <T> Class<? extends T> getImpClass(Class<T> ifc){
        Set<Class<? extends T>> classes  = scanner.getSubTypesOf(ifc);
        if(classes.size() != 1){
            throw new RuntimeException(ifc + "has 0 or more than one impl");
        }
        return classes.iterator().next();
    }
}
