package br.com.darlison;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class AnagramUtil {

    /**
     * Generates a list of Anagrams for a given text
     * @param text
     * @return a list of anagrams
     * @throws InvalidAnagramException in case of any invalid text
     */
    public static List<String> generateAnagrams(final String text) throws InvalidAnagramException {
        validateText(text);

        final List<String> result = new LinkedList<>();
        final char[] characters = text.trim().toCharArray();

        generate(characters, 0, result);

        return result;
    }

    /**
     * Inserts an anagram into the result list
     * if is in last index, inserts into the result list
     * if not, iterates from the current index, for each index:
     *   - swaps characters,
     *   - runs generate again passing index + 1, for new permutations,
     *   - swaps characters again to return to previous state
     *
     * @param characters The source text
     * @param index      the position of the starting character
     * @param result     the list of unique anagrams
     */
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

    /**
     * Exchange the positions of two characters in the text
     *
     * @param characters the text
     * @param index1     the first position
     * @param index2     the second position
     */
    private static void swap(final char[] characters, final int index1, final int index2) {
        char temp = characters[index1];
        characters[index1] = characters[index2];
        characters[index2] = temp;
    }

    /**
     * Validation before processing
     *
     * @param text
     * @throws InvalidAnagramException exception to be thrown if the text is invalid
     */
    private static void validateText(final String text) throws InvalidAnagramException {
        if (text == null || text.trim().isEmpty()) {
            throw new InvalidAnagramException("Text cannot be null or empty");
        }
        if (!text.trim().matches("[a-zA-Z]+")) {
            throw new InvalidAnagramException("Text must contain only letters");
        }
    }

}
