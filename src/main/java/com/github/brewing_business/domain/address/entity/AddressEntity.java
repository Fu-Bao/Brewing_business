package com.github.brewing_business.domain.address.entity;

import com.github.brewing_business.domain.address.dto.AddressDto;
import com.github.brewing_business.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "address")
public class AddressEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    private String address1;

    private String address2;

    private String zipcode;

    @Column(name = "phone_number")
    private String phoneNum;

    private boolean isDefault;

    public static AddressEntity toEntity(User user, AddressDto addressDto) {
        return AddressEntity.builder()
                .user(user)
                .address1(addressDto.getAddress1())
                .address2(addressDto.getAddress2())
                .phoneNum(addressDto.getPhone_number())
                .isDefault(addressDto.is_default())
                .build();
    }

    public void update(AddressDto addressDto) {
        address1 = addressDto.getAddress1();
        address2 = addressDto.getAddress2();
        zipcode = addressDto.getZipcode();
        phoneNum = addressDto.getPhone_number();
        isDefault = addressDto.is_default();
    }
}
