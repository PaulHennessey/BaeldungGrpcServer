import java.io.IOException;

import com.paul.service.HelloService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {

	public static void main(String args[]) throws IOException, InterruptedException
	{
		// Create server and add new service
		Server server = ServerBuilder.forPort(9090).addService(new HelloService()).build();
		
		server.start();
		
		System.out.println("Server started at " + server.getPort());
		
		server.awaitTermination();
	}
}
