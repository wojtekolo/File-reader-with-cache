package pl.wojtekolo.studia.file;

public record ResponseDTO(
        ReadFileDTO data,
        boolean wasCached
) {
}
