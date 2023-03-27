import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class task {
    public static void main(String[] args) {

        Laptop l1 = new Laptop("Lenovo", 17, 32, 1024, "Windows", "Gray");
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
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Основное меню. Нажмите соответствующую цифру:\n1-показать все ноутбуки\n2-выбрать по параметрам\n3-выход.");
        while (flag) {
            try {
                int inputUser = scan.nextInt();
                if (inputUser < 1 | inputUser > 3)
                    throw new NegativeArraySizeException();
                else
                    switch (inputUser) {
                        case 1:
                            showAllLaptops(laptopSet);
                            flag = false;
                            break;
                        case 2:
                            Map<Integer, String> mapAllFilters = criteriaMap();
                            printMap(mapAllFilters);
                            Map<Integer, String> mapWithOneCriteria = criteriasFromUser();
                            Map<Integer, String> mapWithCriteriasFromUser = plusCriteria(mapWithOneCriteria,
                                    mapAllFilters);
                            // printMap(mapWithCriteriasFromUser);
                            showLaptopsAfterCriterias(mapWithCriteriasFromUser, laptopSet);
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
                System.out.println("Некорректный ввод!");
                main(null);
                break;
            }
            scan.close();
        }
    }

    public static void showAllLaptops(Set<Laptop> set) {
        System.out.println("\nВесь асортимент: ");
        for (Object item : set) {
            System.out.println(item);
        }
    }

    public static Map<Integer, String> criteriaMap() {
        System.out.println("\nВведите цифру, какой критерий хотите использовать?");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Наименование");
        map.put(2, "Диагональ экрана");
        map.put(3, "Объем оперативной памяти");
        map.put(4, "Объем жесткого диска");
        map.put(5, "Операционная система");
        map.put(6, "Цвет");

        return map;
    }

    public static void printMap(Map<Integer, String> map) {
        for (var item : map.entrySet()) {
            System.out.println(item.getKey() + "-" + item.getValue());
        }
    }

    public static Map<Integer, String> criteriasFromUser() {
        Scanner scan = new Scanner(System.in);
        Map<Integer, String> map = new HashMap<>();
        int inputFirstNumOfCriteria = scan.nextInt();
        switch (inputFirstNumOfCriteria) {
            case 1:
                System.out.println("Введите наименование: ");
                map.put(1, scan.next());
                break;
            case 2:
                System.out.println("Введите желаемую диагональ: ");
                map.put(2, scan.next());
                break;
            case 3:
                System.out.println("Введите желаемый объем RAM: ");
                map.put(3, scan.next());
                break;
            case 4:
                System.out.println("Введите желаемый объем жесткого диска: ");
                map.put(4, scan.next());
                break;
            case 5:
                System.out.println("Введите желаемую операционную систему: ");
                map.put(5, scan.next());
                break;
            case 6:
                System.out.println("Введите желаемый цвет: ");
                map.put(6, scan.next());
                break;
            default:
                System.out.println("Такого выбора нет!");
                break;
        }
        // System.out.println(map2.get(2));
        return map;

    }

    public static Map<Integer, String> plusCriteria(Map<Integer, String> map, Map<Integer, String> mapAllCriterias) {
        System.out.println("Хотите добавить критерий? 1 - да, 2 - нет: ");
        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()) {
            case 1:
                Boolean flags = true;
                // System.out.println("Введите критерий: ");
                while (flags) {
                    if (map.size() < 6) {
                        System.out.println("Номер критерия: ");
                        int w = scan.nextInt();
                        if (!map.containsKey(w)) {
                            if (mapAllCriterias.containsKey(w)) {
                                System.out.println(mapAllCriterias.get(w));
                                map.put(w, scan.next());
                                flags = false;
                                plusCriteria(map, mapAllCriterias);
                            }
                        } else
                            System.out.println("Критерий уже есть!");
                    } else {
                        System.out.println("Все фильтры использованы!");
                        flags = false;
                    }
                }
                break;
            case 2:
                // System.out.println(map);
                break;

            default:
                break;
        }
        scan.close();
        return map;

    }

    public static void showLaptopsAfterCriterias(Map<Integer, String> map, Set<Laptop> set) {
        if (map.containsKey(1)) {
            set.removeIf(item -> !map.get(1).equals(item.getName()));
        }
        if (map.containsKey(2)) {
            set.removeIf(item -> !map.get(2).equals(String.valueOf(item.getScreenSize())));
        }
        if (map.containsKey(3)) {
            set.removeIf(item -> !map.get(3).equals(String.valueOf(item.getMemory())));
        }
        if (map.containsKey(4)) {
            set.removeIf(item -> !map.get(4).equals(String.valueOf(item.getStorage())));
        }
        if (map.containsKey(5)) {
            set.removeIf(item -> !map.get(5).equals(item.getOs()));
        }
        if (map.containsKey(6)) {
            set.removeIf(item -> !map.get(6).equals(item.getColour()));
        }

        System.out.println("\nНоутбук(и) соответствующий(ие) вашим характеристикам:\n ");
        for (Laptop laptop : set) {
            System.out.println(laptop);
        }
        if (set.size() == 0)
            System.out.println("Таких ноутбуков нет!!!");
        System.out.println();
    }

}
