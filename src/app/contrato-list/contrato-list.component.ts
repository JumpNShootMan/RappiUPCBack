import { Component, OnInit } from '@angular/core';
import { Contrato } from '../model/contrato';
import { Observable } from 'rxjs';
import { RappieduService } from '../rappiedu.service';

@Component({
  selector: 'app-contrato-list',
  templateUrl: './contrato-list.component.html',
  styleUrls: ['./contrato-list.component.css']
})
export class ContratoListComponent implements OnInit {

  contratos: Observable<Contrato>
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
    this.rappieduService.getContratoList().subscribe(contratos => this.contratos = contratos);
  }
}
