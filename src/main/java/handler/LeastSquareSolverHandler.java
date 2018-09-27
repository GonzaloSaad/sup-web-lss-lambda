package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import function.LeastSquareSolverFunction;
import model.SolutionRequest;
import model.SolutionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class LeastSquareSolverHandler implements RequestHandler<SolutionRequest, SolutionResponse> {

    private static final Logger logger = LoggerFactory.getLogger(LeastSquareSolverHandler.class);

    @Override
    public SolutionResponse handleRequest(SolutionRequest input, Context context) {
        logger.info("In the handler.");
        return callFunction(input);
    }


    private SolutionResponse callFunction(SolutionRequest solutionRequest){
        Function<SolutionRequest, SolutionResponse> function = new LeastSquareSolverFunction();
        return function.apply(solutionRequest);
    }
}
