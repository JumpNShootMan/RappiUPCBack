import { Component, OnInit } from '@angular/core';
import { Servicio } from '../model/servicio';
import { Profesor } from '../model/profesor';
import { RappieduService } from '../rappiedu.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-servicio-create',
  templateUrl: './servicio-create.component.html',
  styleUrls: ['./servicio-create.component.css']
})
export class ServicioCreateComponent implements OnInit {

  servicio: Servicio = new Servicio();
  profesores : Profesor[] = [];
  profesor: Profesor;
  constructor(private rappieduService: RappieduService,
              private router: Router) { }

  ngOnInit(): void {
    this.cargandoProfs();
  }

  cargandoProfs(){
    console.log("Cargando profesores")
    this.rappieduService.getProfesorList().subscribe(profesores => this.profesores = profesores);
    console.log(this.profesores);
  }

  setNomEsp(){
    this.servicio.nomEspecialidad = this.servicio.profesor.especialidad.nomEspecialidad;
  }

  save(){
    console.log(this.servicio);
    this.rappieduService.createServicio(this.servicio).subscribe(
      data => this.router.navigate(['RappiEDU/Profesor/ser-list'])

    )
  }

  compararTipoP(o1:Profesor, o2:Profesor) : boolean{
    if (o1===undefined && o2===undefined){
      return true;
    }
     return o1 === null || o2 === null || o1 === undefined || o2 === undefined  ? false : o1.idProfesor === o2.idProfesor
  }
  
}
