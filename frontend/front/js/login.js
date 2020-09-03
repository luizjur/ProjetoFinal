function autenticar(event) {
    event.preventDefault(); //interrampe a execução padrão de envio do formulario

    let usuario = document.getElementById("txtUsuario"); // declarando uma variavel comum
    let senha = document.getElementById("txtSenha");

    let loginMsg ={    // declarando um objeto
        email: usuario.value,
        cpf: usuario.value,
        senha: senha.value

    }

    let cabecalho = {
        method: 'POST',
        body: JSON.stringify(loginMsg),
        headers:{
            'Content-type':'application/json'
        }
    }

    // envia o pedido para outro servidor, e so continua (,then) quando chegar a resposta.
    fetch('http://localhost:8080/usuario/login',cabecalho) // este tipo de comunicação é entre duas maquinas, nosso caso esta na mesma maquina, usa o .then() que é tipo "então" espera ocorrer
    .then( res => tratarResposta(res) ); // usa o .then(), que é resposta do feth,  que é tipo "então" espera ocorrer, poderia estar na linha de cima.
    // res é a resposta que veio do backend.

}

/*
é igual a função abaixo, só que é chamada de função anonima, uso quando só é chamado uma vez!

(res)=>{

}
*/

function tratarResposta (res){
    if (res.status == 200) {
        res.json().then( res => fazerLogin(res) );
    }else{
        document.getElementById("msgErro").innerHTML = "Usuário/Senha invalido."
    }
}

function fazerLogin(res){
    // armazenar no local Storage os dados do usuario que fez o login
    localStorage.setItem("userLogged", JSON.stringify(res) ); // JSON.stringify transforma o Json em uma string
    window.location="relatorio.html"; // grava os dados do usuario e manda para uma nova pagina
}