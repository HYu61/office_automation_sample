package pers.hyu.oa.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    /***
     * convert the string to a int list
     * @param str the string should has the fixed module that only contains number and separated by comma
     * @return the int list
     */
    public static List<Integer> stringToIntArrayList(String str){
        List<Integer> list = new ArrayList<Integer>();
        String[] result = str.split(",");
        for (String s : result) {
            try {
                list.add(Integer.parseInt(s.trim()));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<String> stringToList(String str){
        return Arrays.asList(str.split(","));
    }
}
