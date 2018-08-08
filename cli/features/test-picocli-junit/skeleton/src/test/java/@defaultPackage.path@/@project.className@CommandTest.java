package @defaultPackage@;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.env.Environment;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import static org.junit.Assert.*;

public class @project.className@CommandTest {

    @Test
    public void testWithCommandLineOption() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        try (ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)) {
            String[] args = new String[] { "-v" };
            PicocliRunner.run(@project.className@Command.class, ctx, args);

            // @project.name@
            assertTrue(baos.toString(), baos.toString().contains("Hi!"));
        }
    }
}
