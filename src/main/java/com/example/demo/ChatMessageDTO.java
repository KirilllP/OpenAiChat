package com.example.demo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ChatMessageDTO{
    String message;
    String from;
}
