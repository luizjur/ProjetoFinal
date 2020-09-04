function preencheResposta(resposta) {
    // Para debug, envia resposta para console do java (no browser: Inspect - Console)
    //console.log(resposta)
    // Monta o cabeçalho da tabela

    /*
                                    <select class="form-control" id="txtPDV">
                                        <option value="1">PDV 1</option>
                                        <option value="2">PDV 2</option>
                                        <option value="3">PDV 3</option>
                                    </select>
    */

    let tabelaPedidos = '<table class = "table table-sm"><tr>' +
        '<th>Solicitante</th>' +
        '<th>E-mail</th>' +
        '<th>Data</th>' +
        '<th>Status</th>' +
        '<th>Alterar</th></tr>';
    // Adiciona os elementos da tabela -> resposta
    for (let index = 0; index < resposta.length; index++) {
        tabelaPedidos = tabelaPedidos + `<tr><td>${resposta[index].solicitante.nome}</td>
                                             <td>${resposta[index].solicitante.email}</td>
                                             <td>${resposta[index].data}</td>
                                             <td>${resposta[index].status}</td>
                    <td><button class="btn btn-sm btn-success" onclick="alterarStatus('A',${resposta[index].numPedido})">Ap</button>
                        <button class="btn btn-sm btn-warning" onclick="alterarStatus('P',${resposta[index].numPedido})">Pe</button>
                        <button class="btn btn-sm btn-danger" onclick="alterarStatus('C',${resposta[index].numPedido})">Ca</button></td></tr>`
    }

    tabelaPedidos = tabelaPedidos + '</table>';
    document.getElementById("tableResposta").innerHTML = tabelaPedidos;

}


function solicitar(event) {
    event.preventDefault();
    let tecnico = document.getElementById('txtTecnico').value;
    let operadora = document.getElementById('txtOperadora').value;
    let telefone = document.getElementById('txtTelefone').value;
    let doc = document.getElementById('txtDoc').value;
    let pdvSelect = document.getElementById("txtPDV");
    let pdvValue = pdvSelect[pdvSelect.selectedIndex].value;
    let data = document.getElementById('txtData').value;
    let hora = document.getElementById('txtHora').value;

    let msgPedido = {
        nomeTecnico: tecnico,
        operadora: operadora,
        telefone: telefone,
        doc: doc,
        data: new Date(data).toLocaleDateString('pt-BR', { timeZone: 'UTC' }),
        hora: hora + ":00",
        pdv: { id: pdvValue }
    }

    let cabecalho = {
        method: 'POST',
        body: JSON.stringify(msgPedido),
        headers: {
            'Content-type': 'application/json'
        }
    }

    fetch('http://localhost:8080/solicitacao/nova', cabecalho)
        .then(res => tratarResposta(res));

}

function tratarResposta(res){
 
    if(res){
        
        document.getElementById('txtTecnico').value = "";
        document.getElementById('txtOperadora').value = "";
        document.getElementById('txtTelefone').value = "";
        document.getElementById('txtDoc').value = "";
        document.getElementById("txtPDV").value = "";     
        document.getElementById('txtData').value = "";
        document.getElementById('txtHora').value = "";

        alert("Solicitação Incluida com Sucesso");
    }else{
        alert("Erro na Inclusão, verifique os campos");
    }
 
}





