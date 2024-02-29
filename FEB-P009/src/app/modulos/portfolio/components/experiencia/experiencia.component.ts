import { Component, signal } from '@angular/core';
import { IExperiencia } from '../../interface/IExperiencia.interface';

@Component({
  selector: 'app-experiencia',
  standalone: true,
  imports: [],
  templateUrl: './experiencia.component.html',
  styleUrl: './experiencia.component.css'
})
export class ExperienciaComponent {
  public arrayExperiencia = signal<IExperiencia[]>([
    {
      summary:{
      strong:'FEB-P008',
      p: 'Prática'
    },
    text:'<p>Inserir o texto relacionado </p>'
  },
  {
    summary:{
    strong:'FEB-P007',
    p: 'Prática'
  },
  text:'<p>Inserir o texto relacionado </p>'
},

{
  summary:{
  strong:'FEB-P006',
  p: 'Prática'
},
  text:'<p>Inserir o texto relacionado </p>'
},

  ])
}
