package projeto.padraostate.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import projeto.padraostate.state.State;
import projeto.padraostate.states.PedidoNovo;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Pedido{

    private State state = new PedidoNovo();
    private Integer id;

}
