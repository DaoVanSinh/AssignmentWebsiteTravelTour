package com.tourvn.Utils;
import java.text.Normalizer;
public class utils {
    public static String removeAccent(String input){
        if(input==null){
            return "";
        }
        String temp = Normalizer.normalize(input, Normalizer.Form.NFD);
        return temp.replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
        .replace("đ","d")
        .replace("Đ","D");

    }
}
