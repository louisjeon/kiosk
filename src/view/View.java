package view;

import java.util.Scanner;
import static java.lang.System.*;

public abstract class View {
    protected static final Scanner scanner = new Scanner(in);
    protected static final String WRONG_CHOICE = "올바르지 못한 선택지입니다.";

    protected View() {}
}
