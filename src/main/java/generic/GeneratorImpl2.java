package generic;

/**
 * 实现泛型接口，指定类型
 * @param <T>
 */
public class GeneratorImpl2<T> implements Generator<String>{
    @Override
    public String method() {
        return "hello";
    }
}

