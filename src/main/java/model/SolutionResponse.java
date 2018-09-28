package model;

public class SolutionResponse {
    private String solution;
    private String error;
    private String completeFunction;
    private String message;

    public SolutionResponse() {
    }

    public SolutionResponse(String message) {
        this.message = message;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCompleteFunction() {
        return completeFunction;
    }

    public void setCompleteFunction(String completeFunction) {
        this.completeFunction = completeFunction;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
