package com.max.hackerrank;

public class long_pressed_name {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0; int j = 0;

        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {

                if (i == name.length() - 1) {
                    return true;
                }

                i++;
                j++;
            } else {
                j++;
            }
        }

        return false;
    }
}
