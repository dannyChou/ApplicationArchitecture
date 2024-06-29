class VirtualList...

    public int size() {
        return getSource().size();
    }
    public boolean isEmpty() {
        return getSource().isEmpty();
    }
    // ... 依此類推，用於清單方法的其餘部分