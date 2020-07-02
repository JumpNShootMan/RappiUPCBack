import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

//Para llamar a REST...
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

// COMPONENTES:
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EspecialidadCreateComponent } from './especialidad-create/especialidad-create.component';
import { EspecialidadListComponent } from './especialidad-list/especialidad-list.component';
import { ProfesorListComponent } from './profesor-list/profesor-list.component';
import { ProfesorCreateComponent } from './profesor-create/profesor-create.component';
import { HomepageComponent } from './homepage/homepage.component';
import { ProfesorComponent } from './profesor/profesor.component';
import { EstudianteComponent } from './estudiante/estudiante.component';
import { ServicioCreateComponent } from './servicio-create/servicio-create.component';
import { ServicioListComponent } from './servicio-list/servicio-list.component';
import { EstudianteCreateComponent } from './estudiante-create/estudiante-create.component';
import { EstudianteListComponent } from './estudiante-list/estudiante-list.component';
import { DistritoListComponent } from './distrito-list/distrito-list.component';
import { DistritoCreateComponent } from './distrito-create/distrito-create.component';
import { ContratoCreateComponent } from './contrato-create/contrato-create.component';
import { ContratoListComponent } from './contrato-list/contrato-list.component';


@NgModule({
  declarations: [
    AppComponent,
    EspecialidadCreateComponent,
    EspecialidadListComponent,
    ProfesorListComponent,
    ProfesorCreateComponent,
    HomepageComponent,
    ProfesorComponent,
    EstudianteComponent,
    ServicioCreateComponent,
    ServicioListComponent,
    EstudianteCreateComponent,
    EstudianteListComponent,
    DistritoListComponent,
    DistritoCreateComponent,
    ServicioCreateComponent,
    ServicioListComponent,
    ContratoCreateComponent,
    ContratoListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
