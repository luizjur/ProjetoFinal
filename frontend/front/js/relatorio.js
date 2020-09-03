
// function são metodos

function validaLogin() {
    let userTxt = localStorage.getItem("userLogged");
    
    // verifica se o usuario esta logado
    if (!userTxt) {
        window.location = "index.html";
    }

    let jsonUser = JSON.parse(userTxt); // transforma o texto em json

    document.getElementById("user").innerHTML = `${jsonUser.nome} ( ${jsonUser.cpf} )`;
    document.getElementById("imgUser").innerHTML = `<img src="${jsonUser.linkFoto}">`;

}

function logout() {
    localStorage.removeItem("userLogged");
    window.location = "index.html";
}

function buscarPorStatus() {
    let statusSelect = document.getElementById("sel_status");
    let statusValue = statusSelect[statusSelect.selectedIndex].value; // obter o valor do status selecionado.

    fetch("http://localhost:8080/pedidos/status/" + statusValue)   // estou mandando para o banco de dados um pedido
    .then(res => res.json())
    .then( result => preencheResposta(result));
}

function preencheResposta(resposta) {

//    console.log(resposta); isto faz aparecer em cosole dentro de inspecionar no chrome

    let tabelaPedidos = '<table class = "table"> <tr> <th>solicitate</th> <th>email</th> <th>data</th> <th>status</th> <th>alterar</th> </tr>';
    // assima estou montando um html e vou carregar em document.getElementById logo abaixo

    for (let index = 0; index < resposta.length; index++) {

        tabelaPedidos = tabelaPedidos + `<tr> <td> ${resposta[index].solicitante.nome} </td>
        <td>  ${resposta[index].solicitante.email}  </td> 
        <td>  ${resposta[index].data}  </td> 
        <td>  ${resposta[index].status}  </td>                                                                          
        <td> <button class="btn btn-sm btn-success" onclick="alterarStatus                                              ('A',${resposta[index].numPedido} )">Ap</button> <button class="btn btn-sm btn-warning" onclick="alterarStatus('P',${resposta[index].numPedido} )">Pe</button> <button class="btn btn-sm btn-danger" onclick="alterarStatus('C', ${resposta[index].numPedido} )">Ca</button> </td> </tr>`;
        
    }

    tabelaPedidos = tabelaPedidos + '</table>';

    document.getElementById("tableResposta").innerHTML = tabelaPedidos;

}

function buscarPorData() {
    let data = document.getElementById("dataPedido").value;

    fetch("http://localhost:8080/pedidos/data?dataagendamento=" + data)
    .then(res => res.json())
    .then( result => preencheResposta(result));

}

function alterarStatus(status, numPedido){  // passo duas alterações como parametro status e numPedido

    let pedidoMsg ={
        numPedido:numPedido,
        status: status
    }

    let cabecalho = {
        method: 'PUT',
        body: JSON.stringify(pedidoMsg),
        headers:{
            'Content-type':'application/json'
        }
    }

    fetch ("http://localhost:8080/pedidos/status", cabecalho)
    .then (res => res.json())
    .then (result => {if (result) buscarPorStatus() });
}



