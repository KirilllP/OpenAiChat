package com.example.demo;

public interface ServerEvents {
    String MESSAGE_CREATED = "message:created";
    String MESSAGE_UPDATED = "message:updated";//not mvp
    String MESSAGE_DELETED = "message:deleted";//not mvp
    String THREAD_CREATED = "thread:created";
    String THREAD_UPDATED = "thread:updated";//not mvp
    String THREAD_DELETED = "thread:deleted";
}
