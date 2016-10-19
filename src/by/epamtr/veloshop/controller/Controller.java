package by.epamtr.veloshop.controller;

import by.epamtr.veloshop.bean.Request;
import by.epamtr.veloshop.bean.Response;
import by.epamtr.veloshop.command.Command;
import by.epamtr.veloshop.command.CommandName;

public class Controller {
	private final CommandProvider provider = new CommandProvider();
	
	public Response doAction(Request request){
		
		CommandName commandName = request.getCommandName();
		Command command = provider.getCommand(commandName);
		Response response = command.execute(request);

		return response;
	}

}
