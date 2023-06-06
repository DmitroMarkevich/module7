package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws IOException {
        String imageUrl = new HttpStatusChecker().getStatusImage(code);
        URL imageRequestUrl = new URL(imageUrl);

        try (InputStream in = imageRequestUrl.openStream()) {
            String fileName = extractFileName(imageUrl);
            Path outputPath = Path.of("src/main/resources/" + fileName);
            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private String extractFileName(String imageUrl) {
        int nameStart = imageUrl.lastIndexOf('/');
        return imageUrl.substring(nameStart + 1);
    }
}
