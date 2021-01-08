package injects;

import org.reflections.Reflections;

import java.util.Set;

public class Config {
    private Reflections scanner;
    public void Config(String packageToScan){
        this.scanner = new Reflections();
    }
    public <T> Class<? extends T> getImpClass(Class<T> ifc){
        Set<Class<? extends T>> classes  = scanner.getSubTypesOf(ifc);
        if(classes.size() != 1){
            throw new RuntimeException(ifc + "has 0 or more than one impl");
        }
        return classes.iterator().next();
    }
}
