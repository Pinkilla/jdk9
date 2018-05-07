package pbt.trys;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;
import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class Http2Tests {

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient
                    .newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpRequest request = HttpRequest
                    .newBuilder(new URI("https://pit.namok.be"))
                    .GET()
                    .build();
            Path tempFile = Files.createTempFile("http2-test", ".html");
            //HttpResponse<String> response = client
            //        .send(request, HttpResponse.BodyHandler.asString());
            //HttpResponse<Path> response = client
            //        .send(request, HttpResponse.BodyHandler.asFile(tempFile));

            CompletableFuture<HttpResponse<Path>> futureResponse = client
                    .sendAsync(request,
                            HttpResponse.BodyHandler.asFile(tempFile))
                    .orTimeout(2000, TimeUnit.MILLISECONDS)
                    .whenComplete((r, e)
                            -> System.out.printf("Callback status %d %s\n",
                            r.statusCode(),
                            r.body()))
                    .exceptionally((e) -> {
                        System.out.printf("Exceptionally %s\n", e.getClass());
                        return null;
                    });
            futureResponse.join();

        } catch (IOException
                | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

}
