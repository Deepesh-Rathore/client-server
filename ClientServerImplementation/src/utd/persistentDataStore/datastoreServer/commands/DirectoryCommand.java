package utd.persistentDataStore.datastoreServer.commands;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import utd.persistentDataStore.utils.FileUtil;
import utd.persistentDataStore.utils.ServerException;
import utd.persistentDataStore.utils.StreamUtil;

public class DirectoryCommand extends ServerCommand{
	private static Logger logger = Logger.getLogger(DirectoryCommand.class);
	
	@Override
	public void run() throws IOException, ServerException {
		List<String> list = FileUtil.directory();
		
		StreamUtil.writeLine("ok", outputStream);
		StreamUtil.writeLine(list.size()+"", outputStream);
		
		for(String s : list){
			StreamUtil.writeLine(s, outputStream);
		}
		
		logger.debug("Finished writing message");
	}
}
