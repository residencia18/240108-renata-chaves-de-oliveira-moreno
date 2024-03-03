import { Component, Input, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-detalhamento-atendimento',
  templateUrl: './detalhamento-atendimento.component.html',
  styleUrls: ['./detalhamento-atendimento.component.css']
})
export class DetalhamentoAtendimentoComponent implements OnInit {
  @Input() atendimentoId: string | undefined; // Recebe o ID do atendimento como entrada
  atendimento: any; // Objeto para armazenar os detalhes do atendimento

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    // Use o ID do atendimento para fazer uma solicitação HTTP e buscar os detalhes específicos do atendimento
    this.http.get<any>('http://localhost:3000/api/atendimentos/' + this.atendimentoId)
      .subscribe(data => {
        this.atendimento = data;
      });
  }
}
