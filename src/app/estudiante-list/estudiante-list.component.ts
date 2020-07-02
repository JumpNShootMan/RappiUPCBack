import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { RappieduService } from '../rappiedu.service';
import { Estudiante } from '../model/estudiante';

@Component({
  selector: 'app-estudiante-list',
  templateUrl: './estudiante-list.component.html',
  styleUrls: ['./estudiante-list.component.css']
})
export class EstudianteListComponent implements OnInit {

  estudiantes: Observable<Estudiante>
  fId: number;
  constructor(private rappieduService: RappieduService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  procesarClick(){
    this.rappieduService.getEstudianteListId(this.fId).subscribe(estudiantes =>this.estudiantes = estudiantes);
  }

  reloadData(){
    console.log("Reload!!!")
    this.rappieduService.getEstudianteList().subscribe(estudiantes => this.estudiantes = estudiantes);
  }

}
