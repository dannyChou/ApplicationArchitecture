class ControllerServlet extends HttpServlet...

    protected void doGet(HttpServletRequest req, HttpServletResponse rsp)
                    throws ServletException, IOException {
        try {
            String cmdName = req.getParameter("command");
            Command cmd = getCommand(cmdName);
            cmd.init(req, rsp);
            cmd.process();
        } catch (Exception e) {
            writeException(e, rsp.getWriter());
        }
    }
    private Command getCommand(String name) {
        try {
            String className = (String) commands.get(name);
            Command cmd = (Command) Class.forName(className).newInstance();
            return new TransactionalCommand(cmd);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException("unable to create command object for " + name);
        }
    }

class EditCustomerCommand implements Command...

    public void process() throws Exception {
        startNewBusinessTransaction();
        Long customerId = new Long(getReq().getParameter("customer_id"));
        ExclusiveReadLockManager.INSTANCE.acquireLock(
            customerId, AppSessionManager.getSession().getId());
        Mapper customerMapper = MapperRegistry.INSTANCE.getMapper(Customer.class);
        Customer customer = (Customer) customerMapper.find(customerId);
        getReq().getSession().setAttribute("customer", customer);
        forward("/editCustomer.jsp");
    }

class SaveCustomerCommand implements Command...

    public void process() throws Exception {
        continueBusinessTransaction();
        Customer customer = (Customer) getReq().getSession().getAttribute("customer");
        String name = getReq().getParameter("customerName");
        customer.setName(name);
        Mapper customerMapper = MapperRegistry.INSTANCE.getMapper(Customer.class);
        customerMapper.update(customer);
        ExclusiveReadLockManager.INSTANCE.releaseLock(customer.getId(),
                            AppSessionManager.getSession().getId());
        forward("/customerSaved.jsp");
    }