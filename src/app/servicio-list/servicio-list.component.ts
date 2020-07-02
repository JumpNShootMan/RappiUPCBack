import { Component, OnInit } from '@angular/core';
import { Servicio } from '../model/servicio';
import { Observable } from 'rxjs';
import { RappieduService } from '../rappiedu.service';

@Component({
  selector: 'app-servicio-list',
  templateUrl: './servicio-list.component.html',
  styleUrls: ['./servicio-list.component.css']
})
export class ServicioListComponent implements OnInit {

  servicios: Observable<Servicio>
  fId: number;
  constructor(private rappieduService: RappieduService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  // procesarClick(){
  //   this.rappieduService.getProfesorListId(this.fId).subscribe(profesores =>this.profesores = profesores);
  // }

  reloadData(){
    console.log("Reload!!!")
    this.rappieduService.getServicioList().subscribe(servicios => this.servicios = servicios);
  }
}
