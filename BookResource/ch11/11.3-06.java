class VirtualList...

private List source;
private VirtualListLoader loader;
public VirtualList(VirtualListLoader loader) {
    this.loader = loader;
}
private List getSource() {
    if (source == null) source = loader.load();
    return source;
}