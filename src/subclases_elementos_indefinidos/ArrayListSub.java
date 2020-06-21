package subclases_elementos_indefinidos;

import java.util.ArrayList;

public class ArrayListSub extends ArrayList {
    private ArrayList<Object> elementosString;
    public void agregarStringInd(Object... strings){
        for (int i = 0; i < strings.length; i++) {
            elementosString.add(strings[i]);
        }
    }
}
