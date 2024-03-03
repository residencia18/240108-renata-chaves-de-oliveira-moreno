// atendimento.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AtendimentoService {
  constructor(private http: HttpClient) {}

  cadastrarAtendimento(atendimento: any): Observable<any> {
    return this.http.post<any>('http://localhost:3000/api/atendimentos', atendimento);
  }

  listarAtendimentos(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:3000/api/atendimentos');
  }
}
