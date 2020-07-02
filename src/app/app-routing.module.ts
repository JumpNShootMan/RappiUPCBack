import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Componentes:
import {EspecialidadListComponent} from './especialidad-list/especialidad-list.component';
import {EspecialidadCreateComponent} from './especialidad-create/especialidad-create.component'

import {ProfesorCreateComponent} from './profesor-create/profesor-create.component';
import {ProfesorListComponent} from './profesor-list/profesor-list.component';
import {EstudianteComponent} from './estudiante/estudiante.component';
import {ProfesorComponent} from './profesor/profesor.component';
import {HomepageComponent} from './homepage/homepage.component';
import {EstudianteCreateComponent} from './estudiante-create/estudiante-create.component';
import {EstudianteListComponent} from './estudiante-list/estudiante-list.component';
import {DistritoCreateComponent} from './distrito-create/distrito-create.component';
import {DistritoListComponent} from './distrito-list/distrito-list.component';
import { ServicioListComponent } from './servicio-list/servicio-list.component';
import { ServicioCreateComponent } from './servicio-create/servicio-create.component';
import { ContratoListComponent } from './contrato-list/contrato-list.component';
import { ContratoCreateComponent } from './contrato-create/contrato-create.component';

const routes: Routes = [
  {path: '', redirectTo: 'RappiEDU', pathMatch:'full'},
  {path: 'RappiEDU', component: HomepageComponent},
  {path: 'RappiEDU/Profesor', component: ProfesorComponent},
  {path: 'RappiEDU/Estudiante', component: EstudianteComponent},
  {path: 'RappiEDU/Profesor/prof-list', component: ProfesorListComponent},
  {path: 'RappiEDU/Profesor/prof-new', component: ProfesorCreateComponent},
  {path: 'RappiEDU/Estudiante/estu-list', component: EstudianteListComponent},
  {path: 'RappiEDU/Estudiante/estu-new', component: EstudianteCreateComponent},
  {path: 'RappiEDU/Profesor/esp-list', component: EspecialidadListComponent},
  {path: 'RappiEDU/Profesor/esp-new', component: EspecialidadCreateComponent},
  {path: 'RappiEDU/Estudiante/dis-list', component: DistritoListComponent},
  {path: 'RappiEDU/Estudiante/dis-new', component: DistritoCreateComponent},
  {path: 'RappiEDU/Profesor/ser-list', component: ServicioListComponent},
  {path: 'RappiEDU/Profesor/ser-new', component: ServicioCreateComponent},
  {path: 'RappiEDU/Estudiante/con-list', component: ContratoListComponent},
  {path: 'RappiEDU/Estudiante/con-new', component: ContratoCreateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
