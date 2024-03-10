package com.teste.pratico.vaga;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.springframework.stereotype.Component;

@Component
@Data
@ViewScoped
public class VagaBean {

    private final VagaService service;
    private Vaga vagaSelecionada = new Vaga();
    private boolean isValido;

    public VagaBean(VagaService service) {
        this.service = service;
    }

    public void salvarVaga() {
        if (validarDatas()) {
            Vaga vaga = mapearVaga();

            service.salvarVaga(vaga);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vagas criadas com sucesso!", ""));
            limparFormulario();
        }
    }
    private Vaga mapearVaga() {
        Vaga vaga = new Vaga();
        vaga.setInicio(vagaSelecionada.getInicio());
        vaga.setFim(vagaSelecionada.getFim());
        vaga.setQuantidade(vagaSelecionada.getQuantidade());
        return vaga;
    }

    private boolean validarDatas() {
        if(vagaSelecionada.getFim().isBefore(vagaSelecionada.getInicio())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A data final precisa ser maior que a data inicial.", ""));
            isValido = false;
        } else {
            isValido = true;
        }
        return isValido;
    }

    private void limparFormulario(){
        PrimeFaces.current().executeScript("document.getElementById('form:dataInicio_input').value = '';");
        PrimeFaces.current().executeScript("document.getElementById('form:dataFim_input').value = '';");
        vagaSelecionada.setQuantidade(null);    }
}
