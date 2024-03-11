import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Suino } from './suino.model';

@Injectable({
  providedIn: 'root'
})
export class SuinoService {
  private apiUrl = 'https://api.example.com/suinos';
  getPesos: any;
  salvarPesos: any;

  constructor(private http: HttpClient) { }

  getSuinos(): Observable<Suino[]> {
    return this.http.get<Suino[]>(this.apiUrl);
  }

  getPesoHistorico(id: string): Observable<number[]> {
    return this.http.get<number[]>(`${this.apiUrl}/${id}/peso`);
  }

}
