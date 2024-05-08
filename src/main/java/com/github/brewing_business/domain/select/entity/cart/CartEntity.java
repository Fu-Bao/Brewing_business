package com.github.brewing_business.domain.select.entity.cart;

import com.github.brewing_business.domain.product.entity.ProductEntity;
import com.github.brewing_business.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cart")
public class CartEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_idx")
    private ProductEntity product;

    private Integer price;

    private Integer count;
}
