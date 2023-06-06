package org.example;

import java.net.MalformedURLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        System.out.print("Введіть код статусу: ");
        try (Scanner scanner = new Scanner(System.in)) {
            int statusCode = scanner.nextInt();
            try {
                new HttpStatusImageDownloader().downloadStatusImage(statusCode);
            } catch (Exception e) {
                System.out.printf("There is not image for HTTP status %d%n", statusCode);
            }
        } catch (InputMismatchException e) {
            System.out.println("Будь ласка, введіть коректне число!");
        }
    }
}
