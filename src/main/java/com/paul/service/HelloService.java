package com.paul.service;

import com.paul.grpc.HelloRequest;
import com.paul.grpc.HelloResponse;
import com.paul.grpc.HelloServiceGrpc.HelloServiceImplBase;

import io.grpc.stub.StreamObserver;

public class HelloService extends HelloServiceImplBase{

	@Override
	public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) 
	{
		System.out.println("Inside hello");

		String firstName = request.getFirstName();
		String lastName = request.getLastName();
		
		// GRPC uses builders to construct objects
		HelloResponse.Builder response = HelloResponse.newBuilder();
		
		response.setGreeting("hello" + firstName + " " + lastName);
		
		// Once you've constructed the response message, you have to wrap it in the responseObserver to send back to the client. 
		
		// Send the data
		responseObserver.onNext(response.build());
		
		// Close the connection	
		responseObserver.onCompleted();
	}


}
