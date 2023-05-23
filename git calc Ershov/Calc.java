import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите уравнение:");
        String urav = scanner.nextLine();
        System.out.println(calc(urav));
    }

    public static String calc(String urav) throws Exception {
        int num1;
        int num2;
        boolean TruFalRom;                                                  //проверка на формат
        int rezult;                                                         //формула уравнения перед ответом
        String otvet;                                                       // ответ
        String sim;                                                         //символ
        String[] oper = urav.split(" ");
        if (urav.contains("+")){
        }else if ((urav.contains("-"))){
        }else if ((urav.contains("/"))){
        }else if ((urav.contains("*"))){
        }else throw new Exception ("строка не является математической операцией");
        if (oper.length != 3)
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        sim = oper[1];
        if (Roman.TruFalRom(oper[0]) && Roman.TruFalRom(oper[2])) {
            num1 = Roman.perevodNoArab(oper[0]);
            num2 = Roman.perevodNoArab(oper[2]);
            TruFalRom = true;
        } else if (!Roman.TruFalRom(oper[0]) && !Roman.TruFalRom(oper[2])) {
            num1 = Integer.parseInt(oper[0]);
            num2 = Integer.parseInt(oper[2]);
            TruFalRom = false;
        } else {
            throw new Exception("Числа должны быть в одном формате");
        }
        if (num1 > 10 || num2 > 10) throw new Exception("Введите значение меньше 10");


        if (sim.contains("-")) {
            rezult = num1 - num2;

        } else if (sim.contains("+")) {
            rezult = num1 + num2;

        } else if (sim.contains("/")) {
            rezult = num1 / num2;

        } else if (sim.contains("*")) {
            rezult = num1 * num2;

        } else {
            throw new Exception("Неверный знак");
        }

        if (TruFalRom) {
            if (rezult<1) {throw new Exception ("Римское число не может быть меньше или ровна нулю");
            }
            otvet= Roman.perevodNaRom(rezult);
        } else {
            otvet=String.valueOf(rezult);
        }
        return otvet;
    }
}
class Roman {
    static String[] romanChif = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};
    public static boolean TruFalRom(String val) {
        for (int i = 0; i < romanChif.length; i++) {
            if (val.equals(romanChif[i])) {
                return true;
            }
        }
        return false;
    }

    public static int perevodNoArab(String roman) {
        for (int i = 0; i < romanChif.length; i++) {
            if (roman.equals(romanChif[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String perevodNaRom(int arab) {
        return romanChif[arab];
    }

}

