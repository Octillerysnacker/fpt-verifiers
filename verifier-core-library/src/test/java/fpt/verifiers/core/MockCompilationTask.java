package fpt.verifiers.core;

import java.util.Locale;

import javax.annotation.processing.Processor;
import javax.tools.JavaCompiler.CompilationTask;

public class MockCompilationTask implements CompilationTask {

    @Override
    public void addModules(Iterable<String> moduleNames) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setProcessors(Iterable<? extends Processor> processors) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLocale(Locale locale) {
        // TODO Auto-generated method stub

    }

    @Override
    public Boolean call() {
        // TODO Auto-generated method stub
        return null;
    }
    
}