import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoginComponent } from './components/login/login.component';
import { RecuperarPasswordComponent } from './components/recuperar-password/recuperar-password.component';
import { RegistrarUsuarioComponent } from './components/registrar-usuario/registrar-usuario.component';
import { VerificarCorreoComponent } from './components/verificar-correo/verificar-correo.component';
import { CadastroGadoComponent } from './cadastro-gado/cadastro-gado.component';
import { ListaGadoComponent } from './lista-gado/lista-gado.component';
import { EditarGadoComponent } from './editar-gado/editar-gado.component';
import { CadastroPesoComponent } from './cadastro-peso/cadastro-peso.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'registrar-usuario', component: RegistrarUsuarioComponent },
  { path: 'verificar-correo', component: VerificarCorreoComponent },
  { path: 'recuperar-password', component: RecuperarPasswordComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'cadastro-gado', component: CadastroGadoComponent },
  { path: 'listagem-gado', component: ListaGadoComponent },
  { path: 'editar-gado', component: EditarGadoComponent },
  { path: 'cadastro-peso', component: CadastroPesoComponent },
  { path: '**', redirectTo: 'login', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
