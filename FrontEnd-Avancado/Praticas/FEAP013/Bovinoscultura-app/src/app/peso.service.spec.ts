
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PesoService {
  private baseUrl = 'https://gadoscultura-app-default-rtdb.firebaseio.com';

  constructor(private http: HttpClient) { }

  obterAnilhas(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/anilhas.json`);
  }

  // Outros métodos do serviço
}
