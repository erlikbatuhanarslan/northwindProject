package kodlama.io.northwindProject.Core.Utilities.Results;

public class ErrorResult extends Result{

    public ErrorResult(){
        super(false);
    }

    public ErrorResult(String message){
        super(false, message);
    }
}
