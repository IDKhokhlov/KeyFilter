import strategy.RegexSplit;

import java.util.ArrayList;
import java.util.List;

public class KeyFilter {

    public static List<String> filterTasks(String string, String[] array, RegexSplit strategy) {
        List<String> result = new ArrayList<>();

        if (string == null || array == null) {
            return result;
        }

        List<String> ids = strategy.split(string);

        if (!ids.isEmpty()) {
            for (String element : array) {
                List<String> givenIds = strategy.split(element);
                if (givenIds.containsAll(ids)) {
                    result.add(element);
                }
            }
        }

        return result;
    }
}
