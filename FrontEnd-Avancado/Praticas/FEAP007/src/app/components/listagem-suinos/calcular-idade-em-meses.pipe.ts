import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'calcularIdadeEmMeses'
})
export class CalcularIdadeEmMesesPipe implements PipeTransform {
  transform(dataNascimento: Date): string {
    const hoje = new Date();
    const meses = (hoje.getFullYear() - dataNascimento.getFullYear()) * 12;
    const mesesAteHoje = meses + hoje.getMonth() - dataNascimento.getMonth();
    return `${mesesAteHoje} meses`;
  }
}
