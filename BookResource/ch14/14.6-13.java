class TableTag...

    private void printCells(Object obj) throws IOException, JspException {
        JspWriter out = pageContext.getOut();
        for (int i = 0; i < getColumnList().length; i++) {
            out.print("<td>");
            out.print(getProperty(obj, getColumnList()[i]));
            out.print("</td>");
        }
    }
    private String[] getColumnList() {
        StringTokenizer tk = new StringTokenizer(columns, ", ");
        String[] result = new String[tk.countTokens()];
        for (int i = 0; tk.hasMoreTokens(); i++)
            result[i] = tk.nextToken();
        return result;
    }