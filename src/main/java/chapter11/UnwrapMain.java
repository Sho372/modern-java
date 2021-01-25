package chapter11;

import java.util.Optional;
import java.util.OptionalDouble;

public class UnwrapMain {

    public static void main(String[] args) {

        // Creating Optional objects
        // 1. empty() -> Optional as empty
        Optional<String> optStr1 = Optional.empty();
        // 2. of()
        String str2 = "Hello";
        Optional<String> optStr2 = Optional.of(str2);
        // 3. ofNullable()
        String str3 = null;
        Optional<String> optStr3 = Optional.ofNullable(str3);

        // Unwrap Optional objets
        // 1. get()
        String unWrapped = optStr3.get();
        // 2. orElse() -> set default value only if not present.
        String unWrapped2 = optStr3.orElse("Unknown");
        // 3. orElseGet() -> invoke supplier and return the value only if not present
        String unWrapped3 = optStr3.orElseGet(() -> "Unknown");
    }

}
