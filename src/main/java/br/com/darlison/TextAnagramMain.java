package br.com.darlison;

import java.util.Arrays;
import java.util.List;

public class TextAnagramMain {
    public static void main(final String[] args) {
        System.out.println("******* Text Anagram Program! \n\n");

        Arrays.stream(args)
                .forEach(val -> {
                    try {
                        final List<String> anagrams = AnagramUtil.generateAnagrams(val);


                        final String response = anagrams.size() == 1
                                ? " 1 anagram found for '" + val + "':  [ " + anagrams.getFirst() + " ]"
                                : anagrams.size() + " anagrams found for '" + val + "': " + anagrams;

                        System.out.println(response);
                    } catch (InvalidAnagramException e) {
                        System.out.println("Error while obtaining anagrams for '" + val + "': " + e.getMessage());
                    }
                });

        System.out.println(" \n\n******* End of Program!");
    }
}