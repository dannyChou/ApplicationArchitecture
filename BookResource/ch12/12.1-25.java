class LineItemMapper...

    private Long getNextSequenceNumber(Order order) {
        loadAllLineItemsFor(order);
        Iterator it = order.getItems().iterator();
        LineItem candidate = (LineItem) it.next();
        while (it.hasNext()) {
            LineItem thisItem = (LineItem) it.next();
            if (thisItem.getKey() == null) continue;
            if (sequenceNumber(thisItem) > sequenceNumber(candidate)) candidate = thisItem;
        }
        return new Long(sequenceNumber(candidate) + 1);
    }
    private static long sequenceNumber(LineItem li) {
        return sequenceNumber(li.getKey());
    }
    // 由於未儲存null 鍵值，比較器（comparator）在這裡無法正常工作
    protected String keyTableRow() {
        throw new UnsupportedOperationException();
    }