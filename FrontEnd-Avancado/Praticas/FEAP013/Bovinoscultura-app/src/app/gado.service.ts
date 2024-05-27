import { Injectable } from '@angular/core';
import { AngularFireDatabase } from '@angular/fire/compat/database';
import { Observable } from 'rxjs';
import { map, distinctUntilChanged, tap } from 'rxjs/operators';
import { combineLatest } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class GadoService {
  constructor(private db: AngularFireDatabase) { }

  obterAnilhasPai(): Observable<string[]> {
    return this.db.list<any>('gados').valueChanges().pipe(
      map(gados => gados.map(gado => gado.anilhaPai)),
      distinctUntilChanged()
    );
  }

  obterBovinosComPesoDataPesagem(): Observable<any[]> {
    return combineLatest([
      this.db.list<any>('gados').valueChanges(),
      this.db.list<any>('cadastro-peso').valueChanges()
    ]).pipe(
      map(([gados, pesos]) => {
        // Combinar os dados das duas tabelas com base em uma chave estrangeira comum
        // Supondo que haja uma chave 'id' comum em ambas as tabelas
        return gados.map(gado => {
          const pesoGado = pesos.find(peso => peso.id === gado.id);
          return {
            ...gado,
            pesoKg: pesoGado ? pesoGado.pesokg : null,
            dataPesagem: pesoGado ? pesoGado.dataPesagem : null
          };
        });
      })
    );
  }
}