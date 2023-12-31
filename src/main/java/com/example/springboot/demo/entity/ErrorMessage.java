package com.example.springboot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage
{
    private HttpStatus status;
    private String message;
}
