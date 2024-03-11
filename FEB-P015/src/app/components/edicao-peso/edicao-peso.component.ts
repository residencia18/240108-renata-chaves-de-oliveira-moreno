import { Component, OnInit } from '@angular/core';
import { SuinoService } from '../../services/suino.service';
import { Peso } from '../../models/peso.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-edicao-peso',
  templateUrl: './edicao-peso.component.html',
  styleUrls: ['./edicao-peso.component.css']
})
export class EdicaoPesoComponent implements OnInit {
  pesos: any[] = [];
  novoPeso: any = {};
  http: any;

  constructor(private suinoService: SuinoService) { } 

  ngOnInit(): void {
    this.carregarPesos();
  }

  carregarPesos(): void {
    this.suinoService.getPesos().subscribe((pesos: Peso[]) => {
      this.pesos = pesos;
      console.log('Pesos carregados:', this.pesos); // Adicione esta linha para depurar
    });
  }

  editarPeso(peso: any): void {
    console.log("Editando peso:", peso);
    // Implemente a lógica de edição aqui, por exemplo, abrir um modal com os detalhes do peso para edição.
  }

  salvarEdicao(): void {
    console.log("Salvando edições...");
    this.suinoService.salvarPesos(this.pesos).subscribe(() => {
      console.log("Alterações salvas com sucesso!");
      // Recarregar os pesos após salvar as edições
      this.carregarPesos();
    }, (error: any) => {
      console.error("Erro ao salvar alterações:", error);
    });

    // Enviar os dados ao Firebase
    this.enviarDadosAoFirebase();
  }

  enviarDadosAoFirebase(): void {
    // Supondo que você tenha uma URL de API do Firebase para enviar os dados
    const firebaseURL = 'https://suinocultura-a16ad-default-rtdb.firebaseio.com/pesos.json';

    // Fazer uma requisição HTTP POST para enviar os dados ao Firebase
    this.http.post(firebaseURL, this.pesos).subscribe(() => {
      console.log("Dados enviados ao Firebase com sucesso!");
    }, (error: any) => {
      console.error("Erro ao enviar dados ao Firebase:", error);
    });
  }

  adicionarPeso(): void {
    this.pesos.push(this.novoPeso);
    this.novoPeso = {}; // Limpar o objeto para adicionar um novo peso
  }

  excluirPeso(id: string): void {
    console.log("Excluindo peso com ID:", id);
    // Implemente a lógica de exclusão aqui, por exemplo, chamar o método no serviço para excluir o peso do servidor.
  }
}
