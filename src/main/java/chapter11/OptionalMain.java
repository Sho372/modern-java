package chapter11;

import java.util.Optional;

public class OptionalMain {

    // Null-safe attempt 1: deep doubts
    public String getCarInsuranceName1(Person person) {
        if(person != null) {
            Car car = person.getCar();
            if(car != null) {
                Insurance insurance = car.getInsurance();
                if(insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }

    // Null-safe attempt 2: too many exits
    public String getCarInsuranceName2(Person person) {
        if(person == null) {
            return "Unknown";
        }
        Car car = person.getCar();
        if(car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if(insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }

    // rewrite getCarInsuranceName with flatMap
    // changing optional objects with flatMap

    // Doesn't compile
    // Optional<Optional<Car> -> Optional<Car> doesn't support the getInsurance
//    public String getCarInsuranceName3(Person2 person) {
//        Optional<Person2> optPerson = Optional.of(person);
//        Optional<String> name = optPerson.map(OptionalPerson::getCar)
//                .map(OptionalCar::getInsurance)
//                .map(Insurance::getName);
//    }

    // orElseでdefault値を設定することで、Insurance::getNameの返すOptional<String>がunwrapされる

    // Item 16: Do Not Use Optional in Methods Arguments
    public String getCarInsuranceName3(Person2 person) {
        Optional<Person2> optPerson = Optional.ofNullable(person);
        return optPerson.flatMap(Person2::getCar)
                .flatMap(Car2::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
