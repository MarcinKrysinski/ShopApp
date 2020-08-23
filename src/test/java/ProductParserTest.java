import entity.enums.Colors;
import entity.enums.Materials;
import entity.parse.ColorParser;
import entity.parse.MaterialParser;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;



public class ProductParserTest {

    @Test
    public void parseColorBlueMixedLettersTest(){
        String stringColor =  "BLuE";

        Colors color = ColorParser.convertStringToColor(stringColor);

        Assertions.assertEquals(Colors.BLUE, color);
    }

    @Test
    public void parseColorRedSmallLettersTest(){
        String stringColor =  "red";

        Colors color = ColorParser.convertStringToColor(stringColor);

        Assertions.assertEquals(Colors.RED, color);
    }

    @Test
    public void parseColorGreenBigLettersTest(){
        String stringColor =  "GREEN";

        Colors color = ColorParser.convertStringToColor(stringColor);

        Assertions.assertEquals(Colors.GREEN, color);
    }

    @Test
    public void returnNullIfNoColorTest(){
        String stringColor =  "";

        Colors color = ColorParser.convertStringToColor(stringColor);

        Assertions.assertNull(color);
    }

    @Test
    public void returnNullIfColorDoesntExistTest(){
        String stringColor =  "PINK";

        Colors color = ColorParser.convertStringToColor(stringColor);

        Assertions.assertNull(color);
    }


    @Test
    public void parseMaterialCottonMixedLettersTest(){
        String stringMaterial =  "CoTtOn";

        Materials material = MaterialParser.convertStringToMaterial(stringMaterial);

        Assertions.assertEquals(Materials.COTTON, material);
    }

    @Test
    public void parseMaterialFurSmallLettersTest(){
        String stringMaterial =  "fur";

        Materials material = MaterialParser.convertStringToMaterial(stringMaterial);

        Assertions.assertEquals(Materials.FUR, material);
    }

    @Test
    public void parseMaterialWoolBigLettersTest(){
        String stringMaterial =  "WOOL";

        Materials material = MaterialParser.convertStringToMaterial(stringMaterial);

        Assertions.assertEquals(Materials.WOOL, material);
    }

    @Test
    public void returnNullIfNoMaterialTest(){
        String stringMaterial =  "";

        Materials material = MaterialParser.convertStringToMaterial(stringMaterial);

        Assertions.assertNull(material);
    }

    @Test
    public void returnNullIfMaterialDoesntExistTest(){
        String stringMaterial =  "TITANIUM";

        Materials material = MaterialParser.convertStringToMaterial(stringMaterial);

        Assertions.assertNull(material);
    }


}
