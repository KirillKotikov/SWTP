import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static byte getResult(String fieldCells, String race) {
        Map<Character, Byte> movingCost = null;
        char[][] field = {
                {fieldCells.charAt(0), fieldCells.charAt(1), fieldCells.charAt(2), fieldCells.charAt(3)},
                {fieldCells.charAt(4), fieldCells.charAt(5), fieldCells.charAt(6), fieldCells.charAt(7)},
                {fieldCells.charAt(8), fieldCells.charAt(9), fieldCells.charAt(10), fieldCells.charAt(11)},
                {fieldCells.charAt(12), fieldCells.charAt(13), fieldCells.charAt(14), fieldCells.charAt(15)},
        };
        byte result = Byte.MAX_VALUE;
        byte temp = 0;
        byte x;
        byte y;

        switch (race) {
            case "Human" -> {
                movingCost = new HashMap<>();
                movingCost.put('S', (byte) 5);
                movingCost.put('W', (byte) 2);
                movingCost.put('T', (byte) 3);
                movingCost.put('P', (byte) 1);
            }
            case "Swamper" -> {
                movingCost = new HashMap<>();
                movingCost.put('S', (byte) 2);
                movingCost.put('W', (byte) 2);
                movingCost.put('T', (byte) 5);
                movingCost.put('P', (byte) 2);
            }
            case "Woodman" -> {
                movingCost = new HashMap<>();
                movingCost.put('S', (byte) 3);
                movingCost.put('W', (byte) 3);
                movingCost.put('T', (byte) 2);
                movingCost.put('P', (byte) 2);
            }
            default -> {
                System.out.println("Указана неверная раса существа - " + race + ". Возможные варианты: Human, Swamper, Woodman.");
                System.exit(0);
            }
        }
        // Сначала проверим ходы со стартовой клетки
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                x = 1;
                y = 0;
            } else {
                x = 0;
                y = 1;
            }
            temp += movingCost.get(field[x][y]);
            while (true) {
                if (x == 3 && y == 3) break;
                else if (x == 3) {
                    y++;
                } else if (y == 3) {
                    x++;
                } else if (movingCost.get(field[x + 1][y]) < movingCost.get(field[x][y + 1])) {
                    x++;
                } else y++;
                temp += movingCost.get(field[x][y]);
            }
            result = temp < result ? temp : result;
            temp = 0;
        }
        // Затем проверяем с конечной клетки
        for (int i = 0; i < 2; i++) {
            temp = movingCost.get(field[3][3]);
            if (i == 0) {
                x = 3;
                y = 2;
            } else {
                x = 2;
                y = 3;
            }
            temp += movingCost.get(field[x][y]);
            while (true) {
                if (x == 0 && y == 0) break;
                else if (x == 0) {
                    y--;
                } else if (y == 0) {
                    x--;
                } else if (movingCost.get(field[x - 1][y]) < movingCost.get(field[x][y - 1])) {
                    x--;
                } else y--;
                if ((x != 0 && y != 1) || (x != 1 && y != 0)) temp += movingCost.get(field[x][y]);
            }
            result = temp < result ? temp : result;
        }
        return result;
    }
}