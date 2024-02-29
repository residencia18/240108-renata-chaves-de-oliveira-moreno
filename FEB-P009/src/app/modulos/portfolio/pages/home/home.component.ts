import { Component } from '@angular/core';

// componentes
//import { ProjetosComponent } from '../../components/projetos/projetos.component';
import { HeaderComponent } from '../../components/header/header.component';
import { ConhecimentoComponent } from '../../components/conhecimento/conhecimento.component';
//import { ExperienciaComponent } from '../../components/experiencia/experiencia.component';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    HeaderComponent,
    HomeComponent,
    ConhecimentoComponent,
    //ExperienciaComponent,

  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
