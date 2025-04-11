package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class TransformService {

    public String transform(int number) {
        if (number < 0 || number > 100) return "Invalid";

        StringBuilder result = new StringBuilder();

        // Règles de divisibilité (prioritaires)
        if (number % 3 == 0) result.append("FOO");
        if (number % 5 == 0) result.append("BAR");

        // Analyse chiffre par chiffre
        char[] digits = String.valueOf(number).toCharArray();
        for (char digit : digits) {
            switch (digit) {
                case '3': result.append("FOO"); break;
                case '5': result.append("BAR"); break;
                case '7': result.append("QUIX"); break;
            }
        }

        return result.length() > 0 ? result.toString() : String.valueOf(number);
    }
}
