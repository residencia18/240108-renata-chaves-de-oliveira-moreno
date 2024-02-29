import { Component, signal } from '@angular/core';

// interface
import { IConhecimento } from '../../interface/IConhecimento.interface';

@Component({
  selector: 'app-conhecimento',
  standalone: true,
  imports: [],
  templateUrl: './conhecimento.component.html',
  styleUrl: './conhecimento.component.css'
})
export class ConhecimentoComponent {
  public arrayConhecimento = signal<IConhecimento[]>([
       {
      src: 'assets/icons/conhecimento/html-5.png',
      alt: 'Ícone de conhecimento'
    },
    {
      src: 'assets/icons/conhecimento/angular.png',
      alt: 'Ícone de conhecimento'
    },
    {
      src: 'assets/icons/conhecimento/css.png',
      alt: 'Ícone de conhecimento'
    },
    {
      src: 'assets/icons/conhecimento/ts.png',
      alt: 'Ícone de conhecimento'
    },

    {
      src: 'assets/icons/conhecimento/nodes.png',
      alt: 'Ícone de conhecimento'
    },

    {
      src: 'assets/icons/conhecimento/javascript.png',
      alt: 'Ícone de conhecimento'
    },

  ]);

}
