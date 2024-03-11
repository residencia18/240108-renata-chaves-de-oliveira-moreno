import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtroSuinos'
})
export class FiltroSuinosPipe implements PipeTransform {

  transform(suinos: any[], filtroBrincoPai: string): any[] {
    if (!suinos || !filtroBrincoPai) {
      return suinos;
    }

    
    return suinos.filter(suino => suino.brincoPai.toLowerCase().includes(filtroBrincoPai.toLowerCase()));
  }

}
