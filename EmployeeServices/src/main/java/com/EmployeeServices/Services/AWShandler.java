package com.EmployeeServices.Services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class AWShandler implements RequestStreamHandler{



	   private static Logger logger = LoggerFactory.getLogger(AWShandler.class);



	   public static final SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;



	   static {
	        try {
	            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(EmployeeServicesApplication .class);
	        } catch (ContainerInitializationException e) {
	            String errMsg = "Could not initialize Spring Boot application";
	            logger.error(errMsg);
	            throw new RuntimeException(errMsg, e);
	        }
	    }



	   @Override
	    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
	        handler.proxyStream(inputStream, outputStream, context);
	        outputStream.close();
	    }
	}