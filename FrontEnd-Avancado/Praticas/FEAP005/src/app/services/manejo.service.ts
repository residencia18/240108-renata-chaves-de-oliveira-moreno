import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ManejoService {
  private apiUrl: string = `${environment.firebaseConfig.databaseURL}/manejo.json`;

  constructor(private http: HttpClient) {}

  salvarAtividade(atividade: any): Observable<any> {
    return this.http.post(this.apiUrl, atividade);
  }
}
