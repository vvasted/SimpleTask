import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlexibleFilter {
    public static void main(String[] args) {
        // Static lists for different data types
        List<Integer> integerList = Arrays.asList(10, 15, 20, 25, 30, 35, 40);
        List<String> stringList = Arrays.asList("Are", "you", "ready", "to", "make", "sure", "your", "challenge", "has", 
                                                "succeeded", "and", "grow", "with", "us", "at", "eppTEC?");
        List<Double> doubleList = Arrays.asList(1.5, 2.7, 3.14, 4.2, 5.0, 6.28, 7.5);
        

        // Filters for integers
        List<Predicate<Integer>> intFilters = Arrays.asList(
            n -> n > 20, 
            n -> n % 2 == 0
            // Space for next filters for integers...
            //todo
        );

        // Filters for strings
        List<Predicate<String>> stringFilters = Arrays.asList(
            s -> s.length() > 2, 
            s -> s.endsWith("u") || s.contains("ee")
            // Space for next filters for strings...
            //todo
        );

        // Filters for floating-point numbers
        List<Predicate<Double>> doubleFilters = Arrays.asList(
            d -> d > 3.0, 
            d -> d % 1 == 0
            // Space for next filters for floating-point numbers...
            //todo
        );

        // Output original lists and apply filters
        System.out.println("Integers: ");
        System.out.println("Original list: " + integerList);
        System.out.println("Filtered list: " + applyFilters(integerList, intFilters));
        System.out.println();

        System.out.println("Strings: ");
        System.out.println("Original list: " + stringList);
        System.out.println("Filtered list: " + applyFilters(stringList, stringFilters));
        System.out.println();

        System.out.println("Floating-point numbers: ");
        System.out.println("Original list: " + doubleList);
        System.out.println("Filtered list: " + applyFilters(doubleList, doubleFilters));
    }

    public static <T> List<T> applyFilters(List<T> items, List<Predicate<T>> filters) {
        return items.stream()
                    
                    // Use AND logic: element is kept if it satisfies all filters
                    .filter(item -> filters.stream().allMatch(filter -> filter.test(item)))
                    
                    // Use OR logic: element is kept if it satisfies at least one filter
                    //.filter(item -> filters.stream().anyMatch(filter -> filter.test(item)))
                    .collect(Collectors.toList());
    }
}
