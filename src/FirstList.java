import java.util.NoSuchElementException;
import java.util.Arrays;

public class FirstList<T> implements ru.x5.school.oop.advanced.homework.List<T> {

    private Object[] elements;
    private  int size = 0;
    private int length = 0;

    public FirstList() {
        elements = new Object[2];
        length = 2;
    }

    private void doubleLength(){
        length *= 2;
        Object[] temp = new Object[length];
        for (int i=0; i< size ;i++){
            temp[i] = elements[i];
            elements[i]=null;
        }
        elements = temp;
    }

    private void delete (int index){
        int moved = this.size - index - 1;
        if (moved > 0) {
            System.arraycopy(this.elements, index+1, this.elements, index, moved);
        }
        this.elements[--size] = null;
    }
    @Override
    public void add(T object) {
        if (size >= length){
            doubleLength();
        }
        elements[size++] = object;
    }
    @Override
    public void insert(int pos, T object) throws IllegalArgumentException{
        if (pos < 0 || pos > size) {
            throw new IllegalArgumentException();
        }
        if (size >= length){
            doubleLength();
        }
        if (pos == size) {
            size++;
        }

        var temp = Arrays.copyOf(elements, length);

        for (int i=0; i< length; i++)
        {
            temp[i] = i < pos ? elements[i] :
                    i == pos ? object :
                            elements[i-1];
        }
        elements = temp.clone();
    }
    @Override
    public int size() {
        return size;
    }

    public void remove (T object) {
        if (object == null) {
            for (int i=0; i< this.size; i++)
            {
                if (this.elements[i] == null) {
                    delete(i);
                    return;
                }
            }
        }
        else {
            for (int i=0; i< this.size; i++)
            {
                if (object.equals(this.elements[i])) {
                    delete(i);
                return;
                }
            }
        }
    }
    @Override
    public T get(int i) {
        if (i>=size || i <0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[i];
    }
    public Iterator iterator() { return new Iterator(); }
    private class Iterator<T> implements ru.x5.school.oop.advanced.homework.ListIterator<T> {
        private int currentPosition;
        public Iterator() {currentPosition=0;};

        @Override
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
        @Override
        public T next() {
            if (currentPosition >= size)
                throw new NoSuchElementException();
            return (T) elements[currentPosition++];
        }
    }

}
