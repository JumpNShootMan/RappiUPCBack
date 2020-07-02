import { Component, OnInit } from '@angular/core';
import { Especialidad } from '../model/especialidad';
import { Observable } from 'rxjs';
import { RappieduService } from '../rappiedu.service';

@Component({
  selector: 'app-especialidad-list',
  templateUrl: './especialidad-list.component.html',
  styleUrls: ['./especialidad-list.component.css']
})
export class EspecialidadListComponent implements OnInit {

  especialidades : Observable<Especialidad>
  constructor(private rappieduService: RappieduService) { }

  ngOnInit(): void {
    this.reloadData()
  }
  reloadData(){
    console.log("Reload!!!")
    this.rappieduService.getEspecialidadList().subscribe(especialidades => this.especialidades = especialidades);
  }


}
