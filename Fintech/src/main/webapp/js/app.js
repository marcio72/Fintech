//pegar o tbody na página
const tbody = document.querySelector('tbody');

//recuperar o form
document.querySelector('form').addEventListener('submit', function(e){
    e.preventDefault();

    const campos = [
        document.querySelector('#descricao'),
        document.querySelector('#valor'),
        document.querySelector('#dataCadastro'),
        document.querySelector('#categoria')
    ]

    //criar uma tr 
    const tr = document.createElement('tr');

    // criar um for para percorrer os campos no array e para cada ocorrência, executar função
    campos.forEach(campo => {

        // criar a td 
        const td = document.createElement('td');

        //passar o conteúdo para a td
        td.textContent = campo.value;

        //colocar a td na tr
        tr.appendChild(td);
    });

    // colocando a tr dentro do tbody
    tbody.appendChild(tr);

    //limpar o form
    this.reset();
})