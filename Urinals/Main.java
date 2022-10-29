import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!"); // Display the string.
//        Urinals urinal = new Urinals();
//        urinal.goodString("test");

        //copy
        Main obj = new Main();
        String inputFile = System.getProperty("user.dir") + File.separator + "urinals.dat";
        try {
            // read file
            List<String> input = null;
            input = obj.readFile(inputFile);
            // calculate available urinals
            String output = obj.calculateAvailableUrinals(input);
            // write file
            obj.writeFile(output);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    List<String> readFile(String fileName) throws IOException {
        List<String> result;
        System.out.println("step 1");
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            System.out.println("step 2");
            result = lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new IOException("IOException read file");
        }
        System.out.println("step 3");
        return result;
    }

    String calculateAvailableUrinals(List<String> inputData) {
        String output = "";
        if (inputData == null) {
            throw new RuntimeException("Empty input file");
        }
        for (String input : inputData) {
//            if (isInputValid(input)) {
                int urinals = 0;
                char[] charArray = input.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    if (charArray[i] == '0' && (i == 0 || charArray[i - 1] == '0') && (i == charArray.length - 1 || charArray[i + 1] == '0')) {
                        charArray[i] = '1';
                        urinals++;
                    }
                }
                output = output + "" + urinals + "" + System.lineSeparator();
            } else {
                output = output + "Invalid" + System.lineSeparator();
            }
        }
        return output;
    }
}
