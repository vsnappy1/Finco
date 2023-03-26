package framework.model;

public class DefaultCustomer implements Customer {
    private final String name;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;
    private final String email;

    public DefaultCustomer(String name, String street, String city, String state, String zip, String email) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getEmail() {
        return email;
    }
}
