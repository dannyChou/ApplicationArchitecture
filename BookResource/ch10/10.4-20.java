class Person...

    public void dbLoadLastName(String lastName) {
        assertStateIsLoading();
        this.lastName = lastName;
    }

class DomainObjectEL...
    void assertStateIsLoading() {
        Assert.isTrue(state == LOADING);
    }