import entity.enums.Colors;
import entity.parse.ColorParser;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;



public class ProductParserTest {

    @Test
    public void parseColorBlueTest(){
        String stringColor =  "BLuE";

        Colors color = ColorParser.convertStringToColor(stringColor);

        Assertions.assertEquals(Colors.BLUE, color);
    }
}
