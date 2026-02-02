package chapter10.implementingRestServices.models;

public class Country {
    // Attributes
    private String name;
    private Long population;

    // Construtor
    public Country(String name, Long population) {
        this.name = name;
        this.population = population;
        System.out.println(name + " " + population);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
