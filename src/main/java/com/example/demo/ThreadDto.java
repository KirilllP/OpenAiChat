package com.example.demo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ThreadDto {
    String threadId;
    String threadName;
    String threadTabs;
    String lastUpdated;
}
