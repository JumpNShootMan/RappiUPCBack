import { Component, OnInit } from '@angular/core';
import { Estudiante } from '../model/estudiante';
import { RappieduService } from '../rappiedu.service';
import { Router } from '@angular/router';
import { Distrito } from '../model/distrito';


@Component({
  selector: 'app-estudiante-create',
  templateUrl: './estudiante-create.component.html',
  styleUrls: ['./estudiante-create.component.css']
})
export class EstudianteCreateComponent implements OnInit {

  estudiante: Estudiante = new Estudiante();
  //distrito : Distrito = new Distrito();
  distritos: Distrito[] = [];

  constructor(private rappieduService: RappieduService,
              private router: Router) { }

  ngOnInit(): void {
    this.cargando();
  }

  cargando(){
    console.log("Cargando distritos")
    this.rappieduService.getDistritos().subscribe(distritos=> this.distritos = distritos);
    console.log(this.distritos);
  }

  save(){
    console.log(this.estudiante);

    this.rappieduService.createEstudiante(this.estudiante).subscribe(
      data => this.router.navigate(['RappiEDU/Estudiante/estu-list']) //luego ir a list para ver si se ha creado el producto
    )
  }
//lmfao(){
//  console.log(this.distrito.idDistrito);
//}
  compararTipo(o1:Distrito, o2:Distrito) : boolean{
    if (o1===undefined && o2===undefined){
      return true;
    }
     return o1 === null || o2 === null || o1 === undefined || o2 === undefined  ? false : o1.idDistrito === o2.idDistrito
  }
}
