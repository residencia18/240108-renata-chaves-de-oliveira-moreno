
    document.addEventListener("DOMContentLoaded", function () {
        console.log('Script.js carregado com sucesso!');
     

function fetchNoticias() {
    console.log('Iniciando fetchNoticias...');

    const noticiasContainer = document.getElementById('itens_noticias');
    const rssFeedUrl = 'https://news.google.com/rss?hl=pt-BR&gl=BR&ceid=BR:pt-419';

    fetch(rssFeedUrl)
        .then(response => response.text())
        .then(data => {
            console.log('Dados recebidos:', data);

            noticiasContainer.innerHTML = '';

            const parser = new DOMParser();
            const xmlDoc = parser.parseFromString(data, 'application/xml');
            const items = xmlDoc.querySelectorAll('item');

            if (items.length === 0) {
                console.log('Nenhuma notícia encontrada.');
            }

            items.forEach(item => {
                const title = item.querySelector('title').textContent;
                const link = item.querySelector('link').textContent;

                console.log('Notícia encontrada:', title, link);

                const h4 = document.createElement('h4');
                h4.textContent = title;

                const a = document.createElement('a');
                a.href = link;
                a.textContent = 'Ir para notícia';

                const p = document.createElement('p');
                p.appendChild(h4);
                p.appendChild(a);

                const container = document.createElement('div'); // Criar um contêiner para cada notícia
                container.appendChild(p);

                noticiasContainer.appendChild(container);
            });
        })
        .catch(error => console.error('Erro ao buscar notícias:', error));
}

// Chame a função para buscar notícias
fetchNoticias();



    // Função para buscar previsão do tempo
    function fetchPrevisaoTempo() {
        console.log('Iniciando fetchPrevisaoTempo...');

        const previsaoTempoContainer = document.getElementById('previsao_tempo_conteudo');
        const apiKey = 'c6311528f49168491d3c0a45eaf0786d'; 
        const cidade = 'Ilheus'; 

        const apiUrl = `https://api.openweathermap.org/data/2.5/weather?q=${cidade}&appid=${apiKey}&units=metric`;

        fetch(apiUrl)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Erro na solicitação: ${response.status} ${response.statusText}`);
                }
                return response.json();
            })
            .then(data => {
                console.log('Dados da previsão do tempo:', data);

                previsaoTempoContainer.innerHTML = '';

                const h4 = document.createElement('h4');
                h4.textContent = 'Previsão do Tempo';

                const p = document.createElement('p');
                p.textContent = `Temperatura: ${data.main.temp}°C, Condição: ${data.weather[0].description}`;

                previsaoTempoContainer.appendChild(h4);
                previsaoTempoContainer.appendChild(p);
            })
            .catch(error => console.error('Erro ao buscar previsão do tempo:', error));
    }

    // Função para buscar informações aleatórias
    function fetchInformacoesAleatorias() {
        console.log('Iniciando fetchInformacoesAleatorias...');

        const informacoesAleatoriasContainer = document.getElementById('quadro_informacoes');

        // Substitua 'URL_DA_API_DE_INFORMACOES' pela URL da API desejada para informações aleatórias
        const informacoesAleatoriasUrl = 'https://www.boredapi.com/api/';

        fetch(informacoesAleatoriasUrl)
            .then(response => response.json())
            .then(data => {
                console.log('Dados de informações aleatórias:', data);

                informacoesAleatoriasContainer.innerHTML = '';

                const h4 = document.createElement('h4');
                h4.textContent = data.title; // Substitua 'title' pelo campo real dos dados

                const p = document.createElement('p');
                p.textContent = data.content; // Substitua 'content' pelo campo real dos dados

                informacoesAleatoriasContainer.appendChild(h4);
                informacoesAleatoriasContainer.appendChild(p);
            })
            .catch(error => console.error('Erro ao buscar informações aleatórias:', error));
    }

    // Chame as funções para buscar os dados
    fetchNoticias();
    fetchPrevisaoTempo();
    fetchInformacoesAleatorias();
});
