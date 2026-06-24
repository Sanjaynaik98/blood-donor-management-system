package com.bdms.common.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
}
