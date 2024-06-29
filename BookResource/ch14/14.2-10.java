class HelperGetTag extends HelperTag...

    private String propertyName;
    public void setProperty(String propertyName) {
        this.propertyName = propertyName;
    }
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print(getProperty(propertyName));
        } catch (IOException e) {
            throw new JspException("unable to print to writer");
        }
        return SKIP_BODY;
    }

class HelperTag...

    protected Object getProperty(String property) throws JspException {
        Object helper = getHelper();
        try {
            final Method getter = helper.getClass().getMethod(gettingMethod(property), null);
            return getter.invoke(helper, null);
        } catch (Exception e) {
            throw new JspException
                ("Unable to invoke " + gettingMethod(property) + " - " + e.getMessage());
        }
    }
    private Object getHelper() throws JspException {
        Object helper = pageContext.getAttribute(HELPER);
        if (helper == null) throw new JspException("Helper not found.");
        return helper;
    }
    private String gettingMethod(String property) {
        String methodName = "get" + property.substring(0,1).toUpperCase() +
                property.substring(1);
        return methodName;
    }