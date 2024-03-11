import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-controle-peso',
  templateUrl: './controle-peso.component.html',
  styleUrls: ['./controle-peso.component.css']
})
export class ControlePesoComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
    this.renderizarGrafico();
  }

  renderizarGrafico(): void {
    const ctx = document.getElementById('pesoChart') as HTMLCanvasElement;
    new Chart(ctx, {
      type: 'line',
      data: {
        labels: ['01/01/2024', '01/02/2024', '01/03/2024', '01/04/2024'], // Exemplo de datas
        datasets: [{
          label: 'Peso do Animal',
          data: [10, 12, 11, 13], // Exemplo de pesos
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
