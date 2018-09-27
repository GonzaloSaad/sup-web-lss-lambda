package function;

import model.SolutionRequest;
import model.SolutionResponse;
import solver.SolverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class LeastSquareSolverFunction implements Function<SolutionRequest, SolutionResponse> {

    private static final Logger logger = LoggerFactory.getLogger(LeastSquareSolverFunction.class);

    @Override
    public SolutionResponse apply(SolutionRequest solutionRequest) {
        String x = solutionRequest.getX();
        String y = solutionRequest.getY();
        String function = solutionRequest.getFunction();
        String method = solutionRequest.getMethod();
        String pivot = solutionRequest.getPivot();

        return createSolutionResponseFromService(x, y, function, method, pivot);

    }

    private SolutionResponse createSolutionResponseFromService(String x, String y, String function, String method, String pivot) {
        SolverService service = SolverService.createSolverService(x,y,function,method,pivot);

        SolutionResponse response = new SolutionResponse();
        response.setCompleteFunction(service.getCompleteFunction());
        response.setError(Double.toString(service.getError()));
        response.setSolution(service.getSolution());
        logger.info(response.getSolution());
        return response;
    }


}
