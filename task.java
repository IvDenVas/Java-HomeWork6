import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class task {
    public static void main(String[] args) {

        Laptop l1 = new Laptop("Lenovo", 16, 32, 1024, "Windows", "Gray");
        Laptop l2 = new Laptop("Asus", 15, 16, 512, "Windows", "Blue");
        Laptop l3 = new Laptop("Acer", 15, 8, 256, "Linux", "Silver");
        Laptop l4 = new Laptop("Acer", 14, 8, 256, "Linux", "Red");
        Laptop l5 = new Laptop("Lenovo", 16, 16, 256, "Windows", "White");
        Laptop l6 = new Laptop("Asus", 15, 16, 512, "Linux", "Gray");
        Laptop l7 = new Laptop("Apple", 16, 32, 1024, "MacOS", "Black");
        Laptop l8 = new Laptop("Apple", 13, 8, 512, "MacOS", "Silver");

        Set<Laptop> laptopSet = new HashSet<>();
        laptopSet.add(l1);
        laptopSet.add(l2);
        laptopSet.add(l3);
        laptopSet.add(l4);
        laptopSet.add(l5);
        laptopSet.add(l6);
        laptopSet.add(l7);
        laptopSet.add(l8);

        boolean flag = true;

        while (flag) {
            try {
                int inputMenu = menu();
                if (inputMenu < 1 | inputMenu > 3)
                    System.out.println("Такого действия нет!");
                else
                    switch (inputMenu) {
                        case 1:
                            showAllLaptops(laptopSet);
                            flag = false;
                            break;
                        case 2:
                            criteriaMap();
                            criteriaFromUser(laptopSet);
                            flag = false;
                            break;
                        case 3:
                            System.out.println("Программа завершена!");
                            flag = false;
                            break;

                        default:
                            break;
                    }

            } catch (Exception e) {
                System.out.println("Некорректный ввод! Введите цифру!");
            }

        }
    }

    public static void criteriaFromUser(Set<Laptop> lSet) {
        Scanner scan = new Scanner(System.in);
        boolean flag2 = true;
        while (flag2) {
            int inputCriteria = scan.nextInt();
            try {
                if (inputCriteria < 1 | inputCriteria > 6)
                    System.out.println("Такого критерия нет!");
                else {
                    switch (inputCriteria) {
                        case 1:
                            System.out.println("Введите желаемого производителя: ");
                            String criteriaName = scan.next();
                            int inputName = 0;
                            for (Laptop laptop : lSet) {
                                if (laptop.getName().equals(criteriaName)) {
                                    System.out.println(laptop);
                                } else
                                    inputName++;
                            }
                            if (inputName == lSet.size()) {
                                System.out.println("Таких ноутбуков нет!");
                            }
                            flag2 = false;
                            break;

                        case 2:
                            System.out.println("Введите желаемую диагональ экрана (13, 14, 15, 16): ");
                            String criteriaDiag = scan.next();
                            int inputDiag = 0;
                            for (Laptop laptop : lSet) {
                                if (String.valueOf(laptop.getScreenSize()).equals(criteriaDiag)) {
                                    System.out.println(laptop);
                                } else
                                    inputDiag++;
                            }
                            if (inputDiag == lSet.size()) {
                                System.out.println("Таких ноутбуков нет!");
                            }

                            flag2 = false;
                            break;
                        case 3:
                            System.out.println("Введите желаемый объем RAM: ");
                            String criteriaRam = scan.next();
                            int inputRam = 0;
                            for (Laptop laptop : lSet) {
                                if (String.valueOf(laptop.getMemory()).equals(criteriaRam)) {
                                    System.out.println(laptop);
                                } else
                                    inputRam++;
                            }
                            if (inputRam == lSet.size()) {
                                System.out.println("Таких ноутбуков нет!");
                            }
                            flag2 = false;
                            break;
                        case 4:
                            System.out.println("Введите желаемый объем жесткого диска: ");
                            String criteriaStorage = scan.next();
                            int inputStorage = 0;
                            for (Laptop laptop : lSet) {
                                if (String.valueOf(laptop.getStorage()).equals(criteriaStorage)) {
                                    System.out.println(laptop);
                                } else
                                    inputStorage++;
                            }
                            if (inputStorage == lSet.size()) {
                                System.out.println("Таких ноутбуков нет!");
                            }
                            flag2 = false;
                            break;
                        case 5:
                            System.out.println("Введите желаемую операционную систему: ");
                            String criteriaOs = scan.next();
                            int inputOs = 0;
                            for (Laptop laptop : lSet) {
                                if (laptop.getOs().equals(criteriaOs)) {
                                    System.out.println(laptop);
                                } else
                                    inputOs++;
                            }
                            if (inputOs == lSet.size()) {
                                System.out.println("Таких ноутбуков нет!");
                            }
                            flag2 = false;
                            break;
                        case 6:
                            System.out.println("Введите желаемый цвет: ");
                            String criteriaColour = scan.next();
                            int inputColour = 0;
                            for (Laptop laptop : lSet) {
                                if (laptop.getColour().equals(criteriaColour)) {
                                    System.out.println(laptop);
                                } else
                                    inputColour++;
                            }
                            if (inputColour == lSet.size()) {
                                System.out.println("Таких ноутбуков нет!");
                            }
                            flag2 = false;
                            break;
                        
                        default:
                            break;
                    }
                }
    
            } catch (Exception e) {
                System.out.println("Некорректный ввод! Введите цифру!");
                flag2 = false;
            }
        }
        scan.close();
    }

    public static int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Основное меню. Нажмите соответствующую цифру:\n1-показать все ноутбуки\n2-выбрать по параметрам\n3-выход.");
        int inputFromUser = scan.nextInt();
        // scan.close();
        return inputFromUser;
    }

    public static void showAllLaptops(Set<Laptop> set) {
        System.out.println("\nВесь асортимент: ");
        for (Object item : set) {
            System.out.println(item);
        }
    }

    public static void criteriaMap() {
        System.out.println("\nВведите цифру, какой критерий хотите использовать?");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Наименование");
        map.put(2, "Диагональ экрана");
        map.put(3, "Объем оперативной памяти");
        map.put(4, "Объем жесткого диска");
        map.put(5, "Операционная система");
        map.put(6, "Цвет");

        printMap(map);   
    }

    public static void printMap(Map<Integer, String> map) {
        for (var item : map.entrySet()) {
            System.out.println(item.getKey() + "-" + item.getValue());
        }
    }

    // public static String inputFromUser() {
    //     Scanner scan = new Scanner(System.in);
    //     String res = scan.next();
    //     return res;
    // }
}
