package project.service;

import org.springframework.stereotype.Service;

@Service
public class IntFromString {
    public int value(String value) {
        if(!isInt(value)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(value);
    }

    public boolean isInt(String value) {
        return value.matches("^\\d+$");
    }
}
