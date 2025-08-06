package com.hussi.service.batchLifeCycle;

import java.io.File;
import java.util.List;


public interface ChunkProcessor {
    List<String> process(List<File> chunks);
}
