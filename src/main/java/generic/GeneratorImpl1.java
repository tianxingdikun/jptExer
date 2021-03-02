package generic;

/**
 * 实现泛型接口，不指定类型
 * @param <T>
 */
public class GeneratorImpl1<T> implements Generator<T>{

    @Override
    public T method() {
        return null;
    }
}

