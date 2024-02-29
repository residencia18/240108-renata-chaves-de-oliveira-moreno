// estilizar-categorias.directive.ts
import { Directive, ElementRef, Renderer2, Input, OnInit } from '@angular/core';

@Directive({
  selector: '[estilizarCategorias]',
})
export class EstilizarCategoriasDirective implements OnInit {
  @Input() cor: string = 'blue'; // Cor padrão

  constructor(private el: ElementRef, private renderer: Renderer2) {}

  ngOnInit() {
    this.renderer.setStyle(this.el.nativeElement, 'color', this.cor);
  }
}