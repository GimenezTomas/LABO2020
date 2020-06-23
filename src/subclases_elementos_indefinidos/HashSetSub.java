package subclases_elementos_indefinidos;

import java.util.Collection;
import java.util.HashSet;

public class HashSetSub extends HashSet{
    private HashSet<Object> elementos;
    public void agregarStringInd(Object... integers){
        for (Object integer: integers) {
            elementos.add(integer);
        }
    }
}
