package chapter11;

import java.util.Optional;

public class Car2 {
    private Insurance insurance;
    public Optional<Insurance> getInsurance() {
        return Optional.ofNullable(insurance);
    }
}
