import java.util.TreeSet;

public class TreeEvenSet extends TreeSet<Integer> {
    @Override
    public boolean add(Integer integer) {
        if (integer.intValue() % 2 == 0)
            return super.add(integer);
        return false;
    }
}
