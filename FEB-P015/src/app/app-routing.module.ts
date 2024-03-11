import { ControlePesoComponent } from './components/controle-peso/controle-peso.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { RegistrarUsuarioComponent } from './components/registrar-usuario/registrar-usuario.component';
import { VerificarCorreoComponent } from './components/verificar-correo/verificar-correo.component';
import { RecuperarPasswordComponent } from './components/recuperar-password/recuperar-password.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CadastroPesoComponent } from './components/cadastro-peso/cadastro-peso.component';
import { CadastroSuinoComponent } from './components/cadastro-suino/cadastro-suino.component';
import { EdicaoPesoComponent } from './components/edicao-peso/edicao-peso.component';
import { ListagemSuinosComponent } from './components/listagem-suinos/listagem-suinos.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'registrar-usuario', component: RegistrarUsuarioComponent },
  { path: 'verificar-correo', component: VerificarCorreoComponent },
  { path: 'recuperar-password', component: RecuperarPasswordComponent },
  { path: 'dashboard',  component: DashboardComponent},
  { path: 'cadastro-peso', component: CadastroPesoComponent },
  { path: 'cadastro-suino', component: CadastroSuinoComponent },
  { path: 'controle-peso', component: ControlePesoComponent },
 
  { path: 'edicao-peso', component: EdicaoPesoComponent },
  { path: 'listagem-suinos', component: ListagemSuinosComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
