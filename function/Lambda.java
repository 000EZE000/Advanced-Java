
import java.util.List;
import java.util.stream.Collectors;



public class Lambda {
    /**
     * @param arg
     */
    public static void main(String args[] ){
        List<String> cities = new ListCities().getCities();
        cities.stream().forEach(city -> System.out.println(city));
        //more easy
        cities.forEach(city -> System.out.println(city));
        //  for heavy tasks run in parralleL
        cities.stream().parallel().forEach(city -> System.out.println(city));

        // save data
        List<String> citiesFilter = cities.stream().filter(city-> city.startsWith("F")).collect(Collectors.toList());
        
    }


}