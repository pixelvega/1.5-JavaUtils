package level1.exercise1;
import java.io.Serial;
import java.io.Serializable;

public class SampleObject implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String name;
    private final int age;

    public SampleObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "SampleObject{name='" + name + "', age=" + age + "}";
    }
}
