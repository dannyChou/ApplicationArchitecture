    try {
        ThreadLocalRegistry.begin();
        PersonFinder f1 = ThreadLocalRegistry.personFinder();
        Person martin = Registry.personFinder().find(1);
        assertEquals("Fowler", martin.getLastName());
    } finally {ThreadLocalRegistry.end();
    }