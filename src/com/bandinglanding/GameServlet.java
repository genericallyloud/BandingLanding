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
public class GameServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
    	ObjectifySetup.register();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		UserService userService = UserServiceFactory.getUserService();
		String path = request.getPathInfo();
		response.setContentType("text/html");
        response.getWriter().println("<html><head></head><body>path: " + path + "</body></html>");
	}
}
