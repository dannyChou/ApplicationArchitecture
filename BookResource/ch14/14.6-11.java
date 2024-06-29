class TableTag...

    private Object getProperty(Object obj, String property) throws JspException {
        try {
            String methodName = "get" + property.substring(0, 1).toUpperCase() +
                property.substring(1);
            Object result = obj.getClass().getMethod(methodName, null).invoke(obj, null);
            return result;
        } catch (Exception e) {
            throw new JspException("Unable to get property " + property + " from " + obj);
        }
    }