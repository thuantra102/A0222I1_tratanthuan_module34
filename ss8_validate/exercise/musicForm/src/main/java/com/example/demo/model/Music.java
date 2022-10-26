package com.example.demo.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Music {
    @NotBlank(message = "tên bài hát không được để trống")
    @Length(max = 8, message = "tên bài hát vượt quá ký tự cho phép")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "tên bài hát không có ký tự đặc biệt")
    private String musicName;

    @NotBlank(message = "tên nghệ sĩ không được để trống")
    @Length(max = 10, message = "tên nghệ sĩ vượt quá ký tự cho phép")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "tên nghệ sĩ không có ký tự đặc biệt")
    private String singer;

    @NotBlank(message = "tên thể loại không được để trống")
    @Length(max = 10, message = "tên thể loại vượt quá ký tự cho phép")
    @Pattern(regexp = "^[a-zA-Z0-9 ,]+$", message = "tên thể loại không có ký tự đặc biệt")
    private String musicType;
}
