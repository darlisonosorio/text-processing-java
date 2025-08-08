import java.util.Arrays;
import java.util.List;

public class TextAnagramMain {
    public static void main(String[] args) {
        Arrays.stream(args)
                .forEach(val -> {
                    try {
                        final List<String> anagrams = AnagramUtil.generateAnagrams(val);
                        if (anagrams.size() == 1) {
                            System.out.print(" 1 anagrama encontrado para '" + val + "': ");
                            System.out.println("[ " + anagrams.getFirst() + " ]");
                        } else {
                            System.out.print(anagrams.size() + " anagramas encontrados para '" + val + "': ");
                            System.out.println("[ " + String.join(", ", anagrams) + " ]");
                        }
                    } catch (InvalidAnagramException e) {
                        System.out.print("Erro ao obter anagramas para '" + val + "': " + e.getMessage());
                    }
                });
    }
}