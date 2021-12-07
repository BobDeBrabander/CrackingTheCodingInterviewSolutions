package chapter13;

import java.util.List;
import java.util.Random;

public class Problem7 {

    class Contintent {
        String name;

        Integer getPopulation() {
            return new Random().nextInt();
        }
    }

    class Country {
        Contintent getContinent() {
            return new Contintent();
        }
    }

    Integer totalPopulation(List<Country> countries, String continent) {
        return countries.stream()
                .map(Country::getContinent)
                .filter(country -> country.name.equals(continent))
                .mapToInt(Contintent::getPopulation)
                .sum();
    }

}
