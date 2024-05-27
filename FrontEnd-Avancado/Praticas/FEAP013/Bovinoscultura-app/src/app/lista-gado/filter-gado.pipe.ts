import { Pipe, PipeTransform } from '@angular/core';
import { Gado } from '../gado.model'; 

@Pipe({
  name: 'filterGados'
})
export class FilterGadoPipe implements PipeTransform {
  transform(gado: Gado[], filtroAnilhaPai: string): Gado[] {
    if (!gado || !filtroAnilhaPai) {
      return gado;
    }

    return gado.filter(g => {
      const anilhaPaiString = g.anilhaPai.toString(); // Converte para string
      return anilhaPaiString.toLowerCase().includes(filtroAnilhaPai.toLowerCase());
    });
  }
}
