import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PeekingIterator iterator = null;
        String[] stt = {"PeekingIterator", "next", "peek", "next", "next", "hasNext"};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> arr = list.listIterator();
        int count = 0;


        for (String s : stt) {
            switch (s) {
                case "PeekingIterator":
                    iterator = new PeekingIterator(arr);
                    System.out.println("null");
                    break;
                case "next":
                    assert iterator != null;
                    System.out.println(iterator.next());
                    break;
                case "peek":
                    assert iterator != null;
                    System.out.println(iterator.peek());
                    break;
                case "hasNext":
                    assert iterator != null;
                    System.out.println(iterator.hasNext());
                    break;
                default:
                    break;
            }
        }

    }
}

class PeekingIterator implements Iterator<Integer> {
    List<Integer> list = new ArrayList<>();
    boolean check = true;
    int count = 0;

    public PeekingIterator(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(0);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int temp = list.get(0);
        list.remove(0);
        list.add(temp);
        count++;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return count != list.size() && list.size() != 0 && check;
    }
}
