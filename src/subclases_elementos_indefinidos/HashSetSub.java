package subclases_elementos_indefinidos;

import java.util.HashSet;
import java.util.Objects;

public class HashSetSub extends HashSet{
    private HashSet<Object> elementos;
    public void agregarStringInd(Object... integers){
        for (Object integer: integers) {
            elementos.add(integer);
        }
    }
}
