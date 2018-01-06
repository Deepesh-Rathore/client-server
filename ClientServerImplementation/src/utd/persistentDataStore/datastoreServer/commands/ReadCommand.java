package utd.persistentDataStore.datastoreServer.commands;

import java.io.IOException;

import org.apache.log4j.Logger;

import utd.persistentDataStore.utils.FileUtil;
import utd.persistentDataStore.utils.ServerException;
import utd.persistentDataStore.utils.StreamUtil;

public class ReadCommand extends ServerCommand{
	private static Logger logger = Logger.getLogger(ReadCommand.class);
	
	@Override
	public void run() throws IOException, ServerException
	{
		String name = StreamUtil.readLine(inputStream);
		logger.debug("inMessage: " + name);
		
		byte[] readData = FileUtil.readData(name);
		
		StreamUtil.writeLine("ok", outputStream);
		StreamUtil.writeLine(readData.length+"", outputStream);
		StreamUtil.writeData(readData, outputStream);
		
		logger.debug("Finished writing message");
	}
}
