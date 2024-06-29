class Album...

    public static Album create(String name) {
        Album obj = new Album(IdGenerator.nextId(), name);
        obj.markNew();
        return obj;
    }
    public void setTitle(String title) {
        this.title = title;
        markDirty();
    }