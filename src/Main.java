import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //task1
        System.out.println("### Задание 1");
        List<Integer> autoYears = new ArrayList<>(50);
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            autoYears.add(random.nextInt(2000,2026));
        }
        System.out.println("Годы выпуска машин:" + autoYears);

        List<Integer> after2015 = autoYears.stream()
                .filter(x -> x > 2015)
                .toList();
        System.out.println("Машины с годом выпуска после 2015:" + after2015);

        int currentYear = 2026;
        double averageAge = autoYears.stream()
                .mapToInt(x -> currentYear - x)
                .average()
                .orElse(0.0);

        System.out.println("Средний возраст автомобилей: " + averageAge);

        //task2
        System.out.println("### Задание 2");
        List<String> autoNames = List.of("Toyota", "Audi", "BMW", "Mercedes", "Alfa Romeo",
                "Audi", "AstonMartin", "Tesla", "Toyota", "Ferrari");
        System.out.println("Список машин: " + autoNames);
        List<String> distinctSorted = autoNames.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        Set<String> uniqueSet = new LinkedHashSet<>(distinctSorted);
        System.out.println("Отсортированный массив: " + uniqueSet);

        List<String> result = autoNames.stream()
                .map(name -> name.equals("Tesla") ? "ELECTRO_CAR" : name)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Массив без 'Tesla': " + result);

        //task3
        System.out.println("### Задание 3");
        Car car1 = new Car("123", "C-Class", "Mercedes", 2020, 15000, 35000);
        Car car2 = new Car("456", "E-Class", "Mercedes", 2018, 30000, 28000);
        Car car3 = new Car("123", "C-Class AMG", "Mercedes", 2021, 5000, 45000);
        Car car4 = new Car("789", "X5", "BMW", 2022, 10000, 50000);
        Car car5 = new Car("898", "X", "Tesla", 2020, 20000, 40000);

        Set<Car> carSet = new HashSet<>();
        carSet.add(car1);
        carSet.add(car2);
        carSet.add(car3);
        carSet.add(car4);
        carSet.add(car5);
        System.out.println("HashSet из машин: " + carSet);

        List<Car> carList = new ArrayList<>(carSet);
        Collections.sort(carList);
        System.out.println("Отсортированные машины: " + carList);

        //task4
        System.out.println("### Задание 4");
        List<Car> carsList = List.of(car1, car2, car3, car4, car5);
        List<Car> lowMileageCars = carsList.stream()
                .filter(car -> car.getMileage() <= 20000)
                .toList();
        System.out.println("Машины с пробегом <= 20000: " + lowMileageCars);

        List<Car> top3Expensive = carsList.stream()
                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
                .limit(3)
                .toList();
        System.out.println("Топ 3 самые дорогие машины: " + top3Expensive);

        double averageMileage = carsList.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0.0);
        System.out.println("Средний пробег: " + averageMileage);

        Map<String, List<Car>> carsByManufacturer = carsList.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));
        System.out.println("Группировка по производителю: " + carsByManufacturer);
    }

}
