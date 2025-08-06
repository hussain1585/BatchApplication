package com.hussi.service.batchLifeCycle;

import java.util.List;

public interface OutputFormatter {
    List<String> format(List<String> raw);
}