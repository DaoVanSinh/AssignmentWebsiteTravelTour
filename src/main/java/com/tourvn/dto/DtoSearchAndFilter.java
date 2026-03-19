package com.tourvn.dto;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSearchAndFilter {
    String keyword;


@Min(value=0)
    Double minPrice;


@Max(value=1000000000)
    Double maxPrice;



@Min(value = 1)
@Max(value = 31)
    Integer days;
}
