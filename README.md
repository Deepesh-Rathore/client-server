# client-server
Client Server Protocol Implementation in Java


In this project I have implemented a client-server system that communicates over TCP/IP sockets. 

The server will store, retrieve, delete, & list named data sets on the server. Each data set is associated with a string name provided in the client’s request to the server. The server is responsible for storing this data in a persistent fashion for later retrieval. Data is persistently stored in files in a directory under the project directory.

This projects uses TCP/IP sockets to implement communications between a client and server, using the Java network library class ServerSocket.

# Testing

It also includes Junit test cases to test complete functionality of the implementation.
