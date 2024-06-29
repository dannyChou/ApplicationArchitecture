class UnknownCommand...

    public void process() throws ServletException, IOException {
        forward("/unknown.jsp");
    }