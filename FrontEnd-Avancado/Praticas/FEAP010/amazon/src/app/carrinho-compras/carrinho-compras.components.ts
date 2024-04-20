import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

export interface Item {
  Id: number;
  Name: string;
  Price: number;
  Quantity: number;
  imgURL: string;
}

@Component({
  selector: 'app-carrinho-compras',
  templateUrl: './carrinho-compras.components.html',
  styleUrls: ['./carrinho-compras.components.css']
})
export class CarrinhoComprasComponent implements OnInit {
  listaDeItens: BehaviorSubject<Item[]> = new BehaviorSubject<Item[]>([]);
  subtotal: { total: string, quantidade: number } = { total: 'R$ 0,00', quantidade: 0 };

  constructor() {}

  ngOnInit(): void {
    // Exemplos de produtos
    const produtos: Item[] = [
      { Id: 1, Name: 'Smartphone', Price: 1500, Quantity: 0, imgURL: 'https://imgs.casasbahia.com.br/55058035/1g.jpg' },
      { Id: 2, Name: 'Notebook', Price: 2500, Quantity: 0, imgURL: 'https://www.havan.com.br/media/catalog/product/cache/73a52df140c4d19dbec2b6c485ea6a50/n/o/notebook-samsung-intel-celeron-4gb-ram-256gb-tela-de-15-6-w11-home_808259.jpg' },
      { Id: 3, Name: 'Fone de Ouvido', Price: 100, Quantity: 0, imgURL: 'https://m.media-amazon.com/images/I/51h6Ac2ILJL._AC_UF1000,1000_QL80_.jpg' },
      { Id: 4, Name: 'Relogio', Price: 1000, Quantity: 0, imgURL: 'https://cienciamodernaonline.vteximg.com.br/arquivos/ids/171418-400-400/51Z9dFrN97L._AC_SL1000_.jpg' },
      { Id: 5, Name: 'RTX 3080TI', Price: 21000, Quantity: 0, imgURL: 'https://www.nvidia.com/content/dam/en-zz/Solutions/geforce/ampere/rtx-3080-3080ti/geforce-rtx-3080-ti-product-gallery-thumbnail-267-3.jpg' },
      { Id: 6, Name: 'Monitor Gamer Samsung Odyssey G5 34', Price: 3000, Quantity: 0, imgURL: 'https://images.kabum.com.br/produtos/fotos/155193/monitor-gamer-samsung-odyssey-g5-34-curvo-165hz-1ms-ultra-wqhd-hdmi-displayport-amd-freesync-premium-preto-lc34g55twwlxzd_1617796502_gg.jpg' },
    ];

    // Inicializa a lista de itens no carrinho com os produtos
    this.listaDeItens.next(produtos);

    // Inicializa o subtotal como zero
    this.subtotal = { total: 'R$ 0,00', quantidade: 0 };
  }

  adicionarAoCarrinho(item: Item) {
    const itensAtuais = this.listaDeItens.getValue();
    this.listaDeItens.next([...itensAtuais, item]);
    this.subtotal = this.calcularSubtotal([...itensAtuais, item]);
  }

  calcularSubtotal(itens: Item[]): { total: string, quantidade: number } {
    let total = 0;
    let quantidade = 0;
    itens.forEach(item => {
      total += item.Price * item.Quantity;
      quantidade += item.Quantity;
    });
    return { total: this.formatarMoeda(total), quantidade };
  }

  removerItemDoCarrinho(index: number) {
    const itensAtuais = this.listaDeItens.getValue();
    itensAtuais.splice(index, 1);
    this.listaDeItens.next(itensAtuais);
    this.subtotal = this.calcularSubtotal(itensAtuais);
  }

  aumentarQuantidade(index: number) {
    const itensAtuais = this.listaDeItens.getValue();
    itensAtuais[index].Quantity++;
    this.listaDeItens.next(itensAtuais);
    this.subtotal = this.calcularSubtotal(itensAtuais);
  }

  diminuirQuantidade(index: number) {
    const itensAtuais = this.listaDeItens.getValue();
    if (itensAtuais[index].Quantity > 0) {
      itensAtuais[index].Quantity--;
    }
    this.listaDeItens.next(itensAtuais);
    this.subtotal = this.calcularSubtotal(itensAtuais);
  }

  formatarMoeda(valor: number): string {
    return valor.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
  }
}