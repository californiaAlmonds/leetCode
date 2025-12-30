import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidTransitionMatrix {
    public static boolean pyramidTransition(String bottom, List<String> allowed){
        Map<String,List<Character>> allowedMap = new HashMap<>();
        for(String allowedString : allowed){
            String combo = allowedString.substring(0, 2);
            allowedMap.putIfAbsent(combo, new ArrayList<>());
            allowedMap.get(combo).add(allowedString.charAt(2));
        }
        return buildPyramid(bottom, "", allowedMap);
    }

    public static boolean buildPyramid(String currentRow, String nextRow, Map<String,List<Character>> allowedMap){
        if(currentRow.length()==1) return true;
        if(nextRow.length() == currentRow.length()-1) {
            return buildPyramid(nextRow, "", allowedMap);
        }
        int pos = nextRow.length();
        String pair = currentRow.substring(pos, pos+2);
        List<Character> allowedList = allowedMap.getOrDefault(pair, new ArrayList<>());
        if(allowedList.isEmpty()) return false;
        for(char possibleBlock : allowedList){
            if(buildPyramid(currentRow, nextRow + possibleBlock, allowedMap)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String bottom = "BCD";
        List<String> allowed = List.of("BCC","CDE","CEA","FFF");
        System.out.println(pyramidTransition(bottom, allowed));
        // pyramidTransition(bottom, allowed);
    }
}
