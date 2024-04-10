package FirstGame;
import Person.PersonBase;
import java.util.Collections;
import java.util.List;

public class View {
    private static int step = 1;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

    // Метод для установки отступов для форматированного вывода
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif > 0)
            System.out.printf("%" + dif + "s", ":\t");
        else
            System.out.print(":\t");
    }

    // Метод для форматирования строк
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

    // Метод для получения символа для отображения в ячейке
    private static String getChar(int x, int y, List<PersonBase> holyTeam, List<PersonBase> darkTeam){
        String out = "| ";
        for (PersonBase human: holyTeam) {
            if (human.getCoordinates().getX() == x && human.getCoordinates().getY() == y){
                out = "|" + (AnsiColors.ANSI_BLUE + human.getName().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        for (PersonBase human: darkTeam) {
            if (human.getCoordinates().getX() == x && human.getCoordinates().getY() == y){
                out = "|" + (AnsiColors.ANSI_GREEN + human.getName().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }

    // Метод для отображения игрового поля
    public static void view(List<PersonBase> holyTeam, List<PersonBase> darkTeam) {
        // Вывод информации о текущем ходе
        if (step == 1) {
            System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        }
        step++;

        // Определение максимальной длины имени персонажа для корректного форматирования
        int maxNameLength = Math.max(holyTeam.stream().mapToInt(p -> p.getName().length()).max().orElse(0),
                darkTeam.stream().mapToInt(p -> p.getName().length()).max().orElse(0));

        // Определение максимальной длины типа персонажа
        int maxTypeLength = Math.max(holyTeam.stream().mapToInt(p -> p.getType().length()).max().orElse(0),
                darkTeam.stream().mapToInt(p -> p.getType().length()).max().orElse(0));

        // Вывод разделителя
        System.out.print("_".repeat(maxNameLength + maxTypeLength + 2));
        System.out.println();

        // Вывод верхней части игрового поля
        System.out.print(top10 + "    ");
        System.out.print("Blue side");
        int spacesToAdd = Math.max(0, maxNameLength + maxTypeLength - 9);
        System.out.print(" ".repeat(spacesToAdd));
        System.out.print(" ".repeat(maxNameLength - 9));
        System.out.print(" ".repeat(maxTypeLength));
        System.out.println(":\tGreen side");

        // Вывод информации о каждой ячейке игрового поля
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(getChar(j, i, holyTeam, darkTeam));
            }

            System.out.print("|    ");
            if (i < holyTeam.size()) {
                PersonBase holyCharacter = holyTeam.get(i);
                System.out.print(holyCharacter.getName() + " (" + holyCharacter.getType() + ")");
                tabSetter(holyCharacter.getName().length() + holyCharacter.getType().length(), maxNameLength + maxTypeLength);
            } else {
                System.out.print(" ".repeat(maxNameLength + maxTypeLength));
                tabSetter(0, maxNameLength + maxTypeLength);
            }
            if (i < darkTeam.size()) {
                PersonBase darkCharacter = darkTeam.get(i);
                System.out.println(darkCharacter.getName() + " (" + darkCharacter.getType() + ")");
            } else {
                System.out.println();
            }
            if (i != 9) {
                System.out.println(midl10); // Вывод разделителя, кроме последней строки
            }
        }
        System.out.println(bottom10);
    }
}
