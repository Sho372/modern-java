package chapter11;

import java.util.Optional;

public class Person2 {

    // Item 15: Do Not Use Optional in Setters Arguments
    // https://dzone.com/articles/using-optional-correctly-is-not-optional
    private Car2 car;
    public Optional<Car2> getCar() {
        return Optional.ofNullable(car);
    }
}
