import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * User: DikNuken
 * Date: 14.02.13
 * Time: 23:31
 */

public class MapTests extends Assert {
    private Map<Integer, Integer> testMap = new ScapegoatTree<Integer, Integer>(0.1);
    private Map<Integer, Integer> controlMap = new TreeMap<Integer, Integer>();
    Integer[] values;
    Integer[] keys;

    @Before
    public void generateData() {
        Random random = new Random();
        int size = 100;
        values = new Integer[size];
        keys = new Integer[size];
        for (int i = 0; i < size; i++) {
            keys[i] = random.nextInt();
            values[i] = random.nextInt();
        }
    }

    private void checkMap(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        assertEquals("Size", a.size(), b.size());
        for (Integer key : b.keySet()) {
            assertEquals("Value for key " + key.toString(), a.get(key), b.get(key));
        }


    }

    @Test
    public void putTest() {

        for (int i = 0; i < keys.length; i++) {
            testMap.put(keys[i], values[i]);

            controlMap.put(keys[i], values[i]);
            checkMap(testMap, controlMap);
        }
    }

    @Test
    public void delTest() {

        for (int i = 0; i < keys.length; i++) {
            testMap.remove(keys[i]);
            controlMap.remove(keys[i]);
            checkMap(testMap, controlMap);
        }
    }
}
