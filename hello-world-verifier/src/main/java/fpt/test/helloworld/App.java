package fpt.test.helloworld;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import com.google.gson.Gson;

import fpt.test.helloworld.FPTDiagnostic.DiagnosticKind;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Gson gson = new Gson();
        PrintStream appOut = System.out;
        try {
            String userFolder = args[0];
            String projectFolder = args[1];
            Path compiledPath = Paths.get(userFolder, "compiled");

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            final DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
            try (final StandardJavaFileManager manager = compiler.getStandardFileManager(diagnostics, null, null)) {

                final File file = new File(Paths.get(projectFolder, "HelloWorld.java").toUri());

                final Iterable<? extends JavaFileObject> sources = manager
                        .getJavaFileObjectsFromFiles(Arrays.asList(file));

                final CompilationTask task = compiler.getTask(null, manager, diagnostics,
                        Arrays.asList("-d", compiledPath.toString()), null, sources);
                task.call();
            }

            URLClassLoader loader = new URLClassLoader(new URL[] { compiledPath.toUri().toURL() });
            Class<?> helloWorldClass = loader.loadClass("HelloWorld");
            // Class<?> helloWorldClass = HelloWorld.class;

            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            PrintStream testOut = new PrintStream(outStream);
            System.setOut(testOut);
            Method method = helloWorldClass.getMethod("main", String[].class);
            method.invoke(null, (Object) new String[]{});
            System.setOut(appOut);
            loader.close();

            if (outStream.toString().trim().equalsIgnoreCase("hello world!")) {
                System.out.println(gson.toJson(new VerifierResult(true, new FPTDiagnostic[] {})));
            } else {
                System.out.println(gson.toJson(new VerifierResult(false,
                        new FPTDiagnostic[] { new FPTDiagnostic(
                                "Output was '" + outStream.toString().trim() + "' instead of 'Hello world!'",
                                DiagnosticKind.Error, new FileLocation(0, 0), new FileLocation(0, 0)) })));
            }
        } catch (Exception e) {
            System.setOut(appOut);
            System.out
                    .println(gson.toJson(new VerifierResult(false, new FPTDiagnostic[] { new FPTDiagnostic(e.toString(),
                            FPTDiagnostic.DiagnosticKind.Error, new FileLocation(0, 0), new FileLocation(0, 0)) })));
        }
    }
}
