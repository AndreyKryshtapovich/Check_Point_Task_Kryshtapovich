package by.epamtr.veloshop.controller;

import java.util.HashMap;
import java.util.Map;

import by.epamtr.veloshop.command.Command;
import by.epamtr.veloshop.command.CommandName;
import by.epamtr.veloshop.command.impl.AddProduct;
import by.epamtr.veloshop.command.impl.DeleteProductById;
import by.epamtr.veloshop.command.impl.ShowProductsByCategory;
import by.epamtr.veloshop.command.impl.ShowReport;
import by.epamtr.veloshop.command.impl.UpdateProductById;




class CommandProvider {
	 private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();
	 
	 CommandProvider() {
		commands.put(CommandName.ADD_PRODUCT, new AddProduct());
		commands.put(CommandName.DELETE_PRODUCT_BY_ID, new DeleteProductById());
		commands.put(CommandName.SHOW_PRODUCTS_BY_CATEGORY, new ShowProductsByCategory());
		commands.put(CommandName.UPDATE_PRODUCT_BY_ID, new UpdateProductById());
		commands.put(CommandName.SHOW_REPORT, new ShowReport());
		
		}
	 
		public Command getCommand(CommandName commandName){
			Command command;
			command = commands.get(commandName);
			return command;
		}

}
