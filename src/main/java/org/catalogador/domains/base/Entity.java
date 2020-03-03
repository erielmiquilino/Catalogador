package org.catalogador.domains.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
public class Entity {

    private String id;

    private LocalDateTime insertDate;

}
