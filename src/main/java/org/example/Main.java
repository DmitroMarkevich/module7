package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // new HttpStatusImageDownloader().downloadStatusImage(200);
        // new HttpStatusChecker().getStatusImage(104);
        new HttpImageStatusCli().askStatus();
    }
}