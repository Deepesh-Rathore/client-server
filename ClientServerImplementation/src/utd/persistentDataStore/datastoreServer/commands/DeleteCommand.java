package utd.persistentDataStore.datastoreServer.commands;

import java.io.IOException;

import org.apache.log4j.Logger;

import utd.persistentDataStore.utils.FileUtil;
import utd.persistentDataStore.utils.ServerException;
import utd.persistentDataStore.utils.StreamUtil;

public class DeleteCommand extends ServerCommand{
	private static Logger logger = Logger.getLogger(DeleteCommand.class);

	@Override
	public void run() throws IOException, ServerException {
		String name = StreamUtil.readLine(inputStream);
		logger.debug("inMessage: " + name);
		FileUtil.deleteData(name);
		
		String outMessage = "ok" + "\n";
		StreamUtil.writeLine(outMessage, outputStream);
		logger.debug("Finished writing message");
		
	}

	
}
