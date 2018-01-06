package utd.persistentDataStore.datastoreServer.commands;

import java.io.IOException;

import org.apache.log4j.Logger;

import utd.persistentDataStore.utils.FileUtil;
import utd.persistentDataStore.utils.ServerException;
import utd.persistentDataStore.utils.StreamUtil;

public class WriteCommand extends ServerCommand{
	private static Logger logger = Logger.getLogger(WriteCommand.class);
	
	@Override
	public void run() throws IOException, ServerException
	{
		String name = StreamUtil.readLine(inputStream);
		logger.debug("inMessage: " + name);
		
		int size = Integer.parseInt(StreamUtil.readLine(inputStream));
		byte[] dataToWrite = StreamUtil.readData(size, inputStream);
		FileUtil.writeData(name, dataToWrite);
		
		StreamUtil.writeLine("ok", outputStream);
		logger.debug("Finished writing message");
	}

}
