import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat cat = new Cat();
        if(cat.getClass().isAnnotationPresent(VeryImportant.class)) {
            cat = new Cat("Important cat",10);
            System.out.println(cat);
        }else {
            System.out.println("false");
        }
        for (Method method : cat.getClass().getDeclaredMethods()) {
            if(method.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately anotation = method.getAnnotation(RunImmediately.class);
                for (int i = 0; i < anotation.time() ; i++) {
                    method.invoke(cat);
                }
            }
        }
    }
}
