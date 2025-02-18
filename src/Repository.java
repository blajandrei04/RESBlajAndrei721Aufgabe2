import java.util.ArrayList;
import java.util.List;

public class Repository <T> {
    private final List<T> repository;

    public Repository(List<T> repository) {
        this.repository = repository;
    }
    public Repository() {
        this.repository = new ArrayList<T>();
    }

    public void addElement(T t) {
        repository.add(t);
    }

    public List<T> getAllElements() {
        return repository;
    }

    public T getElement(int index) {
        return repository.get(index);
    }

    public void updateElement(int index,T t) {
        repository.set(index, t);
    }

    public void remove(T t) {
        repository.remove(t);
    }

}
