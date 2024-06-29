public class Person {
    public List dependents() {
        return Registry.personRepository().dependentsOf(this);
    }
}