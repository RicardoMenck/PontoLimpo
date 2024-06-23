import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { SobreComponent } from './components/sobre/sobre.component';
import { CriarTicketComponent } from './components/tickets/criar-ticket/criar-ticket.component';
import { ListarTicketComponent } from './components/tickets/listar-ticket/listar-ticket.component';

const routes: Routes = [
  { path: '', pathMatch:'full', redirectTo: 'home' },
  { path: '**', redirectTo: 'ticket' },
  { path: 'home', component: HomeComponent },
  { path: 'sobre', component: SobreComponent },
  { path: 'ticket', component: CriarTicketComponent },
  { path: 'listar-ticket', component: ListarTicketComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
