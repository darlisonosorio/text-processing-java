import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Arrays.stream(args)
                .forEach(val -> {
                    final List<String> anagrams = AnagramsUtil.generateAnagrams(val);
                    System.out.println(anagrams.size() + " anagramas encontrados para " + val + " :");
                    System.out.println("[ " + String.join(", ", anagrams) + " ]");
                });

    }
}