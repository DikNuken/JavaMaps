import org.junit.Test;

/**
 * User: DikNuken
 * Date: 14.02.13
 * Time: 23:31
 */

public class MapTests {
    private SimpleMap<String, Integer> map = new SimpleMap<String, Integer>();

    @Test
    public void putTest() {
        map.put("123", 1);
        map.put("1234", 2);
        System.out.print(map.get("123"));
        System.out.print(map.get("1234"));
    }
}
