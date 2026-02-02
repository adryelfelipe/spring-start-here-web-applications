package chapter10.implementingRestServices.models.exceptions;

public class CountryNullException extends RuntimeException {
    public CountryNullException() {
        super("The country can't be null");
    }
}
