package com.dari.ccm.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.File;

public class ConfigLoader {
    private String filePath;

    public ConfigLoader(String filePath) {
        this.filePath = filePath;
    }

    public <T> T load(Class<T> valueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(new File(filePath), valueType);
    }
}