package pl.wojtekolo.studia.file;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class FileCacher {
    Map<String, WeakReference<ReadFileDTO>> cache = new WeakHashMap<>();

    public ResponseDTO getData(File file, FileProcessingStrategy strategy){
        String path = file.getAbsolutePath();
        WeakReference<ReadFileDTO> reference = cache.get(path);

        ReadFileDTO cachedData=null;
        if (reference != null) {
            cachedData = reference.get();
        }

        if (cachedData == null){
            System.out.println("Brak w cache");
            ReadFileDTO data = strategy.processFile(file);
            cache.put(path, new WeakReference<>(data));
            return new ResponseDTO(data, false);
        } else {
            System.out.println("Znaleziono w cache");
            return new ResponseDTO(cachedData, true);
        }

    }
}
