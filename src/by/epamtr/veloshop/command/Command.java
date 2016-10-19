package by.epamtr.veloshop.command;

import by.epamtr.veloshop.bean.Request;
import by.epamtr.veloshop.bean.Response;

public interface Command {
	
	Response execute(Request request);
}
