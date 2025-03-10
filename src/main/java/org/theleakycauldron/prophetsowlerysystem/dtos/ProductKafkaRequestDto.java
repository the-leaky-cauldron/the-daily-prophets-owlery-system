package org.theleakycauldron.prophetsowlerysystem.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductKafkaRequestDto {
    
    private String userId;
    private String productId;
    private String name;

}
