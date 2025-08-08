import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AnagramsUtil {

    public static List<String> generateAnagrams(final String text) {
        final List<String> result = new ArrayList<>();
        final char[] characters = text.toCharArray();

        generate(characters, 0, result);

        return result;
    }

    private static void generate(final char[] characters, final int index, final List<String> result) {
        if (index == characters.length) {
            result.add(new String(characters));
            return;
        }

        IntStream.range(index, characters.length).forEach(i -> {
            swap(characters, index, i);
            generate(characters, index + 1, result);
            swap(characters, index, i);
        });
    }

    private static void swap(final char[] characters, final int index1, final int index2) {
        char temp = characters[index1];
        characters[index1] = characters[index2];
        characters[index2] = temp;
    }

}
