package dev.frankmms.selecaofamilias.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Familia {

    private String id;
    private Pessoa pretendente;
    private Pessoa conjugue;
    private List<Pessoa> dependentes = Collections.emptyList();
    private BigDecimal renda;

}
