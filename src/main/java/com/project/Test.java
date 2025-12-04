package com.project;

public abstract class Test {
    private static State state = State.S;

    public static State process(String s) {
        state = State.S;

        for (char ch : s.toCharArray()) {
            switch (state) {

                case S -> state = (ch == 'T') ? State.ONE : State.S;

                case ONE -> {
                    if (ch == 'E') state = State.TWO;
                    else if (ch == 'T') state = State.ONE;
                    else state = State.S;
                }

                case TWO -> {
                    if (ch == 'S') state = State.THREE;
                    else if (ch == 'T') state = State.ONE;
                    else state = State.S;
                }

                case THREE -> {
                    if (ch == 'T') state = State.F;
                    else if (ch == 'E') state = State.TWO;
                    else state = State.S;
                }

                case F -> state = State.F;
            }
        }

        return state;
    }
}