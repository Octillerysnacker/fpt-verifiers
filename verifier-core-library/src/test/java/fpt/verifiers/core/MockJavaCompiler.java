package fpt.verifiers.core;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Set;

import javax.lang.model.SourceVersion;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;

public class MockJavaCompiler implements JavaCompiler {

    @Override
    public int run(InputStream in, OutputStream out, OutputStream err, String... arguments) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Set<SourceVersion> getSourceVersions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int isSupportedOption(String option) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public CompilationTask getTask(Writer out, JavaFileManager fileManager,
            DiagnosticListener<? super JavaFileObject> diagnosticListener, Iterable<String> options,
            Iterable<String> classes, Iterable<? extends JavaFileObject> compilationUnits) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StandardJavaFileManager getStandardFileManager(DiagnosticListener<? super JavaFileObject> diagnosticListener,
            Locale locale, Charset charset) {
        // TODO Auto-generated method stub
        return null;
    }

}