package injects;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Config {

    private Reflections scanner;
    public Config(){
        this.scanner = new Reflections((Object[]) Injector.class.getAnnotation(Configuration.class).packages());
    }
    public Reflections getScanner() {
        return scanner;
    }

    public <T> Class<? extends T> getImpClass(Class<T> fType){
        Set<Class<? extends T>> classes  = scanner.getSubTypesOf(fType);
            if (classes.size() != 1) {

                throw new RuntimeException(fType + " has 0 or more than one impl");
            }
        return classes.iterator().next();
    }
    public <T> List<T> getImpClasses(Class<T> fType) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<T> classes = new ArrayList<>();
        for(Class <? extends T> aClass : scanner.getSubTypesOf(fType)){
            classes.add(aClass.getDeclaredConstructor().newInstance());
        }
        return  classes;
    }
}


