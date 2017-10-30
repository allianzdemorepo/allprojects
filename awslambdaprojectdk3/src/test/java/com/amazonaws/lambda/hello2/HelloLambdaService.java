package com.amazonaws.lambda.hello2;

import com.amazonaws.services.lambda.invoke.LambdaFunction;

public interface HelloLambdaService {
  @LambdaFunction(functionName="Hello2Function")
  String handleRequest(String input);
}
