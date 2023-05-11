import ru.x5.school.oop.advanced.homework.List;
import java.util.*;

public class OnlyIterator<T> implements ru.x5.school.oop.advanced.homework.ListIterator<T> {

    private List<T> elements;
    private int currentPosition;
    public OnlyIterator(List<T> list){
        elements = list;
        currentPosition = 0;
    }

    public boolean hasNext() {
        try {
            T obj = next();
            currentPosition--;
            return obj != null;
        }
        catch (NoSuchElementException ex)
        {
            return false;
        }
    }
    public T next() {
        if (currentPosition >= elements.size())
            throw new NoSuchElementException();
        return (T) elements.get(currentPosition++);
    }
}
