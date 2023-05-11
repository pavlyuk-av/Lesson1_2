import ru.x5.school.oop.advanced.homework.ListIterator;

public class Main {
    public static void main(String[] args){
        FirstList<String> list = new FirstList<String>();
        list.add("1");
        list.add("2");
        list.add("3");


        for (ListIterator<String> iterator = list.iterator(); iterator.hasNext();) {
            String item = iterator.next();
            System.out.println(item);
        }

        for (ListIterator<String> iterator = new OnlyIterator<String>(list); iterator.hasNext();) {
            String item = iterator.next();
            System.out.println(item);
        }

        //ListIterator<String> iterator = list.iterator();
        //OnlyIterator<String> iterator2 = new OnlyIterator<String>(list);

        //System.out.println(iterator.hasNext());
        //System.out.println(iterator2.hasNext());
    }
}
