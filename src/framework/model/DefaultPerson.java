package framework.model;

public class DefaultPerson extends DefaultCustomer implements Person {
    private final String dateOfBirth;

    public DefaultPerson(String name, String street, String city, String state, String zip, String email, String dateOfBirth) {
        super(name, street, city, state, zip, email);
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
