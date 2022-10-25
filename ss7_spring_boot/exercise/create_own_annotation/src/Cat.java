@VeryImportant
public class Cat {
    private String name;
    private int age;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @RunImmediately(time = 3)
    public void meow() {
        System.out.println("meo meo meo");
    }
    public void eat() {
        System.out.println("wow wow wow");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
