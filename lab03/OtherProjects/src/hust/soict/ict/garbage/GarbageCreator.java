package hust.soict.ict.garbage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filePath = Paths.get(".", "garbage.txt").toAbsolutePath().toString();
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        String str = "";
        for (int i = 0; i < 1000; i++) {
            str += (char) ('a' + random.nextInt(26));
            stringBuilder.append(str);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(stringBuilder.toString());
            System.out.println("File generated successfully at: " + filePath);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

        //Read String without StringBuffer

        String filename = Paths.get(".", "garbage.txt").toAbsolutePath().toString();
        byte[] inputBytes = {0};
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuilder outputString = new StringBuilder();
        for (byte b : inputBytes) {
            outputString.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
