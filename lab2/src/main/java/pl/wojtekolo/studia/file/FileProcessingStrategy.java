package pl.wojtekolo.studia.file;

import java.io.File;

public interface FileProcessingStrategy {
    ReadFileDTO processFile(File file);
}
