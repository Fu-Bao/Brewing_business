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

    private String receiver;

    @Column(name = "rec_phone")
    private String recPhone;

    @Column(name = "address_name")
    private String addressName;

    private String address;

    @Column(name = "address_detail")
    private String addressDetail;

    private String zipcode;

    @Column(name = "is_default")
    private Boolean isDefault;

    public static AddressEntity toEntity(User user, AddressDto addressDto) {
        return AddressEntity.builder()
                .user(user)
                .receiver(addressDto.getReceiver())
                .addressName(addressDto.getAddressName())
                .address(addressDto.getAddress())
                .addressDetail(addressDto.getAddressDetail())
                .recPhone(addressDto.getRecPhone())
                .zipcode(addressDto.getZipcode())
                .isDefault(addressDto.getIsDefault())
                .build();
    }

    public void update(AddressDto addressDto) {
        this.receiver = addressDto.getReceiver();
        this.addressName = addressDto.getAddressName();
        this.address = addressDto.getAddress();
        this.addressDetail = addressDto.getAddressDetail();
        this.recPhone = addressDto.getRecPhone();
        this.zipcode = addressDto.getZipcode();
        this.isDefault = addressDto.getIsDefault();
    }
}
