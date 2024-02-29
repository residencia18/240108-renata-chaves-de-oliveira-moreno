package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private double valor;
    
    @Temporal(TemporalType.DATE)
    private Date data;
    
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // Construtores, getters e setters
}

