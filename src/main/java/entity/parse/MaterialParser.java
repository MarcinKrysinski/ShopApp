package entity.parse;

import entity.enums.Materials;

public class MaterialParser {

    public static Materials convertStringToMaterial(String string){
        String material = string.toUpperCase();

        if (material.equals("LEATHER")){
            return Materials.LEATHER;
        }else if (material.equals("FUR")){
            return Materials.FUR;
        }else if (material.equals("COTTON")){
            return Materials.COTTON;
        }else if (material.equals("WOOL")){
            return Materials.WOOL;
        }else if (material.equals("POLYESTERS")){
            return Materials.POLYESTERS;
        }
        return null;
    }
}
