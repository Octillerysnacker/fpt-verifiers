package fpt.test.helloworld;

public class FPTDiagnostic{
    public final String Message;
    public enum DiagnosticKind {Error, Warning, Info};
    public final DiagnosticKind Kind;
    public final FileLocation Start;
    public final FileLocation End;
    public FPTDiagnostic(String message, DiagnosticKind kind, FileLocation start, FileLocation end){
        Message = message;
        Kind = kind;
        Start = start;
        End = end;
    }
}