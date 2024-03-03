import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroAtendimentoComponent } from './cadastro-atendimento/cadastro-atendimento.component';
import { ListagemAtendimentosComponent } from './listagem-atendimentos/listagem-atendimentos.component';
import { AtendimentosComponent } from './atendimentos/atendimentos.component';
import { DetalhamentoAtendimentoComponent } from './detalhamento-atendimento/detalhamento-atendimento.component'; // Importe o DetalhamentoAtendimentoComponent

const routes: Routes = [
  { path: 'atendimentos', component: AtendimentosComponent },
  { path: 'cadastro-atendimento', component: CadastroAtendimentoComponent },
  { path: 'detalhamento-atendimento', component: DetalhamentoAtendimentoComponent }, // Adicione a rota para o DetalhamentoAtendimentoComponent
  { path: 'listagem-atendimentos', component: ListagemAtendimentosComponent },
  // Adicione outras rotas conforme necessário
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
