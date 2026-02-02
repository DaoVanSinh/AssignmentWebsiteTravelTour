package com.tourvn.DTO;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSearchAndFilter {
    String keyword;


@Min(value=0,message="Số tiền tối thiểu không được âm")
    Double minPrice;


@Max(value=1000000000,message="Số tiền quá lớn")
    Double maxPrice;



@Min(value = 1, message = "Số ngày tối thiểu là 1")
@Max(value = 31, message = "Số ngày tối đa là 31")
    Integer days;
}
