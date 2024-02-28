function exibirFormulario(nome, inclusoPacote, preco, taxasInclusas, formaPagamento) {
    document.getElementById('nomeDestino').value = nome;
    document.getElementById('inclusoPacote').value = inclusoPacote;
    document.getElementById('preco').value = preco;
    document.getElementById('taxasInclusas').value = taxasInclusas === 'Taxas Inclusas' ? 'sim' : 'nao';
    document.getElementById('formaPagamento').value = formaPagamento;

    document.getElementById('formularioContainer').style.display = 'block';
}

function inserirDestino() {
    const nomeDestino = document.getElementById('nomeDestino').value;
    const imagemURL = document.getElementById('imagemURL').value; // Adicionado campo de URL da imagem
    const inclusoPacote = document.getElementById('inclusoPacote').value;
    const preco = document.getElementById('preco').value;
    const taxasInclusas = document.getElementById('taxasInclusas').value;
    const formaPagamento = document.getElementById('formaPagamento').value;

    const novoDestino = document.createElement('div');
    novoDestino.className = 'roteiros-viagens';

    novoDestino.innerHTML = `
        <img src="${imagemURL}" class="postal" alt="${nomeDestino}">
        <div class="roteiro-destino">${nomeDestino}</div>
        <ul class="roteiro-incluso">
            <li>${inclusoPacote}</li>
        </ul>
        <div class="roteiro-preco">${preco}</div>
        <div class="roteiro-obs">${taxasInclusas === 'sim' ? 'Taxas Inclusas' : 'Taxas não Inclusas'}</div>
        <div class="roteiro-parcelamento">${formaPagamento}</div>
        <button class="roteiro-comprar" onclick="exibirFormulario('${nomeDestino}', '${inclusoPacote}', '${preco}', '${taxasInclusas === 'sim' ? 'Taxas Inclusas' : 'Taxas não Inclusas'}', '${formaPagamento}')">Comprar</button>
    `;

    document.getElementById('containerDestinos').appendChild(novoDestino);
    document.getElementById('formulario').reset();
    document.getElementById('formularioContainer').style.display = 'none';
}
