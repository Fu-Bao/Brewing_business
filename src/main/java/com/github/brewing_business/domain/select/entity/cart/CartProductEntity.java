package com.github.brewing_business.domain.select.entity.cart;

import com.github.brewing_business.domain.product.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cart_product")
public class CartProductEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_idx")
    private CartEntity cart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_idx")
    private ProductEntity product;

    private Integer price;

    private Integer count;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime createAt;

    public static CartProductEntity addFromCartProduct(CartEntity cart, ProductEntity product, Integer price, Integer count) {
        return CartProductEntity.builder()
                .cart(cart)
                .product(product)
                .price(price)
                .count(count)
                .build();
    }

    public void addCount(Integer count){
        this.count += count;
    }

}
