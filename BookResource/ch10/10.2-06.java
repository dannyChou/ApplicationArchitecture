PersonFinder finder = new PersonFinder();
Iterator people = finder.findResponsibles().iterator();
StringBuffer result = new StringBuffer();
while (people.hasNext()) {
    PersonGateway each = (PersonGateway) people.next();
    result.append(each.getLastName());
    result.append("");
    result.append(each.getFirstName());
    result.append("");
    result.append(String.valueOf(each.getNumberOfDependents()));
    result.append("\n");
}
return result.toString();