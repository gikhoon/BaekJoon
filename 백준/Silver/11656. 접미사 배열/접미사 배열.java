import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> suffixes = new ArrayList<>();
        String word = br.readLine();
        for (int i = 0; i < word.length(); i++) {
            suffixes.add(word.substring(i));
        }

        suffixes.stream().sorted()
                .forEach(System.out::println);
    }
}
