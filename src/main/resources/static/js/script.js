// Conteúdo de js/script.js

document.getElementById("mostrarSenha").addEventListener("change", function() {
    var senha = document.getElementById("senha");
    senha.type = this.checked ? "text" : "password";
});

function adicionarNumero(num) {
    document.getElementById("senha").value += num;
}

function limparSenha() {
    document.getElementById("senha").value = "";
}