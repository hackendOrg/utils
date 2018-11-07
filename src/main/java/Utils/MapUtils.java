package Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapUtils {
    /**
     *
     * @param fileToStateMap a map from k to v
     * @param key to filter by
     * @param <K> key type
     * @param <V> value type
     * @return list of values from map with the sme key
     */
    public static  <K,V> List<K>getValueWithSameKey(Map<K, V> fileToStateMap,K key) {
        List<K> falseFiles = new ArrayList<>();
        fileToStateMap.forEach((fileName, isValid) -> {
            if (isValid.equals(key)) {
                falseFiles.add(fileName);
            }
        });
        return falseFiles;
    }


}
