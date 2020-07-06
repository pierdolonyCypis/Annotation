import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Person person = new Person();
        Class getClass = person.getClass();
        printInfo(person,getClass);

    }
   static void printInfo(Object o, Class c) throws IllegalAccessException {
        Field[] fields = c.getDeclaredFields();
        for(Field field: fields){
            Annotation[] annotations = field.getDeclaredAnnotations();
            for(Annotation annotation: annotations){
                if(annotation.annotationType().equals(MyAnnotation.class)){
                    System.out.println(field.get(o));
                }
            }
        }
    }
}
