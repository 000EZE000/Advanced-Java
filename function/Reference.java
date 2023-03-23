import java.util.List;

public class Reference{

    public static void main(String args[]) {
        List<String> cities = new ListCities().getCities();
        cities.stream().forEach(Reference::printCity);
        //more easy
        cities.forEach(System.out::println);

    }
    private static void printCity(String city){
        System.out.println(city);
    }
}
