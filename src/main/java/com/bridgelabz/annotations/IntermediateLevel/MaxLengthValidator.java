package com.bridgelabz.annotations.IntermediateLevel;

import java.lang.annotation.*;
import java.lang.reflect.Field;

// Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// User class using @MaxLength annotation
class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateMaxLength();
    }

    private void validateMaxLength() {
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);

                try {
                    field.setAccessible(true);
                    Object value = field.get(this);

                    if (value instanceof String && ((String) value).length() > maxLength.value()) {
                        throw new IllegalArgumentException(
                                "Field '" + field.getName() + "' exceeds max length of " + maxLength.value()
                        );
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void show() {
        System.out.println("Username: " + username);
    }
}

// Main class to test
public class MaxLengthValidator {
    public static void main(String[] args) {
        try {
            User user1 = new User("Ankush");          // Valid
            user1.show();

            User user2 = new User("SuperLongUsername");  // Invalid
            user2.show();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Failed: " + e.getMessage());
        }
    }
}
