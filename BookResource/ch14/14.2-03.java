class ActionServlet...

    protected void forward(String target,
                        HttpServletRequest request,
                        HttpServletResponse response)
        throws IOException, ServletException
    {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }