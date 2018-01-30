package com.thegongoliers.scoutoliers.frc2018;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jetty.server.Authentication.User;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class WebConfig {
	
	public WebConfig() {
		staticFileLocation("/public");
		setupRoutes();
		
		get("/", (req, res) -> {
			User user = getAuthenticatedUser(req);
			Map<String, Object> map = new HashMap<>();
			map.put("pageTitle", "Timeline");
			map.put("user", user);
			List<Message> messages = service.getUserFullTimelineMessages(user);
			map.put("messages", messages);
			return new ModelAndView(map, "timeline.ftl");
		}, new FreeMarkerEngine());
	}
	
}