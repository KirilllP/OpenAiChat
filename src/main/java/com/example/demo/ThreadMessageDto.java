package com.example.demo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ThreadMessageDto {
    private String threadMessageId;
    private String threadId;
    private String threadFrom;
    private String messageType;
    private String creationTime;
    private String content;
}
