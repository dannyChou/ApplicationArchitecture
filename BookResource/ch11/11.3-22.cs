class ListLoader...

    public void Attach (DomainList list) {
        list.RunLoader = new DomainList.Loader(Load);
    }