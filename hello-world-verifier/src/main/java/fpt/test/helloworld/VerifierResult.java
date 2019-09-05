package fpt.test.helloworld;

public class VerifierResult {
    public final boolean Success;
    public final FPTDiagnostic[] Diagnostics;
    public VerifierResult(boolean success, FPTDiagnostic[] diagnostics){
        Success = success;
        Diagnostics = diagnostics;
    }
}