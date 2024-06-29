public class PersonRepository extends Repository {
    public List list dependentsOf(Person aPerson) {
        Criteria criteria = new Criteria();
        criteria.equal(Person.BENEFACTOR, aPerson);
        return matching(criteria);
    }
}