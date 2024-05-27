import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BovinoService {
  private baseUrl = 'https://gadoscultura-app-default-rtdb.firebaseio.com';

  constructor(private http: HttpClient) { }

  // Método para obter os bovinos
  obterBovinos(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/bovinos.json`);
  }
}
