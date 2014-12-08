package com.mycompany.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Calculator {
    private static final Map <String, Operation> OPERATIONS = new HashMap<>();
    static {
        OPERATIONS.put("+", new Operation() {
            @Override
            public Double perform(Double a, Double b) {
                return a + b;
            }

            @Override
            public String getOperationSign() {
                return "+";
            }
        });
        OPERATIONS.put("-", new Operation() {
            @Override
            public Double perform(Double a, Double b) {
                return a - b;
            }

            @Override
            public String getOperationSign() {
                return "-";
            }
        });
    }

    public String[] getOperations() {
        Set<String> operationSet = OPERATIONS.keySet();
        return operationSet.toArray(new String[OPERATIONS.size()]);
    }

    public Double perform(String operation, Double a, Double b) throws UnknownOperationException {
        if (null!= OPERATIONS.get(operation)){
            return OPERATIONS.get(operation).perform(a,b);
        }else{
            throw new UnknownOperationException("Unsupported operation sign: \""+operation+"\"");
        }
    }
}
