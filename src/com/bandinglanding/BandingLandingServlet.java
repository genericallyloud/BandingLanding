package com.bandinglanding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.codehaus.jackson.map.ObjectMapper;

import com.bandinglanding.dao.DeckCardDao;
import com.bandinglanding.dao.DeckDao;
import com.bandinglanding.dto.DeckDto;
import com.bandinglanding.model.Card;
import com.bandinglanding.model.Deck;
import com.bandinglanding.model.DeckCard;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

@SuppressWarnings("serial")
public class BandingLandingServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
    	ObjectifySetup.register();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		UserService userService = UserServiceFactory.getUserService();

        String thisURL = "/";

        if (request.getUserPrincipal() != null) {
        	User currUser = userService.getCurrentUser();
        	if(UserWhitelist.isListed(currUser)){
        		request.setAttribute("signoutUrl", userService.createLogoutURL(thisURL));
        		
        		//grab the user's deck
            	Deck deck = new DeckDao().findOrCreateDefaultByOwner(currUser);
            	DeckDto deckDto = new DeckDto(deck);
        		request.setAttribute("deckDtoJson", deckDto);
        		try {
            		String destination = "/WEB-INF/pages/profile.jsp";
        			request.getRequestDispatcher(destination).forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
        	}else{
                response.setContentType("text/html");
                response.getWriter().println("<p>Hello, " +
                        request.getUserPrincipal().getName() +
                        "!  You are not in the club! You can <a href=\"" +
                        userService.createLogoutURL(thisURL) +
                        "\">sign out</a> to try as someone else.</p>");
        	}
        } else {
            request.setAttribute("signinUrl", userService.createLoginURL(thisURL));
            try {
        		String destination = "/WEB-INF/pages/public.jsp";
    			request.getRequestDispatcher(destination).forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
        }
	}
}
