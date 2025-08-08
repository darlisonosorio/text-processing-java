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
                                ? " 1 anagrama encontrado para '" + val + "':  [ " + anagrams.getFirst() + " ]"
                                : anagrams.size() + " anagramas encontrados para '" + val + "': " + anagrams;

                        System.out.println(response);
                    } catch (InvalidAnagramException e) {
                        System.out.println("Erro ao obter anagramas para '" + val + "': " + e.getMessage());
                    }
                });

        System.out.println(" \n\n******* End of Program!");
    }
}