import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-listagem-atendimentos',
  templateUrl: './listagem-atendimentos.component.html',
  styleUrls: ['./listagem-atendimentos.component.css']
})
export class ListagemAtendimentosComponent implements OnInit {
  atendimentos: any[] = [];
observacoes: any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.listarAtendimentos();
  }

  listarAtendimentos() {
    this.http.get<any[]>('http://localhost:3000/api/atendimentos').subscribe(
      (data) => {
        this.atendimentos = data;
      },
      (error) => {
        console.error('Erro ao listar atendimentos:', error);
      }
    );
  }
}
