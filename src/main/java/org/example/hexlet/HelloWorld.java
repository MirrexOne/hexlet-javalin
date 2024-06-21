package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
           config.bundledPlugins.enableDevLogging();
        });

        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/welcome", ctx -> ctx.result("Hello Mirrex"));

        app.get("/users", context -> context.result("GET /users"));
        app.post("/users", context -> context.result("POST /users"));

        app.get("/credential", ctx -> {
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        });

        app.get("/hello", context -> {
            String name = context.queryParam("name");
            if (name == null) {
                context.result("Hello, World!");
            } else {
                context.result("Hello, " + name + "!");
            }
        });

        app.start(7070);
    }
}
