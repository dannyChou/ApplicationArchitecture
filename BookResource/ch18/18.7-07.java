class Money...

    public int hashCode() {
        return (int) (amount ^ (amount >>> 32));
    }