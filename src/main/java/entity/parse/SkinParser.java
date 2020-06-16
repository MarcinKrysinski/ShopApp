package entity.parse;

import entity.enums.SkinType;

public class SkinParser {

    public static SkinType convertStringToSkin(String string){
        String skinType = string.toUpperCase();

        if (skinType.equals("NATURAL")){
            return SkinType.NATURAL;
        }else if (skinType.equals("ARTIFICIAL")) {
            return SkinType.ARTIFICIAL;
        }
        return null;
    }

}
