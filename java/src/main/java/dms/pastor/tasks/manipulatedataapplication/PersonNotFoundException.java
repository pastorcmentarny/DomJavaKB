package dms.pastor.tasks.manipulatedataapplication;

class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String personName) {
        super("Person " + personName + " not found.");
    }
}
