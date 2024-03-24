import { Component, OnInit } from '@angular/core';
import { Suino } from '../../services/suino.model'; 
import { SuinoService } from '../../services/suinos.service';

@Component({
    selector: 'app-listagem-suinos',
    templateUrl: './listagem-suinos.component.html',
    styleUrls: ['./listagem-suinos.component.css']
})
export class ListagemSuinosComponent implements OnInit {
    suinos: Suino[] = [];
    suinosFiltrados: Suino[] = [];
    filtroBrincoPai: string = ''; 

    constructor(private suinoService: SuinoService) { }

    ngOnInit(): void {
        this.carregarSuinos();
    }

    carregarSuinos(): void {
        this.suinoService.getSuinos().subscribe((suinos: Suino[]) => {
            this.suinos = suinos;
            this.filtrarSuinos(); 
        }, (error: any) => {
            console.error('Erro ao carregar suínos:', error);
        });
    }

    filtrarSuinos(): void {
        this.suinosFiltrados = this.suinos.filter(suino => {
            return suino.brincoPai.toLowerCase().includes(this.filtroBrincoPai.toLowerCase());
        });
    }

    editarSuino(suino: Suino): void {
        // Implementação para editar suíno
    }

    deletarSuino(suino: Suino): void {
        const confirmacao = confirm('Tem certeza que deseja excluir este suíno?');
        if (confirmacao) {
            const suinoId = suino.id?.toString(); // Verificação de nulidade
            if (suinoId) {
                this.suinoService.deletarSuino(suinoId).subscribe(() => {
                    this.suinos = this.suinos.filter(s => s.id !== suino.id);
                    this.filtrarSuinos();
                }, (error: any) => {
                    console.error('Erro ao excluir suíno:', error);
                });
            } else {
                console.error('ID do suíno é indefinido.');
            }
        }
    }

    confirmarExclusao(suino: Suino): void {
        const confirmacao = confirm('Tem certeza que deseja excluir este suíno?');
        if (confirmacao) {
            this.deletarSuino(suino);
        }
    }
}
