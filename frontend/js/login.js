function autenticar(event) {
    // Interrompe a execução padrão de envio do formulario
    event.preventDefault();

    // Obtem informações dos campos do formulário
    let usuario = document.getElementById("txtUsuario");
    let senha = document.getElementById("txtSenha");

    // Conteúdo do corpo da mensagem para o back-end
    let loginMsg = {
        racf: usuario.value,
        email: usuario.value,
        senha: senha.value
    }

    // Cabeçalho da mensagem HTTP
    let cabecalho = {
        method: 'POST',
        body: JSON.stringify(loginMsg),
        headers:{
            'Content-type':'application/json'
        }
    }

    // Executa o envio da mensagem HTTP
    fetch('http://localhost:8080/usuario/login', cabecalho)
    .then(res => tratarResposta(res));

}

function tratarResposta (res){
    if( res.status == 200 ){
        res.json().then( res => fazerLogin(res));
    }else{
        document.getElementById("msgErro").innerHTML = "Usuário/Senha inválidos"
    }

}

function fazerLogin(res){
    // Armazenar no localStorage os dados do usuário que fez o login
    localStorage.setItem("userLogged", JSON.stringify(res));
    window.location="dashboard.html";
}