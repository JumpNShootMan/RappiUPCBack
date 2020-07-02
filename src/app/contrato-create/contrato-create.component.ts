import { Component, OnInit } from '@angular/core';
import { Contrato } from '../model/contrato';
import { RappieduService } from '../rappiedu.service';
import { Router } from '@angular/router';
import { Servicio } from '../model/servicio';
import { Estudiante } from '../model/estudiante';

@Component({
  selector: 'app-contrato-create',
  templateUrl: './contrato-create.component.html',
  styleUrls: ['./contrato-create.component.css']
})
export class ContratoCreateComponent implements OnInit {

  contrato: Contrato = new Contrato();
  servicios : Servicio[] = [];
  estudiantes: Estudiante[] = [];
  constructor(private rappieduService: RappieduService,
              private router: Router) { }

  ngOnInit(): void {
    this.cargandoServ();
    this.cargandoEstu();
  }

  cargandoServ(){
    console.log("Cargando servicios")
    this.rappieduService.getServicioList().subscribe(servicios => this.servicios = servicios);
    console.log(this.servicios);
  }

  cargandoEstu(){
    console.log("Cargando estudiantes")
    this.rappieduService.getEstudianteList().subscribe(estudiantes => this.estudiantes = estudiantes);
    console.log(this.estudiantes);
  }

  save(){
    console.log(this.contrato);
    this.rappieduService.createContrato(this.contrato).subscribe(
      data => this.router.navigate(['RappiEDU/Estudiante/con-list']) 
      //con navigate... 
      //luego ir a list para ver si se ha creado
      //el profesor
    )
  }

  compararTipoS(o1:Servicio, o2:Servicio) : boolean{
    if (o1===undefined && o2===undefined){
      return true;
    }
     return o1 === null || o2 === null || o1 === undefined || o2 === undefined  ? false : o1.idServicio === o2.idServicio
  }

  compararTipoE(o1:Estudiante, o2:Estudiante) : boolean{
    if (o1===undefined && o2===undefined){
      return true;
    }
     return o1 === null || o2 === null || o1 === undefined || o2 === undefined  ? false : o1.idEstudiante === o2.idEstudiante
  }

}
