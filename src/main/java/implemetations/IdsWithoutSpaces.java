package implemetations;

import strategy.RegexSplit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IdsWithoutSpaces implements RegexSplit {
    public List<String> split(String string) {
        return Arrays.stream(string.replaceAll(" ", "").split(",+"))
                .filter(el -> !el.isEmpty())
                .collect(Collectors.toList());
    }
}
