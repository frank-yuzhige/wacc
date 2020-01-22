import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class LexerTests {

  private static Runtime rt = Runtime.getRuntime();

  @Test
  public void lexIf1Valid() throws Exception {
  }

  private static boolean lexAndCompare(String path, String target) throws Exception {

    List<String> expectedOutput = Files.readAllLines(Paths.get(target));
    String[] command = new String[]{"./grun", "antlr.Basic", "prog", "-tree", path};
    Process lexer = rt.exec(command);
    BufferedReader lexerReader =
      new BufferedReader(new InputStreamReader(lexer.getInputStream()));
    String output;
    while ((output = lexerReader.readLine()) != null) {
      System.out.println(output);
    }

    lexer.waitFor();
    assert(lexer.exitValue() == 0);
    lexerReader.close();
    return false;
  }

  public static void main(String[] args) {
    try {
      LexerTests.lexAndCompare("../wacc_examples/valid/if/if1.wacc", "");
    } catch (Exception e) {
      System.out.println(Arrays.toString(e.getStackTrace()));
    }
  }

}
