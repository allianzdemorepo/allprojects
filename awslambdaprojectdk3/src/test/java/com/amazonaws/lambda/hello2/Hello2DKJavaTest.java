package com.amazonaws.lambda.hello2;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaAsyncClient;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory.Builder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactoryConfig;
import com.amazonaws.services.lambda.model.FunctionConfiguration;
import com.amazonaws.services.lambda.model.ListFunctionsResult;




public class Hello2DKJavaTest {

    private static String input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = "Dinesh";
    }

    @Test
    public void testHello2() {
    	
    	Builder builder = LambdaInvokerFactory. builder();
    	
    	ClientConfiguration clientConfiguration = new ClientConfiguration();
    	AWSLambdaClientBuilder defaultClient = AWSLambdaClientBuilder.standard().withRegion("US_EAST_2");
    	System.out.println(defaultClient.getRegion());
    	AWSLambda awsLambda = defaultClient.build();
    	
    	ListFunctionsResult listFunctions = awsLambda.listFunctions();
    	List<FunctionConfiguration> functions = listFunctions.getFunctions();
    	for(Object ob: functions) {
    		System.out.println(ob);
    	}
	
    	final HelloLambdaService hello2Service = builder.build (HelloLambdaService.class);
    	String output = hello2Service.handleRequest(input);

        // TODO: validate output here if needed.
        Assert.assertTrue(output.contains("Dinesh"));
    }
}
