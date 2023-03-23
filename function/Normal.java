import java.util.List;

public class Normal {
    public static void main(String args[]) {
        List<String> cities = new ListCities().getCities();
        for(String city:cities) System.out.println(city);
    }
}
