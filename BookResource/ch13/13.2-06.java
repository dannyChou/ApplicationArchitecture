    QueryObject query = new QueryObject(Person.class);
    query.addCriteria(Criteria.greaterThan("numberOfDependents", 0));