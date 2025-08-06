package com.hussi.service.batchLifeCycle;

import java.io.File;
import java.util.List;


public interface InputSplitter {
    List<File> split(String inputPath);
}
