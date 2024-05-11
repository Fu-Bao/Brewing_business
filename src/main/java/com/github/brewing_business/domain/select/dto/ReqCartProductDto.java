package com.github.brewing_business.domain.select.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReqCartProductDto {
    @NotNull(message = "상품아이디는 반드시 입력해야 합니다.")
    private Long product_id;

    @Min(value = 1, message = "최소 1개 이상 주문해야 합니다.")
    private Integer count;
}
