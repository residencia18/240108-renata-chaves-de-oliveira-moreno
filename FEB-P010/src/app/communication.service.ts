// comunicacao.service.ts
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComunicacaoService {
  private veiculoSubject = new Subject<any>();

  veiculoObservable$ = this.veiculoSubject.asObservable();

  enviarVeiculo(veiculo: any) {
    this.veiculoSubject.next(veiculo);
  }
}
