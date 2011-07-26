package com.bandinglanding;

import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class BandingLandingServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		UserService userService = UserServiceFactory.getUserService();

        String thisURL = request.getRequestURI();

        response.setContentType("text/html");
        if (request.getUserPrincipal() != null) {
        	User currUser = userService.getCurrentUser();
        	if(UserWhitelist.isListed(currUser)){
                response.getWriter().println("<p>Hello, " +
                        request.getUserPrincipal().getName() +
                        "!  You are totally allowed in the club. You can <a href=\"" +
                        userService.createLogoutURL(thisURL) +
                        "\">sign out</a> if you want.</p>");
        	}else{
                response.getWriter().println("<p>Hello, " +
                        request.getUserPrincipal().getName() +
                        "!  You are not in the club! You can <a href=\"" +
                        userService.createLogoutURL(thisURL) +
                        "\">sign out</a> to try as someone else.</p>");
        	}
        } else {
            response.getWriter().println("<p>Please <a href=\"" +
                                         userService.createLoginURL(thisURL) +
                                         "\">sign in</a>.</p>");
        }
	}
}
