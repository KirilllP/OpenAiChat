package com.example.demo;

public interface ClientEvents {
    String MESSAGE_GPT_SEND = "message:gpt:send";
    String MESSAGE_CREATE = "message:create";//not mvp
    String THREADS = "threads";
    String THREAD_UPDATE = "thread:update";//not mvp
    String THREAD_DELETE = "thread:delete";
    String THREAD_MESSAGES = "thread:messages";
}
