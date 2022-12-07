import java.util.LinkedHashSet;

public class LinkedEvenSet extends LinkedHashSet<Integer> {
    @Override
    public boolean add(Integer integer) {
        if (integer.intValue() % 2 == 0)
            return super.add(integer);
        return false;
    }
}
