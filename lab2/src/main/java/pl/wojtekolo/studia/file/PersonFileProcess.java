package pl.wojtekolo.studia.file;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.*;

public class PersonFileProcess implements FileProcessingStrategy{
    @Override
    public ReadFileDTO processFile(File file) {
        String content = loadFullFile(file);
        Map<String, String> calculatedData = new HashMap<>();
        calculatedData.put("averageAge", averageAge(content));
        calculatedData.put("fileSize", String.valueOf(content.length()));
        return new ReadFileDTO(
                content,
                calculatedData
        );
    }

    private String loadFullFile(File file) {
        try {
            return Files.readString(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException("Błąd odczytu: " + file.getName(), e);
        }
    }

    private String averageAge(String content){
        List<Long> ages = getAges(content);
        Double sum=0.0;
        for (Long age : ages){
            sum+=age;
        }
        return String.valueOf(sum/ages.size());
    }

    private List<Long> getAges(String content){
        String[] lines = content.split("\n");
        List<Long> ages = new ArrayList<>();

        for (String line : lines) {
            LocalDate birthDate = parseDate(line.split(";")[3]);
            LocalDate now = LocalDate.now();

            ages.add(java.time.temporal.ChronoUnit.YEARS.between(birthDate, now));
        }
        return ages;
    }

    private LocalDate parseDate(String date){
        String[] split = date.strip().split("-");

        int year = Integer.parseInt(split[2]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[0]);

        return LocalDate.of(year, month, day);
    }
}
