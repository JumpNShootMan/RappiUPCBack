import { Component, OnInit } from '@angular/core';
import { Profesor } from '../model/profesor';
import { Observable } from 'rxjs';
import { RappieduService } from '../rappiedu.service';

@Component({
  selector: 'app-profesor-list',
  templateUrl: './profesor-list.component.html',
  styleUrls: ['./profesor-list.component.css']
})
export class ProfesorListComponent implements OnInit {

  profesores: Observable<Profesor>
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
    this.rappieduService.getProfesorList().subscribe(profesores => this.profesores = profesores);
  }

}
