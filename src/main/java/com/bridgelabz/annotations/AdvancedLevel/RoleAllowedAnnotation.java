package com.bridgelabz.annotations.AdvancedLevel;


import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface RoleAllowed {
    String value();
}

class SecurityContext {
    static String currentUserRole = "USER";
}

@RoleAllowed("ADMIN")
class AdminService {
    void performAdminTask() {
        System.out.println("Admin task performed!");
    }
}

public class RoleAllowedAnnotation {
    public static void main(String[] args) {
        Class<AdminService> cls = AdminService.class;

        if (cls.isAnnotationPresent(RoleAllowed.class)) {
            String allowed = cls.getAnnotation(RoleAllowed.class).value();
            String current = SecurityContext.currentUserRole;

            if (allowed.equals(current)) {
                new AdminService().performAdminTask();
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}