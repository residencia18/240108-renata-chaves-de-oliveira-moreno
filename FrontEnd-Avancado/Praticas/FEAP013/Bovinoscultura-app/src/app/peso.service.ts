import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PesoService {
  private baseUrl = 'https://gadoscultura-app-default-rtdb.firebaseio.com'; // URL do Firebase

  constructor(private http: HttpClient) {}

  cadastrarPeso(data: any): Observable<any> {
    // Enviar os dados para o Firebase Realtime Database
    return this.http.post(`${this.baseUrl}/cadastro-peso.json`, data);
  }
}
