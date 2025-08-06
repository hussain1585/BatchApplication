package com.hussi.service.batchLifeCycle;

import java.util.List;


public interface OutputWriter {
    void write(List<String> formatted, String uuid);
}