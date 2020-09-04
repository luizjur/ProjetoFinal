function validaLogin() {
    let userTxt = localStorage.getItem("userLogged");
    
    // verifica se o usuario esta logado
    if (!userTxt) {
        window.location = "index.html";
    }

    let jsonUser = JSON.parse(userTxt); // transforma o texto em json

    document.getElementById("user").innerHTML = `${jsonUser.nome} ( ${jsonUser.racf} )`;
    document.getElementById("imgUser").innerHTML = `<img src="${jsonUser.linkFoto}">`;

}

function logout() {
    localStorage.removeItem("userLogged");
    window.location = "index.html";
}

function buscarPorStatus() {
    let statusSelect = document.getElementById("sel_status");
    let statusValue = statusSelect[statusSelect.selectedIndex].value; // obter o valor do status selecionado.

    fetch("http://localhost:8080/solicitacao/status/" + statusValue)   // estou mandando para o banco de dados um pedido
    .then(res => res.json())
    .then( result => preencheResposta(result));
}

function preencheResposta(resposta) {

//    console.log(resposta); isto faz aparecer em cosole dentro de inspecionar no chrome

    let tbSolicitacoes = '<table class = "table"> <tr> <th>#</th> <th>Solicitante</th> <th>Operadora</th> <th>Telefone</th> <th>Doc</th> <th>Data</th> <th>Hora</th> <th>PDV</th> <th>Status</th> <th>Ação</th> </tr>';
    // assima estou montando um html e vou carregar em document.getElementById logo abaixo

    for (let index = 0; index < resposta.length; index++) {

        tbSolicitacoes = tbSolicitacoes + `<tr> <td> ${resposta[index].numSeq} </td>
        <td>  ${resposta[index].nomeTecnico}  </td> 
        <td>  ${resposta[index].operadora}  </td> 
        <td>  ${resposta[index].telefone}  </td> 
        <td>  ${resposta[index].doc}  </td> 
        <td>  ${resposta[index].data}  </td> 
        <td>  ${resposta[index].hora}  </td> 
        <td>  1  </td> 
        <td>  ${resposta[index].status}  </td>     
                                                                             
        <td> <button class="btn btn-sm btn-success" onclick="alterarStatus('A',${resposta[index].numSeq} )">Ap</button> 
 
        <button class="btn btn-sm btn-warning" onclick="alterarStatus('P',${resposta[index].numSeq} )">Ne</button> 

        <button class="btn btn-sm btn-danger" onclick="alterarStatus('C', ${resposta[index].numSeq} )">Ca</button> </td> 
   </tr>`;
}

tbSolicitacoes = tbSolicitacoes + '</table>';

document.getElementById("tableResposta").innerHTML = tbSolicitacoes;
}
        


