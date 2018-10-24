package com.service01;

import org.junit.Test;
import org.restlet.Response;
import org.restlet.data.*;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by aalokr on 3/10/18.
 */
public class ParkingServiceTest {

    @Test
    public void checkParkIn() throws ExecutionException, InterruptedException {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                String str = "{\"number\":\"ka51er1111\", \"type\":\"TwoWheeler\"}";
                ClientResource resource=new ClientResource("http://localhost:8080/parkService/in");
                Representation response=resource.post(new JsonRepresentation(str), MediaType.APPLICATION_JSON);

                return Thread.currentThread().getName()+" : "+response.getText();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(10);
        List<Future> results = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            results.add(es.submit(callable));
        }

        for (Future result : results)
            System.out.println(result.get());
    }
}
