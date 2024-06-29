class TableTag...

    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.print("<table>");
            Collection coll = (Collection) getPropertyFromAttribute(hostName, collectionName);
            Iterator rows = coll.iterator();
            int rowNumber = 0;
            while (rows.hasNext()) {
                out.print("<tr");
                if ((rowNumber++ % 2) == 0) out.print(" bgcolor = " + HIGHLIGHT_COLOR);
                out.print(">");
                printCells(rows.next());
                out.print("</tr>");
            }
            out.print("</table>");
        } catch (IOException e) {
            throw new JspException("unable to print out");
        }
        return SKIP_BODY;
    }
    private Object getPropertyFromAttribute(String attribute, String property)
        throws JspException
    {
        Object hostObject = pageContext.findAttribute(attribute);
        if (hostObject == null)
            throw new JspException("Attribute " + attribute + " not found.");
        return getProperty(hostObject, property);
    }
    public static final String HIGHLIGHT_COLOR = "'linen'";