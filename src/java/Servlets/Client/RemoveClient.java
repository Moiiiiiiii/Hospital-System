package Servlets.Client;

import Controller.ClientController;
import Model.Client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;

/**
 *
 * @author Eng Eslam khder
 */
public class RemoveClient extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String password = request.getParameter("password");
        
        if (password.isEmpty()) {
            response.getWriter().print("password");
        } else {
            SessionFactory session = (SessionFactory) request.getServletContext().getAttribute("factory");
            Client c = (Client)request.getSession().getAttribute("client");
            Client client = new Client();
            client.setCode(c.getCode());
            client.setPassword(password);
            ClientController cc = new ClientController();
            client = cc.IsExist(client, session);
            
            if(client != null){
                cc.removeClient(client, session);
                request.getSession().removeAttribute("client");
                response.getWriter().print("success");
            } else {
                response.getWriter().print("password");
            }
        }
    }
}