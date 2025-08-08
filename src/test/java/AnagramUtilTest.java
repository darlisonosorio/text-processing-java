import br.com.darlison.AnagramUtil;
import br.com.darlison.InvalidAnagramException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AnagramUtilTest {

    @Test
    void testGenerateAnagrams_normalWord() throws InvalidAnagramException {
        List<String> anagrams = AnagramUtil.generateAnagrams("abc");
        Assertions.assertEquals(6, anagrams.size());
        Assertions.assertEquals("[abc, acb, bac, bca, cba, cab]", anagrams.toString());
    }

    @Test
    void testGenerateAnagrams_1itemOnly() throws InvalidAnagramException {

        List<String> anagrams = AnagramUtil.generateAnagrams("a");
        Assertions.assertEquals(1, anagrams.size());
        Assertions.assertEquals("[a]", anagrams.toString());

    }

    @Test
    void testGenerateAnagrams_invalidInput() {

        final InvalidAnagramException ex1 = Assertions.assertThrows(
                InvalidAnagramException.class,
                () -> AnagramUtil.generateAnagrams("")
        );
        Assertions.assertEquals("Text cannot be null or empty", ex1.getMessage());

        final InvalidAnagramException ex2 = Assertions.assertThrows(
                InvalidAnagramException.class,
                () -> AnagramUtil.generateAnagrams(null)
        );
        Assertions.assertEquals("Text cannot be null or empty", ex2.getMessage());

        final InvalidAnagramException ex3 = Assertions.assertThrows(
            InvalidAnagramException.class,
            () -> AnagramUtil.generateAnagrams("abc123")
        );
        Assertions.assertEquals("Text must contain only letters", ex3.getMessage());
    }

}
