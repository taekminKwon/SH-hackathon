package com.example.hackathon.common.mock;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

@Component
public class MockApiLoader {

    private final ObjectMapper objectMapper;

    public MockApiLoader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public <T> T loadMockResponse(String fileName, TypeReference<T> typeRef) {
        String path = "mock/" + fileName + ".json";
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
            if (is == null) {
                throw new FileNotFoundException("Mock JSON not found: " + path);
            }
            return objectMapper.readValue(is, typeRef);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to load mock response: " + path, e);
        }
    }
}
