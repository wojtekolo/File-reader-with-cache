package pl.wojtekolo.studia.file;

import java.util.Map;

public record ReadFileDTO(
        String fullConent,
        Map<String, String> calculatedData
) {
}
