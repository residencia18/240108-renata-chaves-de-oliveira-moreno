import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Suino } from './suino.model';

@Injectable({
  providedIn: 'root'
})
export class SuinoService {
  private apiUrl = 'https://suinocultura-a16ad-default-rtdb.firebaseio.com/suinos.json';

  constructor(private http: HttpClient) {}

  getSuinos(): Observable<Suino[]> {
    return this.http.get<Suino[]>(this.apiUrl);
  }

  deletarSuino(id: string): Observable<void> {
    const url = `${this.apiUrl}/${id}.json`;
    return this.http.delete<void>(url);
  }
}
