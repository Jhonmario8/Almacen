package com.example.onix.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentDto {

    @NotBlank(message = "{comment.cannot_be_blank}")
    private String comment;


}
