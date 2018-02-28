package net.tt1;

import org.springframework.test.annotation.ProfileValueSource;

public class CustomProfile implements ProfileValueSource {
    @Override
    public String get(String key) {
        if (key.equals("dev")) {
            return "Development";
        } else if (key.equals("qa")) {
            return "QA";
        }
        return null;
    }
}
