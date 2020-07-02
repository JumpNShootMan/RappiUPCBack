import { Component, OnInit } from '@angular/core';
import { Especialidad } from '../model/especialidad';
import { RappieduService } from '../rappiedu.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-especialidad-create',
  templateUrl: './especialidad-create.component.html',
  styleUrls: ['./especialidad-create.component.css']
})
export class EspecialidadCreateComponent implements OnInit {

  especialidad: Especialidad = new Especialidad();
  constructor(private rappieduService: RappieduService,
              private router: Router) { }

  ngOnInit(): void {
  }

  save(){
    console.log(this.especialidad);
    this.rappieduService.createEspecialidad(this.especialidad).subscribe(
      data => this.router.navigate(['RappiEDU/Profesor/esp-list']) //luego ir a list para ver si se ha creado el producto
    )
  }
}
