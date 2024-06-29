class Person...

    public Money getExemption() {
        Money baseExemption = Money.dollars(1500);
        Money dependentExemption = Money.dollars(750);
        return baseExemption.add(dependentExemption.multiply(this.getNumberOfDependents()));
    }