class FieldTag...

    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print("<P>" + label + ": <B>");
        } catch (IOException e) {
            throw new JspException("unable to print start");
        }
        return EVAL_BODY_INCLUDE;
    }
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().print("</B></P>");
        } catch (IOException e) {
            throw new JspException("how are checked exceptions helping me here?");
        }
        return EVAL_PAGE;
    }