import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Util {
    public static final List<NumeralSystem> numeralSystemClasses = List.of(new Binary("0"), new Decimal("0"), new Hexdecimal("0"));
    public static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final Map<String, String> binaryMap = new HashMap<>() {{
        put("0", "0000");
        put("1", "0001");
        put("2", "0010");
        put("3", "0011");
        put("4", "0100");
        put("5", "0101");
        put("6", "0110");
        put("7", "0111");
        put("8", "1000");
        put("9", "1001");
        put("A", "1010");
        put("B", "1011");
        put("C", "1100");
        put("D", "1101");
        put("E", "1110");
        put("F", "1111");
    }};
}
