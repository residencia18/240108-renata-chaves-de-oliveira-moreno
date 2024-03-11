import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Chart, registerables } from 'chart.js';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-cadastro-peso',
  templateUrl: './cadastro-peso.component.html',
  styleUrls: ['./cadastro-peso.component.css']
})
export class CadastroPesoComponent implements OnInit {
  pesoForm!: FormGroup;
  dadosPeso: { data: string, peso: number }[] = [];
  @ViewChild('pesoChart') pesoChart!: ElementRef;
  chart!: Chart;

  constructor(private fb: FormBuilder, private http: HttpClient) {
    Chart.register(...registerables);
  }

  ngOnInit(): void {
    this.pesoForm = this.fb.group({
      numeroBrinco: ['', Validators.required],
      dataPesagem: ['', Validators.required],
      peso: ['', Validators.required]
    });

    // Mock de dados de peso para teste
    this.dadosPeso = [
      { data: '2024-03-01', peso: 20 },
      { data: '2024-03-05', peso: 22 },
      { data: '2024-03-08', peso: 21 }
    ];

    this.generateChart();
  }

  submitPeso() {
    if (this.pesoForm.valid) {
      const dataPesagem = this.pesoForm.get('dataPesagem')!.value;
      const peso = this.pesoForm.get('peso')!.value;
      this.dadosPeso.push({ data: dataPesagem, peso: peso });
      this.generateChart();
      this.salvarDadosNoFirebase(); // Chama a função para salvar os dados no Firebase
      this.pesoForm.reset();
    }
  }

  salvarDadosNoFirebase() {
    const firebaseURL = 'https://suinocultura-a16ad-default-rtdb.firebaseio.com/pesos.json'; // Substitua pela URL do seu projeto Firebase
    this.http.post(firebaseURL, this.dadosPeso).subscribe(response => {
      console.log('Dados de peso salvos no Firebase:', response);
    }, error => {
      console.error('Erro ao salvar dados de peso no Firebase:', error);
    });
  }

  generateChart() {
    if (this.chart) {
      this.chart.destroy();
    }

    if (this.pesoChart) {
      const ctx = this.pesoChart.nativeElement.getContext('2d');
      this.chart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: this.dadosPeso.map(dado => dado.data),
          datasets: [{
            label: 'Peso do Animal (Kg)',
            data: this.dadosPeso.map(dado => dado.peso),
            borderColor: 'rgb(75, 192, 192)',
            tension: 0.1
          }]
        },
        options: {
          scales: {
            y: {
              title: {
                display: true,
                text: 'Peso (Kg)'
              }
            },
            x: {
              title: {
                display: true,
                text: 'Data da Pesagem'
              }
            }
          }
        }
      });
    }
  }
}
