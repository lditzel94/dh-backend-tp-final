package com.digitalhouse.tpfinal.shared.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "ADDRESS" )
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "address_id" )
    private Long id;

    private String street;

    private Integer number;


    public Address toDomain() {
        return Address.builder()
                      .street( street )
                      .number( number )
                      .build();
    }

    public static AddressEntity from( Address address ) {
        return new AddressEntity(
                null,
                address.street(),
                address.number()
        );
    }
}
